package ua.kpi.tef.model.DB.entity;

public class DiskTrack {
    private int diskId;
    private int trackId;

    public DiskTrack(int diskId, int trackId) {
        this.diskId = diskId;
        this.trackId = trackId;
    }

    public int getDiskId() {
        return diskId;
    }

    public void setDiskId(int diskId) {
        this.diskId = diskId;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }
}