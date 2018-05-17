package ua.kpi.tef.controller.commands;

import ua.kpi.tef.model.Entity;
import ua.kpi.tef.view.View;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SkarletRED on 17.05.2018.
 */

public class ChangeLanguage implements Command {
    @Override
    public String execute(HttpServletRequest request, Entity model) {
        String lang = request.getParameter(View.language);
        if(lang.equals(View.en)) View.changeLanguage(true);
        if(lang.equals(View.ua)) View.changeLanguage(false);
        return index;
    }
}
