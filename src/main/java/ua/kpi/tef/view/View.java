package ua.kpi.tef.view;

/**
 * Created by SkarletRED on 07.05.2018.
 */

public class View implements StringConstants{

    public static String model = "model";

    public static String disksForDisk = "d-disks[]";
    public static String diskDuration = "duration";
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
    public static String songGenres = "p-genres[]";
    public static String plButtonAdd = "add-song";
    public static String plButtonClear = "clear";
    public static String disksForPl = "p-disks[]";
    public static String plWriteButton = "write";
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
}
