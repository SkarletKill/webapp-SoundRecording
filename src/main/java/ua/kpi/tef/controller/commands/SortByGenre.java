package ua.kpi.tef.controller.commands;

import ua.kpi.tef.model.DB.dao.Database;
import ua.kpi.tef.model.DB.entity.Genre;
import ua.kpi.tef.model.Entity;
import ua.kpi.tef.model.MusicGenre;
import ua.kpi.tef.view.View;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SkarletRED on 17.05.2018.
 */

public class SortByGenre implements Command {
    @Override
    public String execute(HttpServletRequest request, Entity model) {
        String genre = request.getParameter(View.diskGenres);
        Genre byName = Database.genresDao().getByName(genre);
        model.sortByStyle(model.getDiskTrackList(), byName);
        return index;
    }
}
