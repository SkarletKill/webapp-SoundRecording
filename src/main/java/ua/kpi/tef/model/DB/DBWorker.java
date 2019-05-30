package ua.kpi.tef.model.DB;


import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by SkarletRED on 10.05.2018.
 */

public class DBWorker {
    private final String URL = "jdbc:mysql://localhost:3306/soundrecording_studio";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private Connection connection;

    public DBWorker() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = createConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL + "?user=" + USERNAME + "&password=" + PASSWORD
                + "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
    }
}
