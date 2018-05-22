package ua.kpi.tef.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by SkarletRED on 07.05.2018.
 */

public class View implements StringConstants{
    public static String en = "en";
    public static String ua = "ua";

    //     Resource Bundle Installation's
    private static String MESSAGES_BUNDLE_NAME = "messages";
    private static ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
//                    new Locale(ua));    // Ukrainian
                    new Locale(en));    // English

    public static String model = "model";

    public static String language = "language";
    public static String languageButton = "language";
    public static String disksForDisk = "d-disks[]";
    public static String diskDuration = "d-duration";
    public static String diskDurationValue = "durationValue";
    public static String diskCountButton = "count";
    public static String diskGenres = "d-genres[]";
    public static String diskSortButton = "sort";
    public static String diskFindFrom = "find-from";
    public static String diskFindTo = "find-to";
    public static String diskFindButton = "find";
    public static String diskFindFilter = "found";

    public static String songTitle = "title";
    public static String songArtist = "artist";
    public static String songGenre = "genre";
    public static String songDuration = "duration";
    public static String songGenres = "p-genres[]";
    public static String plButtonAdd = "add-song";
    public static String plButtonClear = "clear";
    public static String disksForPl = "p-disks[]";
    public static String plWriteButton = "write";

    public static String REGEX_DURATION = "\\d{1,2}:\\d{1,2}";
    public static String SING_DOUBLEPOINT = ":";
    /**
     * This method is used to get message which it
     * accept as a parameter, but translated with
     * resource bundle
     * @param bundleMsg
     * @return
     */
    public static String getLocaleMassage(String bundleMsg){
        return bundle.getString(bundleMsg);
    }

    public static void changeLanguage(boolean english){
        bundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME,
                new Locale((english)? en: ua));
    }
}
