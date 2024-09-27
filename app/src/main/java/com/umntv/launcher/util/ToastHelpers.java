package com.umntv.launcher.util;

import android.content.Context;
import android.widget.Toast;

public class ToastHelpers {

    public static Toast makeText(Context c, Object msg, int duration) {
        return Toast.makeText(c, String.valueOf(msg), duration);
    }

    public static void showSort(Context c, Object msg) {
        makeText(c, String.valueOf(msg), Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context c, Object msg) {
        makeText(c, String.valueOf(msg), Toast.LENGTH_LONG).show();
    }
}
