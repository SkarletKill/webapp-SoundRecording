package ua.kpi.tef.model.DB;


import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by SkarletRED on 10.05.2018.
 */

public class DBWorker {
    private final String URL = "jdbc:mysql://localhost:3306/soundrecording";
    private final String USERNAME = "root";
    private final String PASSWORD = "H0LL0W";

    private Connection connection;

    public DBWorker(){
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
