package ua.kpi.tef.controller.commands;

import ua.kpi.tef.model.Entity;
import ua.kpi.tef.model.trackFactory.ITrackMaker;
import ua.kpi.tef.model.trackFactory.TrackMaker;
import ua.kpi.tef.view.View;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SkarletRED on 17.05.2018.
 */

public class AddSong implements Command {
    @Override
    public String execute(HttpServletRequest request, Entity model) {
        ITrackMaker trackMaker = new TrackMaker();
        setAttributeString(request, View.songTitle, trackMaker);
        setAttributeString(request, View.songArtist, trackMaker);
        if (request.getParameter(View.songGenres) != null) {
            trackMaker.setAttribute(View.songGenre, request.getParameter(View.songGenres));
        }
        model.getTrackList().add(trackMaker.get());
        return index;
    }

    private void setAttributeString(HttpServletRequest request, String attrName, ITrackMaker trackMaker) {
        if (request.getParameter(attrName) != null && !request.getParameter(attrName).isEmpty()) {
            trackMaker.setAttribute(attrName, request.getParameter(attrName));
        }
    }
}
