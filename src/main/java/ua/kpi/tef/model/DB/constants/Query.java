package ua.kpi.tef.model.DB.constants;

import java.util.Arrays;
import java.util.stream.Collectors;

import static ua.kpi.tef.model.DB.constants.Tables.DATABASE;

public interface Query {
    String SELECT_ALL_ = "SELECT * FROM ";
    String DB_SELECT_ALL = SELECT_ALL_ + DATABASE + ".";

    String SELECT_ALL_DISKS = DB_SELECT_ALL + Tables.DISKS;
    String SELECT_ALL_GENRES = DB_SELECT_ALL + Tables.GENRES;
    String SELECT_ALL_TRACKS = DB_SELECT_ALL + Tables.TRACKS;
    String SELECT_ALL_DISK_TRACK = DB_SELECT_ALL + Tables.DISK_TRACK;

    String INSERT = "INSERT INTO " + DATABASE + ".";
    String INSERT_DISK = INSERT + Tables.DISKS + params(Fields.TITLE, Fields.CAPACITY, Fields.FREE_SPACE);
    String INSERT_GENRE = INSERT + Tables.GENRES + params(Fields.NAME);
    String INSERT_TRACK = INSERT + Tables.TRACKS
            + params(Fields.TITLE, Fields.ARTIST, Fields.ALBUM, Fields.GENRE_ID, Fields.YEAR, Fields.DURATION, Fields.SIZE);
    String INSERT_DISK_TRACK = INSERT + Tables.DISK_TRACK + params(Fields.DISK_ID, Fields.TRACK_ID);

    String UPDATE = "UPDATE " + DATABASE + ".";
    String UPDATE_DISK = UPDATE + Tables.DISKS;
    String UPDATE_GENRE = UPDATE + Tables.GENRES;
    String UPDATE_TRACK = UPDATE + Tables.TRACKS;
    String UPDATE_DISK_TRACK = UPDATE + Tables.DISK_TRACK + params(Fields.DISK_ID, Fields.TRACK_ID);

    String DELETE = "DELETE FROM " + DATABASE + ".";
    String DELETE_DISK = DELETE + Tables.DISKS;
    String DELETE_GENRE = DELETE + Tables.GENRES;
    String DELETE_TRACK = DELETE + Tables.TRACKS;
    String DELETE_DISK_TRACK = DELETE + Tables.DISK_TRACK + params(Fields.DISK_ID, Fields.TRACK_ID);

    static String params(String... p) {
        StringBuilder builder = new StringBuilder();
        builder.append("(")
                .append(String.join(", ", p))
                .append(")");
        return builder.toString();
    }

    static String values(String... v) {
        StringBuilder builder = new StringBuilder();
        builder.append(" VALUES(")
                .append(String.join(", ", v))
                .append(")");
        return builder.toString();
    }

    static String where(String... conds) {
        StringBuilder builder = new StringBuilder();
        builder.append(" WHERE ")
                .append(String.join(" AND ", conds));
        return builder.toString();
    }

    static String set(String[]... v) {
        String[] pairs = Arrays.stream(v).map(k_v -> k_v[0] + " = " + k_v[1]).toArray(String[]::new);
        StringBuilder builder = new StringBuilder();
        builder.append(" SET ")
                .append(String.join(", ", pairs));
        return builder.toString();
    }

    static String shieldString(String str) {
        return "\"" + str + "\"";
    }
}