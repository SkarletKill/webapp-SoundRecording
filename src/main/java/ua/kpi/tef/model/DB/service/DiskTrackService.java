package ua.kpi.tef.model.DB.service;

import ua.kpi.tef.model.DB.dao.Database;
import ua.kpi.tef.model.DB.entity.Disk;
import ua.kpi.tef.model.DB.entity.DiskTrack;
import ua.kpi.tef.model.DB.entity.Track;
import ua.kpi.tef.model.TrackList;
import ua.kpi.tef.model.exeptions.DiskSpaceExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DiskTrackService {
    private static DiskTrackService instance;

    public static DiskTrackService getInstance() {
        if (instance == null) {
            instance = new DiskTrackService();
        }
        return instance;
    }

    public void recordTracks(String diskName, TrackList trackList) throws DiskSpaceExeption {
        Disk disk = Database.disksDao().getByTitle(diskName);
        if (disk == null) return;

        long size = trackList.stream().map(Track::getSizeKB).mapToLong(Long::valueOf).sum();
        if (size > disk.getFreeCapacity()) throw new DiskSpaceExeption();
        disk.setFreeCapacity(disk.getFreeCapacity() - size);

        for (Track track : trackList) {
            Database.tracksDao().insertSafe(track);
        }

        for (Track track : trackList) {
            Track fromDB = Database.tracksDao().getByTitle(track.getTitle());
            track.setId(Objects.requireNonNull(fromDB).getId());
        }

        List<Integer> trackIds = trackList.stream().map(Track::getId).collect(Collectors.toList());
        for (Integer trackId : trackIds) {
            Database.diskTrackDao().insert(disk.getId(), trackId);
        }

        Database.disksDao().update(disk);
    }

    public List<Track> getTracksForDisk(Disk disk) {
        List<DiskTrack> allForDisk = Database.diskTrackDao().getAllForDisk(disk.getId());
        List<Track> trackList = new ArrayList<>();
        for (DiskTrack diskTrack : allForDisk) {
            Track track = Database.tracksDao().getById(diskTrack.getTrackId());
            trackList.add(track);
        }
        return trackList;
    }
}