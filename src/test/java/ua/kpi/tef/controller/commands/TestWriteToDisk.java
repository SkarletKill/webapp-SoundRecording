package ua.kpi.tef.controller.commands;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.kpi.tef.model.*;
import ua.kpi.tef.model.exeptions.DiskSpaceExeption;
import ua.kpi.tef.view.View;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by SkarletRED on 23.05.2018.
 */

public class TestWriteToDisk {
    Entity model;
    WriteToDisk command;

    @Mock
    HttpServletRequest request;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        model = new Entity();
        command = new WriteToDisk();
    }

    @Test
    public void overflowFromModel(){
        String diskName = "TestDisk";
        int mbCapacity = 10;
        new Disk(diskName, mbCapacity);
        TrackList tracks = model.getTrackList();
        tracks.add(new Track("TrackTitle", 100500, 1024*mbCapacity + 1));

        try {
            model.writeToDisk(diskName, tracks);
            assertFalse(true);
        } catch (DiskSpaceExeption diskSpaceExeption) {
            assertTrue(true);
        }
    }

    @Test
    public void overflowFromCommand(){
        String diskName = "TestDisk";
        int mbCapacity = 10;
        new Disk(diskName, mbCapacity);
        when(request.getParameter(View.disksForPl)).thenReturn(diskName);
        model.getTrackList().add(new Track("TrackTitle", 100500, 1024*mbCapacity + 1));

        String page = command.execute(request, model);
        assertFalse(page.equals(command.index));
    }
}
