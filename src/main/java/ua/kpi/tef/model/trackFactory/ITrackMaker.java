package ua.kpi.tef.model.trackFactory;

import ua.kpi.tef.model.DB.entity.Track;

/**
 * Created by SkarletRED on 07.05.2018.
 */

public interface ITrackMaker {
    Track get();
    void setAttribute(String key, Object value);
}
