package ua.kpi.tef;

import ua.kpi.tef.model.Track;
import ua.kpi.tef.model.TrackList;
import ua.kpi.tef.view.View;

import java.util.List;

/**
 * Created by SkarletRED on 30.04.2018.
 */

public class App {
    public static void main(String[] args) {
//        TrackList list = new TrackList();
//        Track firstTrack = new Track("This is war", 180000, 8000);
//        list.add(firstTrack);
//        System.out.println(list.getFirst());
        View view = new View();
        System.out.println(view.getLocaleMassage("disk.text"));
    }
}