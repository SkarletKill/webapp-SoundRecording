package ua.kpi.tef.model.DB.entity;

public class Disk {
    private int id;
    private String title;
    private long fullCapacity;       //in kilobytes
    private long freeCapacity;

    public Disk(String title, long fullCapacity) {
        this.title = title;
        this.fullCapacity = fullCapacity;
        this.freeCapacity = fullCapacity;
    }

    public Disk(int id, String title, long fullCapacity, long freeCapacity) {
        this.id = id;
        this.title = title;
        this.fullCapacity = fullCapacity;
        this.freeCapacity = freeCapacity;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getFullCapacity() {
        return fullCapacity;
    }

    public void setFullCapacity(long fullCapacity) {
        this.fullCapacity = fullCapacity;
    }

    public long getFreeCapacity() {
        return freeCapacity;
    }

    public void setFreeCapacity(long freeCapacity) {
        this.freeCapacity = freeCapacity;
    }
}
