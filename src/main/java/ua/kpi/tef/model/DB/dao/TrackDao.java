package ua.kpi.tef.model.DB.dao;

import ua.kpi.tef.model.DB.DBService;
import ua.kpi.tef.model.DB.entity.Disk;
import ua.kpi.tef.model.DB.entity.Track;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.kpi.tef.model.DB.constants.Fields.*;
import static ua.kpi.tef.model.DB.constants.Fields.FREE_SPACE;
import static ua.kpi.tef.model.DB.constants.Fields.ID;
import static ua.kpi.tef.model.DB.constants.Query.*;
import static ua.kpi.tef.model.DB.constants.Query.where;

public final class TrackDao {
    private TrackDao() {
    }

    public static TrackDao instance() {
        return new TrackDao();
    }

    public List<Track> getAll() {
        List<Track> tracks = new ArrayList<>();
        try {
            ResultSet resultSet = DBService.getInstance().execQuery(SELECT_ALL_TRACKS);
            if (resultSet == null) return null;
            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String title = resultSet.getString(TITLE);
                String artist = resultSet.getString(ARTIST);
                String album = resultSet.getString(ALBUM);
                int genreId = resultSet.getInt(GENRE_ID);
                int year = resultSet.getInt(YEAR);
                int durationMS = resultSet.getInt(DURATION);         //in seconds
                int sizeKB = resultSet.getInt(SIZE);
                Track track = new Track(id, title, artist, album, genreId, year, durationMS, sizeKB);
                tracks.add(track);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return tracks;
    }

    public Track getById(int id) {
        Track track;
        try {
            ResultSet resultSet = DBService.getInstance().execQuery(SELECT_ALL_TRACKS + where(ID + " = " + id));
            if (resultSet == null) return null;
            while (resultSet.next()) {
                track = createTrack(resultSet);
                return track;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public Track getByTitle(String title) {
        // return last
        Track track = null;
        try {
            ResultSet resultSet = DBService.getInstance().execQuery(SELECT_ALL_TRACKS +
                    where(TITLE + " = " + shieldString(title)));
            if (resultSet == null) return null;
            while (resultSet.next()) {
                track = createTrack(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return track;
    }

    public void insert(Track track) {
        DBService.getInstance().execUpdate(INSERT_TRACK
                + values(shieldString(track.getTitle()), shieldString(track.getArtist()), shieldString(track.getAlbum()), String.valueOf(track.getGenreId()),
                String.valueOf(track.getYear()), String.valueOf(track.getDurationMS()), String.valueOf(track.getSizeKB())));
    }

    public void insertSafe(Track track) {
        // Track already exists
        if (getById(track.getId()) != null) return;

        insert(track);
    }

    public void update(Track track) {
        DBService.getInstance().execUpdate(UPDATE_TRACK + set(
                new String[]{TITLE, shieldString(track.getTitle())},
                new String[]{ARTIST, shieldString(track.getArtist())},
                new String[]{ALBUM, shieldString(track.getAlbum())},
                new String[]{GENRE_ID, String.valueOf(track.getGenreId())},
                new String[]{YEAR, String.valueOf(track.getYear())},
                new String[]{DURATION, String.valueOf(track.getDurationMS())},
                new String[]{SIZE, String.valueOf(track.getSizeKB())}
        ) + where(ID + " = " + track.getId()));
    }

    public void delete(Track track) {
        DBService.getInstance().execUpdate(DELETE_TRACK + where(ID + " = " + track.getId()));
    }

    private Track createTrack(ResultSet resultSet) throws SQLException {
        Track track;
        int mId = resultSet.getInt(ID);
        String title = resultSet.getString(TITLE);
        String artist = resultSet.getString(ARTIST);
        String album = resultSet.getString(ALBUM);
        int genreId = resultSet.getInt(GENRE_ID);
        int year = resultSet.getInt(YEAR);
        int durationMS = resultSet.getInt(DURATION);         //in seconds
        int sizeKB = resultSet.getInt(SIZE);
        track = new Track(mId, title, artist, album, genreId, year, durationMS, sizeKB);
        return track;
    }
}