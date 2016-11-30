package org.liushui.textstyleplus;

import android.util.Log;

/**
 * Logs <br/>
 * Created by xiaqiulei on 2015-07-27.
 */
public class Logs {

    private static final String TAG = "TextStylePlus";

    private static boolean debug = BuildConfig.DEBUG;

    public static void debug(boolean debug) {
        Logs.debug = debug;
    }

    public static void i(String msg, Object... args) {
        if (debug) {
            if (args != null && args.length > 0) {
                msg = String.format(msg, args);
            }
            Log.i(TAG, msg);
        }
    }
}