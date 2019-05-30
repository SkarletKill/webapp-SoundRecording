package ua.kpi.tef.model.DB.dao;

public abstract class Database {
    public static DiskDao disksDao() {
        return DiskDao.instance();
    }

    public static GenreDao genresDao() {
        return GenreDao.instance();
    }

    public static TrackDao tracksDao() {
        return TrackDao.instance();
    }

    public static DiskTrackDao diskTrackDao() {
        return DiskTrackDao.instance();
    }
}