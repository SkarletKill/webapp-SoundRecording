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
//        for (Track track :
//                model.getDisk().getTrackList()) {
//            ss += track.getDuration() / 1000;
//        }
        ss += model.countDuration(model.getDisk()) / 1000;
        hh = ss / 3600;
        ss %= 3600;
        mm = ss / 60;
        ss %= 60;
        String soundsDuration = new StringBuffer().append(addZero(hh)).
                append(View.SING_DOUBLEPOINT).append(addZero(mm)).
                append(View.SING_DOUBLEPOINT).append(addZero(ss)).toString();
        request.setAttribute(View.diskDurationValue, soundsDuration);
        return index;
    }

    private String addZero(int number) {
        return (Math.abs(number) < 10) ? "0" + number : "" + number;
    }
}
