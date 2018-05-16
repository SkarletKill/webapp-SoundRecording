package ua.kpi.tef.model.trackFactory;

import ua.kpi.tef.model.MusicGenre;
import ua.kpi.tef.model.Track;

/**
 * Created by SkarletRED on 07.05.2018.
 */

public class TrackMaker implements ITrackMaker {
    Track track;

    public TrackMaker() {
        this.track = new Track();
    }

    @Override
    public void setAttribute(String key, Object value){
        switch (key.toLowerCase()){
            case "title":
                track.setTitle((String) value);
                break;
            case "artist":
                track.setArtist((String) value);
                break;
            case "album":
                track.setAlbum((String) value);
                break;
            case "genre":
                String val = (String) value;
                for (MusicGenre genre: MusicGenre.values()) {
                    if(genre.name().equals(val.toUpperCase())){
                        track.setGenre(genre);
                        break;
                    }
                }
                break;
            case "year":
                track.setYear((Integer) value);
                break;
            case "duration":
                track.setDurationMS((Integer) value);
                break;
            case "size":
                track.setSizeKB((Integer) value);
                break;
        }
    }

    @Override
    public Track get() {
        return track;
    }
}