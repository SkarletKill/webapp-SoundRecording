package ua.kpi.tef.controller.commands;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.kpi.tef.model.Entity;
import ua.kpi.tef.view.View;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by SkarletRED on 23.05.2018.
 */

public class TestChangeLanguage {
    Entity model;
    ChangeLanguage command;

    @Mock
    HttpServletRequest request;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        model = new Entity();
        command = new ChangeLanguage();
    }

    @Test
    public void testEnLocale(){
        when(request.getParameter(View.language)).thenReturn(View.en);
        command.execute(request, model);
        assertEquals(View.getLocaleMassage(View.DISK_SELECT), "Select disk");
        assertEquals(View.getLocaleMassage(View.DISK_TEXT), "Disk");
    }

    @Test
    public void testUaLocale(){
        when(request.getParameter(View.language)).thenReturn(View.ua);
        command.execute(request, model);
        assertEquals(View.getLocaleMassage(View.DISK_SELECT), "Виберіть диск");
        assertEquals(View.getLocaleMassage(View.DISK_TEXT), "Диск");
    }
}
