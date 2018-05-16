package ua.kpi.tef.model.DB;

import com.mysql.jdbc.Driver;
import ua.kpi.tef.model.Disk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by SkarletRED on 14.05.2018.
 */

public class DBDisksService {
    private String URL = "jdbc:mysql://localhost:3306/soundrecording";
    private String USERNAME = "root";
    private String PASSWORD = "H0LL0W";

    private Connection connection;
    private String getAllStatement = "SELECT * FROM soundrecording.disks";
    private PreparedStatement getAll;

    public DBDisksService() throws Exception {
//        Driver driver = new Driver();
//        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        if (!connection.isClosed()) {
            throw new RuntimeException("Connected to the Database");
        }
        getAll = connection.prepareStatement(getAllStatement);
    }

    public void getAllDisks() throws Exception {
        ResultSet resultSet = getAll.executeQuery();
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            int fullCapacity = resultSet.getInt("fullCapacity");
            new Disk(title, fullCapacity);
        }
    }
}
