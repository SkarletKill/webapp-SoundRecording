package ua.kpi.tef.controller.commands;

import ua.kpi.tef.model.Entity;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SkarletRED on 17.05.2018.
 */

public class ClearPlaylist implements Command {
    @Override
    public String execute(HttpServletRequest request, Entity model) {
        model.getTrackList().clear();
        return index;
    }
}
