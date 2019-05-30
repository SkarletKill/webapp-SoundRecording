package ua.kpi.tef.model.DB.dao;

import ua.kpi.tef.model.DB.DBService;
import ua.kpi.tef.model.DB.entity.Disk;
import ua.kpi.tef.model.DB.entity.DiskTrack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.kpi.tef.model.DB.constants.Fields.*;
import static ua.kpi.tef.model.DB.constants.Fields.CAPACITY;
import static ua.kpi.tef.model.DB.constants.Fields.FREE_SPACE;
import static ua.kpi.tef.model.DB.constants.Query.*;

public final class DiskTrackDao {
    private DiskTrackDao() {
    }

    static DiskTrackDao instance() {
        return new DiskTrackDao();
    }

    public void insert(int diskId, int trackId) {
        DBService.getInstance().execUpdate(INSERT_DISK_TRACK
                + values(String.valueOf(diskId), String.valueOf(trackId)));
    }

    public void delete(int diskId, int trackId) {
        DBService.getInstance().execUpdate(DELETE_DISK_TRACK
                + where(DISK_ID + " = " + diskId, TRACK_ID + " = " + trackId));
    }

    public List<DiskTrack> getAllForDisk(int diskId) {
        List<DiskTrack> diskTracks = new ArrayList<>();
        try {
            ResultSet resultSet = DBService.getInstance().execQuery(SELECT_ALL_DISK_TRACK
                    + where(DISK_ID + " = " + diskId));
            if (resultSet == null) return null;
            while (resultSet.next()) {
                int mDiskId = resultSet.getInt(DISK_ID);
                int mTrackId = resultSet.getInt(TRACK_ID);
                DiskTrack diskTrack = new DiskTrack(mDiskId, mTrackId);
                diskTracks.add(diskTrack);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return diskTracks;
    }
}
