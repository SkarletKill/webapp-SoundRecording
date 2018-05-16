package ua.kpi.tef.controller;

import ua.kpi.tef.model.*;
import ua.kpi.tef.model.commands.Command;
import ua.kpi.tef.model.trackFactory.ITrackMaker;
import ua.kpi.tef.model.trackFactory.TrackMaker;
import ua.kpi.tef.view.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Servlet extends HttpServlet {
    private String index = "mainPage.jsp";
    private String diskOutOfMemory = "diskSpaceException.jsp";
    private Entity model = new Entity();
    private Map<String, Command> commands = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Playlist
        if (request.getParameter(View.plButtonAdd) != null) {
            ITrackMaker trackMaker = new TrackMaker();
            setAttributeString(request, View.songTitle, trackMaker);
            setAttributeString(request, View.songArtist, trackMaker);
            if (request.getParameter(View.songGenres) != null) {
                trackMaker.setAttribute(View.songGenre, request.getParameter(View.songGenres));
            }
            model.getTrackList().add(trackMaker.get());
        } else if (request.getParameter(View.plWriteButton) != null) {
            if (request.getParameter(View.disksForPl) != null) {
                try {
                    model.writeToDisk(request.getParameter(View.disksForPl), model.getTrackList());
                } catch (DiskSpaceExeption diskSpaceExeption) {
                    request.getRequestDispatcher(diskOutOfMemory).forward(request, response);
                }
            }
        } else if (request.getParameter(View.diskCountButton) != null) {
            int hh, mm, ss = 0;
            for (Track track :
                    model.getDisk().getTrackList()) {
                ss += track.getDuration() / 1000;
            }
            hh = ss / 3600;
            ss %= 3600;
            mm = ss / 60;
            ss %= 60;
            String soundsDuration = new StringBuffer().append(hh).
                    append(":").append(mm).
                    append(":").append(ss).toString();
            request.setAttribute(View.diskDurationValue, soundsDuration);
        } else if (request.getParameter(View.diskSortButton) != null) {
            model.sortByStyle(model.getDisk(), MusicGenre.getGenreByString(request.getParameter(View.diskGenres)));
        } else if (request.getParameter(View.diskFindButton) != null) {
            String fromStr = request.getParameter(View.diskFindFrom);
            String toStr = request.getParameter(View.diskFindTo);
            try {
                if (!fromStr.matches("\\d{1,2}:\\d{1,2}")) throw new InvalidTimeFormatExeption();
                if (!toStr.matches("\\d{1,2}:\\d{1,2}")) throw new InvalidTimeFormatExeption();
                List<Integer> fromArr = Arrays.stream(fromStr.split(":")).map((String e) -> Integer.parseInt(e)).collect(Collectors.toList());
                List<Integer> toArr = Arrays.stream(toStr.split(":")).map((String e) -> Integer.parseInt(e)).collect(Collectors.toList());
                int from = (fromArr.get(0) * 60 + fromArr.get(1)) * 1000;
                int to = (toArr.get(0) * 60 + toArr.get(1)) * 1000;

                TrackList found = model.getDisk().getTrackList().stream()
                        .filter(track -> track.getDuration() >= from && track.getDuration() <= to)
                        .collect(Collectors.toCollection(TrackList::new));

                request.setAttribute(View.diskFindFilter, found);
            } catch (InvalidTimeFormatExeption ex) {
                ex.printStackTrace();
            }
        }

        request.getRequestDispatcher(index).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter(View.disksForDisk) != null) {
            model.selectDisk(request.getParameter(View.disksForDisk));
        }
        request.getSession().setAttribute(View.model, this.model);
        request.getRequestDispatcher(index).forward(request, response);
    }

    public Entity getModel() {
        return model;
    }

    public void setAttributeString(HttpServletRequest request, String attrName, ITrackMaker trackMaker) {
        if (request.getParameter(attrName) != null && !request.getParameter(attrName).isEmpty()) {
            trackMaker.setAttribute(attrName, request.getParameter(attrName));
        }
    }

//    private void readDisksFromDatabase() {
//        DBWorker worker = new DBWorker();
//        String query = "SELECT * FROM soundrecording.disks";
//
//        try {
//            if (!worker.getConnection().isClosed()) {
//                System.out.println("Connected to Database");
//            }
//
//            Statement statement = worker.getConnection().createStatement();
////            statement.executeUpdate("UPDATE soundrecording.disks SET freeCapacity = fullCapacity");
//            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                String title = resultSet.getString("title");
//                int fullCapacity = resultSet.getInt("fullCapacity");
//                new Disk(title, fullCapacity);
//            }
//
//            worker.getConnection().close();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
}
