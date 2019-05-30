package ua.kpi.tef.model.DB.dao;

import ua.kpi.tef.model.DB.DBService;
import ua.kpi.tef.model.DB.entity.Disk;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.kpi.tef.model.DB.constants.Fields.*;
import static ua.kpi.tef.model.DB.constants.Query.*;

public final class DiskDao {
    private DiskDao() {
    }

    public static DiskDao instance() {
        return new DiskDao();
    }

    public List<Disk> getAll() {
        List<Disk> disks = new ArrayList<>();
        try {
            ResultSet resultSet = DBService.getInstance().execQuery(SELECT_ALL_DISKS);
            if (resultSet == null) return null;
            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String title = resultSet.getString(TITLE);
                int capacity = resultSet.getInt(CAPACITY);
                int freeSpace = resultSet.getInt(FREE_SPACE);
                Disk disk = new Disk(id, title, capacity, freeSpace);
                disks.add(disk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return disks;
    }

    public Disk getById(int id) {
        Disk disk;
        try {
            ResultSet resultSet = DBService.getInstance().execQuery(SELECT_ALL_DISKS + where(ID + " = " + id));
            if (resultSet == null) return null;
            while (resultSet.next()) {
                disk = createDisk(resultSet);
                return disk;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public Disk getByTitle(String title) {
        // return last
        Disk disk = null;
        try {
            ResultSet resultSet = DBService.getInstance().execQuery(SELECT_ALL_DISKS + where(TITLE + " = " + shieldString(title)));
            if (resultSet == null) return null;
            while (resultSet.next()) {
                disk = createDisk(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return disk;
    }

    public void insert(Disk disk) {
        DBService.getInstance().execUpdate(INSERT_DISK
                + values(shieldString(disk.getTitle()), String.valueOf(disk.getFullCapacity()), String.valueOf(disk.getFreeCapacity())));
    }

    public void update(Disk disk) {
        DBService.getInstance().execUpdate(UPDATE_DISK + set(
                new String[]{TITLE, shieldString(disk.getTitle())},
                new String[]{CAPACITY, String.valueOf(disk.getFullCapacity())},
                new String[]{FREE_SPACE, String.valueOf(disk.getFreeCapacity())}
        ) + where(ID + " = " + disk.getId()));
    }

    public void delete(Disk disk) {
        DBService.getInstance().execUpdate(DELETE_DISK + where(ID + " = " + disk.getId()));
    }

    private Disk createDisk(ResultSet resultSet) throws SQLException {
        Disk disk;
        int mId = resultSet.getInt(ID);
        String title = resultSet.getString(TITLE);
        int capacity = resultSet.getInt(CAPACITY);
        int free_space = resultSet.getInt(FREE_SPACE);
        disk = new Disk(mId, title, capacity, free_space);
        return disk;
    }
}