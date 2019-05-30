package ua.kpi.tef.model.DB;

import java.sql.*;

/**
 * Created by SkarletRED on 14.05.2018.
 */

public final class DBService {
    private DBWorker worker;
    private PreparedStatement statement;

    private static DBService instance;

    public static DBService getInstance() {
        if (instance == null) {
            instance = new DBService();
        }
        return instance;
    }

    private DBService() {
//        Driver driver = new Driver();
//        DriverManager.registerDriver(driver);
        worker = new DBWorker();
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        return statement = worker.getConnection().prepareStatement(query);
    }

    public ResultSet execQuery() {
        try {
            ResultSet resultSet = statement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet execQuery(String query) {
        try {
            PreparedStatement preparedStatement = prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void execUpdate(String query) {
        try {
            PreparedStatement preparedStatement = prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return worker.getConnection();
    }
}
