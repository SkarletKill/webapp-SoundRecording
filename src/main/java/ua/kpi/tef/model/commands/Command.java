package ua.kpi.tef.model.commands;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SkarletRED on 10.05.2018.
 */

public interface Command {
    String execute(HttpServletRequest request);
}
