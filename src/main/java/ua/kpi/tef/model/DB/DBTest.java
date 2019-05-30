package ua.kpi.tef.model.DB;

import ua.kpi.tef.model.DB.dao.Database;
import ua.kpi.tef.model.DB.entity.Disk;

import java.util.List;

/**
 * Created by SkarletRED on 10.05.2018.
 */

public class DBTest {

    public static void main(String[] args) {
//        DBWorker worker = new DBWorker();
//        String query = "SELECT * FROM soundrecording.disks";

//        try {
//            if (!worker.getConnection().isClosed()) {
//                System.out.println("Connected to Database");
//            }
//
////            statement.execute("INSERT INTO soundrecording.firsttracklist (Title, Artist, Genre, Duration)\n" +
////                    "VALUES ('War of Change (Acoustic)', 'Thousand Foot Krutch', 'ROCK', 222000)");
////            statement.executeUpdate("UPDATE soundrecording.firsttracklist SET Duration=221000 WHERE id=3");
////            ResultSet res = statement.executeQuery("SELECT * FROM soundrecording.firsttracklist");
//
////            statement.addBatch("INSERT INTO soundrecording.firsttracklist (Title, Artist, Genre, Duration) VALUES ('Batch1', 'Thousand Foot Krutch', 'ROCK', 222000)");
////            statement.addBatch("INSERT INTO soundrecording.firsttracklist (Title, Artist, Genre, Duration) VALUES ('Batch2', 'Thousand Foot Krutch', 'ROCK', 222000)");
////            statement.addBatch("INSERT INTO soundrecording.firsttracklist (Title, Artist, Genre, Duration) VALUES ('Batch3', 'Thousand Foot Krutch', 'ROCK', 222000)");
////            statement.executeBatch();
////            statement.clearBatch();
//
//            Statement statement = worker.getConnection().createStatement();
////            statement.executeUpdate("UPDATE soundrecording.disks SET freeCapacity = fullCapacity");
//            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                String title = resultSet.getString("title");
//                int fullCapacity = resultSet.getInt("fullCapacity");
//                System.out.println(new Disk(title, fullCapacity));
//            }
//
//            worker.getConnection().close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static MusicGenre getGenre(String genreString) {
//        for (MusicGenre genre : MusicGenre.values()) {
//            if (genre.name().equals(genreString)) return genre;
//        }
//        return null;

//        String query = "SELECT * FROM periodicals.editions";
//
//        try {
//            DBService service = DBService.getInstance();
//            service.prepareStatement(query);
//            // execute query
//            service.getAllDisks();
//            service.getConnection().close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

}
