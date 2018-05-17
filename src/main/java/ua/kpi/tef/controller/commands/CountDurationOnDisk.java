package ua.kpi.tef.controller.commands;

import ua.kpi.tef.model.Entity;
import ua.kpi.tef.model.Track;
import ua.kpi.tef.view.View;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SkarletRED on 17.05.2018.
 */

public class CountDurationOnDisk implements Command {
    @Override
    public String execute(HttpServletRequest request, Entity model) {
        int hh, mm, ss = 0;
        for (Track track :
                model.getDisk().getTrackList()) {
            ss += track.getDuration() / 1000;
        }
        hh = ss / 3600;
        ss %= 3600;
        mm = ss / 60;
        ss %= 60;
        String soundsDuration = new StringBuffer().append(hh).
                append(":").append(mm).
                append(":").append(ss).toString();
        request.setAttribute(View.diskDurationValue, soundsDuration);
        return index;
    }
}
