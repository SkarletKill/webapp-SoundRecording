package ua.kpi.tef.controller.commands;

import ua.kpi.tef.model.Entity;
import ua.kpi.tef.view.View;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SkarletRED on 17.05.2018.
 */

public class SelectDisk implements Command {
    @Override
    public String execute(HttpServletRequest request, Entity model) {
        model.selectDisk(request.getParameter(View.disksForDisk));
        return index;
    }
}
