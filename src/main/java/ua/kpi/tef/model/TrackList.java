package ua.kpi.tef.model;

import java.util.ArrayList;

/**
 * Created by SkarletRED on 30.04.2018.
 */

public class TrackList extends ArrayList<Track> {
    private long occupiedSpace;         //in kilobytes
    private long songsDuration;          //in milliseconds
    private int index;

    public TrackList() {
        occupiedSpace = 0L;
        songsDuration = 0L;
        resetIndex();
    }

    public TrackList(ArrayList<Track> arrayList){
        this();
        this.addAll(arrayList);
    }

    public long getOccupiedSpace() {
        countCapacity();
        return occupiedSpace;
    }

    public long getSongsDuration() {
        return songsDuration;
    }

    public void countCapacity() {
        this.occupiedSpace = 0L;
        this.forEach(t -> occupiedSpace += t.getSizeKB());
    }

    public void countDuration() {
        this.songsDuration = 0L;
        this.forEach(t -> songsDuration += t.getDuration());
    }

    private void resetIndex() {
        this.index = 0;
    }

    public boolean hasNext() {
        return index < this.size();
    }

    public Track getFirst() {
        return (!this.isEmpty()) ? this.get(0) : null;
    }

    public Track getNext() {
        return (this.hasNext()) ? this.get(index++) : null;
    }
}
