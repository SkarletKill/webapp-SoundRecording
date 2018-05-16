package ua.kpi.tef.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by SkarletRED on 07.05.2018.
 */

public interface StringConstants {
//     Resource Bundle Installation's
    public static String MESSAGES_BUNDLE_NAME = "messages";
    public static ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua"));    // Ukrainian
                    new Locale("en"));    // English

    String DISK_TEXT = "disk.text";
    String DISK_SELECT = "disk.select";
    String DISK_DURATION_TEXT = "disk.duration.text";
    String DISK_DURATION_PLACEHOLDER = "disk.duration.placeholder";
    String DISK_DURATION_BUTTON = "disk.duration.button";
    String DISK_SORT_TEXT = "disk.sort.text";
    String DISK_SORT_SELECT = "disk.sort.select";
    String DISK_SORT_BUTTON = "disk.sort.button";
    String DISK_FIND_TEXT = "disk.find.text";
    String DISK_FIND_BUTTON = "disk.find.button";
    String DISK_FIND_FROM = "disk.find.from";
    String DISK_FIND_TO = "disk.find.to";
    String DISK_TRACKLIST_TEXT= "disk.tracklist.text";

    String PLAYLIST_TEXT= "playlist.text";
    String PLAYLIST_SONG_TITLE= "playlist.song.title";
    String PLAYLIST_SONG_ARTIST= "playlist.song.artist";
    String PLAYLIST_SONG_GENRE= "playlist.song.genre";
    String PLAYLIST_SONG_DURATION= "playlist.song.duration";
    String PLAYLIST_BUTTON_ADD= "playlist.add.button";
    String PLAYLIST_BUTTON_WRITE= "playlist.write.button";
    String PLAYLIST_WRITE_TEXT= "playlist.write.text";
}
