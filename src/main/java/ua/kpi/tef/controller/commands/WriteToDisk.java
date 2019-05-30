package ua.kpi.tef.controller.commands;

import ua.kpi.tef.model.DB.service.DiskTrackService;
import ua.kpi.tef.model.exeptions.DiskSpaceExeption;
import ua.kpi.tef.model.Entity;
import ua.kpi.tef.view.View;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SkarletRED on 17.05.2018.
 */

public class WriteToDisk implements Command {
    private String diskOutOfMemory = "diskSpaceException.jsp";

    @Override
    public String execute(HttpServletRequest request, Entity model) {
        if (request.getParameter(View.disksForPl) != null) {
            try {
                DiskTrackService.getInstance().recordTracks(request.getParameter(View.disksForPl), model.getTrackList());
                return index;
            } catch (DiskSpaceExeption diskSpaceExeption) {
                return diskOutOfMemory;
            }
        }
        return null;
    }
}
