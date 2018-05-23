package ua.kpi.tef.controller;

import org.apache.struts.mock.MockHttpServletRequest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.kpi.tef.controller.commands.AddSong;
import ua.kpi.tef.model.Entity;
import ua.kpi.tef.model.Track;
import ua.kpi.tef.model.trackFactory.ITrackMaker;
import ua.kpi.tef.model.trackFactory.TrackMaker;
import ua.kpi.tef.view.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

/**
 * Created by SkarletRED on 23.05.2018.
 */

public class TestServlet {
//    Entity model;
//
//    @Mock
//    HttpServletRequest request;
//
//    @Mock
//    HttpServletResponse response;
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        model = new Entity();
//    }
//
//    @Test
//    public void testAddSong(){
//        AddSong command = new AddSong();
//        ITrackMaker trackMaker = new TrackMaker();
//
//        String title = "TITLE", atrits = "ARTIST", genre = "ROCK", duration = "12:48";
//        when(request.getParameter(View.songTitle)).thenReturn(title);
//        when(request.getParameter(View.songArtist)).thenReturn(atrits);
//        when(request.getParameter(View.songGenre)).thenReturn(genre);
//        when(request.getParameter(View.songDuration)).thenReturn(duration);
//
//        command.execute(request, model);
//        Track song = model.getTrackList().getFirst();
//        assertEquals(song.getTitle(), title);
//        assertEquals(song.getArtist(), atrits);
//        assertEquals(song.getGenre().name(), genre);
//        assertEquals(song.getDuration(), getParsedDuration(duration));
//    }
//
//    private int getParsedDuration(String durStr) {
//        if (!durStr.matches(View.REGEX_DURATION)) return Integer.MAX_VALUE;
//        String[] arr = durStr.split(View.SING_DOUBLEPOINT);
//        if(Integer.parseInt(arr[1]) > 59) return Integer.MAX_VALUE;
//        return (Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1])) * 1000;
//    }

//    @Test
//    public void testFullName() throws IOException, ServletException {
//
//        when(request.getParameter("fn")).thenReturn("Vinod");
//        when(request.getParameter("ln")).thenReturn("Kashyap");
//
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//
//        when(response.getWriter()).thenReturn(pw);
//
//        TestServlet testServlet = new TestServlet();
//        testServlet.doGet(request, response);
//        String result = sw.getBuffer().toString().trim();
//        assertEquals(result, new String("Full Name: Vinod Kashyap"));
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String firstName = request.getParameter("fn");
//        String lastName = request.getParameter("ln");
//
//        response.getWriter().append("Full Name: " + firstName + " " + lastName);
//    }
}
