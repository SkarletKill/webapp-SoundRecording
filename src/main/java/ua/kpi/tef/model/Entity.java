package ua.kpi.tef.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SkarletRED on 17.04.2018.
 */

public class Entity {
    private Disk disk;
    private TrackList trackList;

    static{
        new Disk("Local disk A:", 4000);
//        new Disk("Local disk B:", 4000);
//        new Disk("Local disk C:", 4000);
    }

    public Entity() {
        this.disk = new Disk("My songs", 4000);
        this.trackList = new TrackList();
    }

    /**
     * Write an assembly to disk
     *
     * @param assembly
     */
    public void writeToDisk(String diskName, TrackList assembly) throws DiskSpaceExeption {
        for (Disk disk : Disk.getDisks()) {
            if (disk.getTitle().equals(diskName))
                disk.recordTrackAll(trackList);
        }
    }

    /**
     * @param disk
     * @return the duration of songs on the disk
     */
    public long countDuration(Disk disk) {
        return disk.getTrackList().getSongsDuration();
    }

    /**
     * Performs rearrangement of the composition of the disc based on the musicGenre
     *
     * @param genre
     */
    public void sortByStyle(Disk disk, MusicGenre genre) {
        List<Track> withGenre = disk.getTrackList().stream().filter(t -> t.getGenre().equals(genre)).collect(Collectors.toList());
        List<Track> withoutGenre = disk.getTrackList().stream().filter(t -> !t.getGenre().equals(genre)).collect(Collectors.toList());
        disk.getTrackList().clear();
        disk.getTrackList().addAll(withGenre);
        disk.getTrackList().addAll(withoutGenre);
    }

    /**
     * Find a song that matches the specified range of trackFactory lengths on the disk.
     *
     * @param from
     * @param to
     * @return found
     */
    public Track findTrack(Disk disk, int from, int to) {
        Track found = null;
        for (Track track : disk.getTrackList()) {
            if (valueBetween(track.getDuration(), from, to)) {
                found = track;
                break;
            }
        }
        return found;
    }

    private boolean valueBetween(int value, int from, int to) {
        return value > from && value < to;
    }

    public void selectDisk(String disk) {
        int index = Disk.getIndexByTitle(disk);
        if (index >= 0) this.disk = Disk.getDisks().get(index);
    }

    public Disk getDisk() {
        return disk;
    }

    public TrackList getTrackList() {
        return trackList;
    }
}
