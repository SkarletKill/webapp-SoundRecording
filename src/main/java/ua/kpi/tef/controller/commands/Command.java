package ua.kpi.tef.controller.commands;

import ua.kpi.tef.model.Entity;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SkarletRED on 10.05.2018.
 */

public interface Command {
    String index = "mainPage.jsp";

    String execute(HttpServletRequest request, Entity model);
}
