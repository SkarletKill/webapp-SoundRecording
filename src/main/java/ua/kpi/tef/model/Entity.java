package ua.kpi.tef.model;

import ua.kpi.tef.model.DB.dao.Database;
import ua.kpi.tef.model.DB.entity.Disk;
import ua.kpi.tef.model.DB.entity.Genre;
import ua.kpi.tef.model.DB.entity.Track;
import ua.kpi.tef.model.DB.service.DiskTrackService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SkarletRED on 17.04.2018.
 */

public class Entity {
    private Disk disk;
    private TrackList trackList;
    private List<Track> diskTrackList;

    public Entity() {
        this.disk = new Disk("Please select disk", 0);
        this.trackList = new TrackList();
        this.diskTrackList = new ArrayList<>();
    }

    /**
     * @param disk
     * @return the duration of songs on the disk
     */
    public long countDuration(Disk disk) {
        TrackList trackList = new TrackList(DiskTrackService.getInstance().getTracksForDisk(disk));
        trackList.countDuration();
        return trackList.getSongsDuration();
    }

    /**
     * Performs rearrangement of the composition of the disc based on the musicGenre
     *
     * @param genre
     */
    public void sortByStyle(List<Track> tracks, Genre genre) {
        List<Track> withGenre = tracks.stream().filter(t -> t.getGenreId() == genre.getId()).collect(Collectors.toList());
        List<Track> withoutGenre = tracks.stream().filter(t -> t.getGenreId() != genre.getId()).collect(Collectors.toList());

        List<Track> sorted = new ArrayList<>();
        sorted.addAll(withGenre);
        sorted.addAll(withoutGenre);
        diskTrackList = sorted;
    }

    private boolean valueBetween(int value, int from, int to) {
        return value > from && value < to;
    }

    public void selectDisk(String disk) {
        Disk byTitle = Database.disksDao().getByTitle(disk);
        if (byTitle != null) this.disk = byTitle;
        this.diskTrackList = DiskTrackService.getInstance().getTracksForDisk(this.disk);
    }

    public Disk getDisk() {
        return disk;
    }

    public TrackList getTrackList() {
        return trackList;
    }

    public List<Track> getDiskTrackList() {
        return diskTrackList;
    }
}
