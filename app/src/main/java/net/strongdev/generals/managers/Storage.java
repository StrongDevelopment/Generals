package net.strongdev.generals.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by oleg on 14.09.16.
 */
public class Storage {

    public static final String storageName = "Generals";

    private static SharedPreferences settings = null;
    private static SharedPreferences.Editor editor = null;
    private static Context context;

    public static void initialize(Context context) {
        context = context;
    }

    public static void initialize() {
        settings = context.getSharedPreferences(storageName, context.MODE_PRIVATE);
        editor = settings.edit();
    }

    public static void add(String key, int value) {
        if (settings == null) {
            initialize();
        }

        editor.putInt(key, value);
        editor.commit();

    }

    public static int get(String key) {
        if (settings == null) {
            initialize();
        }

        return settings.getInt(key, 0);
    }
}
