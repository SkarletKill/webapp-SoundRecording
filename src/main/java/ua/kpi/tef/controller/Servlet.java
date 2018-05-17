package ua.kpi.tef.controller;

import ua.kpi.tef.model.*;
import ua.kpi.tef.controller.commands.*;
import ua.kpi.tef.view.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class Servlet extends HttpServlet {
    private String page = "mainPage.jsp";
    private String diskOutOfMemory = "diskSpaceException.jsp";
    private Entity model = new Entity();
    private Map<String, Command> commands;
    Command command = null;

    @Override
    public void init() throws ServletException {
        super.init();
        commands = new HashMap<>();
        commands.put(View.plButtonAdd, new AddSong());
        commands.put(View.plButtonClear, new ClearPlaylist());
        commands.put(View.plWriteButton, new WriteToDisk());
        commands.put(View.diskCountButton, new CountDurationOnDisk());
        commands.put(View.diskSortButton, new SortByGenre());
        commands.put(View.diskFindButton, new FindTracks());
        commands.put(View.disksForDisk, new SelectDisk());
        commands.put(View.language, new ChangeLanguage());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            command = commands.get(getCommandName(request));
        } catch (NullPointerException ex){
            System.out.println(ex.getMessage());
        }

        if (command != null) page = command.execute(request, model);
        request.getRequestDispatcher(page).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute(View.model) == null)
            request.getSession().setAttribute(View.model, this.model);
        request.getRequestDispatcher(page).forward(request, response);
    }

    public Entity getModel() {
        return model;
    }

    public String getCommandName(HttpServletRequest request) {
        for (String commandName :
                commands.keySet()) {
            if (request.getParameter(commandName) != null) return commandName;
        }
        return null;
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
