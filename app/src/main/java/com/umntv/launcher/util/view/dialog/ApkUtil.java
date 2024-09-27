package com.umntv.launcher.util.view.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

public class ApkUtil {

    private static void install(Context context, Uri uriOutput) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(Intent.EXTRA_NOT_UNKNOWN_SOURCE, true);
        intent.setDataAndType(uriOutput, "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    private static void downloadToInternalDirectoryAndInstall(Context context, String link, File dirDestination) {
        Download.toInternalDirectory(context, link, dirDestination, uriOutput -> {
            ApkUtil.install(context, uriOutput);
        });
    }

    public static void downloadToCacheDirAndInstall(Context context, String link) {
        File dirDestination = new File(context.getCacheDir(), "apk-download");
        downloadToInternalDirectoryAndInstall(context, link, dirDestination);
    }
}