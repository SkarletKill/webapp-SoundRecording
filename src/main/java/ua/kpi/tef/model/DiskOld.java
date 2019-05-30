//package ua.kpi.tef.model;
//
//import ua.kpi.tef.model.exeptions.DiskSpaceExeption;
//
//import java.util.ArrayList;
//
///**
// * Created by SkarletRED on 17.04.2018.
// */
//
//public class Disk {
//    private static ArrayList<Disk> disks = new ArrayList<>();
//
//    private String title;
//    private long fullCapacity;       //in kilobytes
//    private long freeCapacity;
//    private TrackList trackList;
//
//    public Disk(int mbCapacity) {
//        String name = "Local disk " + (char) ('A' + disks.size());
//        this.title = name;
//        this.fullCapacity = 1024L * mbCapacity;
//        this.freeCapacity = this.fullCapacity;
//        this.trackList = new TrackList();
//        addDiskToList(this);
//    }
//
//    public Disk(String name, int mbCapacity) {
//        this.title = name;
//        this.fullCapacity = 1024L * mbCapacity;
//        this.freeCapacity = this.fullCapacity;
//        this.trackList = new TrackList();
//        addDiskToList(this);
//    }
//
//    private void addDiskToList(Disk disk) {
//        for(Disk d: disks){
//            if(d.getTitle().equals(disk.getTitle())) {
//                return;
//            }
//        }
//        disks.add(disk);
//    }
//
//    public static ArrayList<Disk> getDisks() {
//        return disks;
//    }
//
//    public static int getIndexByTitle(String title) {
//        for (int i = 0; i < disks.size(); i++) {
//            if (disks.get(i).title.equals(title))
//                return i;
//        }
//        return -1;
//    }
//
//    public void recordTrack(Track track) throws DiskSpaceExeption {
//        if (freeCapacity < track.getSizeKB()) throw new DiskSpaceExeption();
//        trackList.add(track);
//        recountCapacity();
//        trackList.countDuration();
//    }
//
//    public void recordTrackAll(TrackList trackList) throws DiskSpaceExeption {
//        if (freeCapacity < trackList.getOccupiedSpace()) throw new DiskSpaceExeption();
//        this.trackList.addAll(trackList);
//        recountCapacity();
//        this.trackList.countDuration();
//    }
//
//    private void recountCapacity() {
//        trackList.countCapacity();
//        freeCapacity = fullCapacity - trackList.getOccupiedSpace();
//    }
//
//    public TrackList getTrackList() {
//        return trackList;
//    }
//
//    public long getFreeCapacity() {
//        return freeCapacity;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//}
