package ua.kpi.tef.model.trackFactory;

import ua.kpi.tef.model.DB.dao.Database;
import ua.kpi.tef.model.DB.entity.Genre;
import ua.kpi.tef.model.DB.entity.Track;

import java.util.Objects;

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
                Genre genre = Database.genresDao().getById(Integer.parseInt(val));
//                Genre genre = Database.genresDao().getByName(val);
                track.setGenreId(Objects.requireNonNull(genre).getId());
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