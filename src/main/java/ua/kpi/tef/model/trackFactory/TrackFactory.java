package ua.kpi.tef.model.trackFactory;

import ua.kpi.tef.model.DB.entity.Track;

/**
 * Created by SkarletRED on 07.05.2018.
 */

public class TrackFactory {
    public static void main(String[] args) {
        //test
        ITrackMaker trackMaker = TrackFactory.maker();
        trackMaker.setAttribute("title", "This is War");
        Track track = trackMaker.get();
        System.out.println(track);
    }

    public static TrackMaker maker(){
        return new TrackMaker();
    }
}