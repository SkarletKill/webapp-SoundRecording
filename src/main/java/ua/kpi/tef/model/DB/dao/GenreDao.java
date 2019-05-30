package ua.kpi.tef.model.DB.dao;

import ua.kpi.tef.model.DB.DBService;
import ua.kpi.tef.model.DB.entity.Disk;
import ua.kpi.tef.model.DB.entity.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ua.kpi.tef.model.DB.constants.Fields.*;
import static ua.kpi.tef.model.DB.constants.Query.SELECT_ALL_DISKS;
import static ua.kpi.tef.model.DB.constants.Query.SELECT_ALL_GENRES;
import static ua.kpi.tef.model.DB.constants.Query.shieldString;

public final class GenreDao {
    private GenreDao() {
    }

    public static GenreDao instance() {
        return new GenreDao();
    }

    public List<Genre> getAll() {
        List<Genre> genres = new ArrayList<>();
        try {
            ResultSet resultSet = DBService.getInstance().execQuery(SELECT_ALL_GENRES);
            if (resultSet == null) return null;
            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String name = resultSet.getString(NAME);
                Genre genre = new Genre(id, name);
                genres.add(genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return genres;
    }

    public Genre getById(int id) {
        Genre genre;
        try {
            ResultSet resultSet = DBService.getInstance().execQuery(SELECT_ALL_GENRES + " WHERE " + ID + " = " + id);
            if (resultSet == null) return null;
            while (resultSet.next()) {
                int mId = resultSet.getInt(ID);
                String mName = resultSet.getString(NAME);
                genre = new Genre(mId, mName);
                return genre;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public Genre getByName(String name) {
        Genre genre;
        try {
            ResultSet resultSet = DBService.getInstance().execQuery(SELECT_ALL_GENRES + " WHERE " + NAME + " = " + shieldString(name));
            if (resultSet == null) return null;
            while (resultSet.next()) {
                int mId = resultSet.getInt(ID);
                String mName = resultSet.getString(NAME);
                genre = new Genre(mId, mName);
                return genre;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
