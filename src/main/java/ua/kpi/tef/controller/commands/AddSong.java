package ua.kpi.tef.controller.commands;

import ua.kpi.tef.model.Entity;
import ua.kpi.tef.model.trackFactory.ITrackMaker;
import ua.kpi.tef.model.trackFactory.TrackMaker;
import ua.kpi.tef.view.View;

import javax.servlet.http.HttpServletRequest;
import java.util.function.Function;

/**
 * Created by SkarletRED on 17.05.2018.
 */

public class AddSong implements Command {
    private String page;
    private String illegalDurationFormat = "illegalDurationFormat.jsp";

    @Override
    public String execute(HttpServletRequest request, Entity model) {
        page = index;
        ITrackMaker trackMaker = new TrackMaker();
        setAttributeString(request, View.songTitle, trackMaker);
        setAttributeString(request, View.songArtist, trackMaker);
        setAttributeString(request, View.songGenre, trackMaker);
        setAttributeInteger(request, View.songDuration, trackMaker, this::getParsedDuration);
        model.getTrackList().add(trackMaker.get());
        return page;
    }

    private void setAttributeString(HttpServletRequest request, String attrName, ITrackMaker trackMaker) {
        if (request.getParameter(attrName) != null && !request.getParameter(attrName).isEmpty()) {
            trackMaker.setAttribute(attrName, request.getParameter(attrName));
        }
    }

    private void setAttributeInteger(HttpServletRequest request, String attrName, ITrackMaker trackMaker, Function<String, Integer> parser) {
        if (request.getParameter(attrName) != null && !request.getParameter(attrName).isEmpty()) {
            Integer parsed = parser.apply(request.getParameter(attrName));
            if (parsed != null) trackMaker.setAttribute(attrName, parser.apply(request.getParameter(attrName)));
            else page = illegalDurationFormat;
        }
    }

    private Integer getParsedDuration(String durStr) {
        if (!durStr.matches(View.REGEX_DURATION)) return null;
        String[] arr = durStr.split(View.SING_DOUBLEPOINT);
        if(Integer.parseInt(arr[1]) > 59) return null;
        return (Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1])) * 1000;
    }
}
