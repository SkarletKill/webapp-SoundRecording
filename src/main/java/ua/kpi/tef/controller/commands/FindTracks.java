package ua.kpi.tef.controller.commands;

import ua.kpi.tef.model.DB.entity.Track;
import ua.kpi.tef.model.DB.service.DiskTrackService;
import ua.kpi.tef.model.Entity;
import ua.kpi.tef.model.exeptions.InvalidTimeFormatExeption;
import ua.kpi.tef.model.TrackList;
import ua.kpi.tef.view.View;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SkarletRED on 17.05.2018.
 */

public class FindTracks implements Command {
    @Override
    public String execute(HttpServletRequest request, Entity model) {
        String fromStr = request.getParameter(View.diskFindFrom);
        String toStr = request.getParameter(View.diskFindTo);

        try {
            if (!fromStr.matches(View.REGEX_DURATION)) throw new InvalidTimeFormatExeption();
            if (!toStr.matches(View.REGEX_DURATION)) throw new InvalidTimeFormatExeption();
            List<Integer> fromArr = Arrays.stream(fromStr.split(View.SING_COLON)).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> toArr = Arrays.stream(toStr.split(View.SING_COLON)).map(Integer::parseInt).collect(Collectors.toList());
            int from = (fromArr.get(0) * 60 + fromArr.get(1)) * 1000;
            int to = (toArr.get(0) * 60 + toArr.get(1)) * 1000;

            List<Track> tracksForDisk = DiskTrackService.getInstance().getTracksForDisk(model.getDisk());
            TrackList found = tracksForDisk.stream()
                    .filter(track -> track.getDurationMS() >= from && track.getDurationMS() <= to)
                    .collect(Collectors.toCollection(TrackList::new));

            request.setAttribute(View.diskFindFilter, found);
        } catch (InvalidTimeFormatExeption ex) {
            ex.printStackTrace();           //need to refactor
        }
        return index;
    }
}
