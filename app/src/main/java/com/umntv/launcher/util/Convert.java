package com.umntv.launcher.util;

import android.content.Context;

import java.util.Locale;

public class Convert {

    public static int dpToPixel(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    /**
     * example return *0.0*
     */
    public static double toMegaByte(long value) {
        return (value / (1024f * 1024f));
    }

    /**
     * example return *.00 MB
     */
    public static String toMegaByteString(long value) {
        return String.format(Locale.getDefault(), "%.2f MB", toMegaByte(value));
    }
}
