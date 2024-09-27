package com.umntv.launcher.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class AndroidStore {

    public static void open(Context context, String packageName) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        try {
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            context.startActivity(intent);
        } catch (android.content.ActivityNotFoundException ignored) {
            try {
                intent.setData(Uri.parse("market://details?id=" + packageName));
                context.startActivity(intent);
            } catch (Throwable e) {
                Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
