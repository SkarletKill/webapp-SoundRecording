package ua.kpi.tef.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by SkarletRED on 07.05.2018.
 */

public class View implements BundleConstants, StringKeys{
    public static String en = "en";
    public static String ua = "ua";

    //     Resource Bundle Installation's
    private static String MESSAGES_BUNDLE_NAME = "messages";
    private static ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
//                    new Locale(ua));    // Ukrainian
                    new Locale(en));    // English

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
