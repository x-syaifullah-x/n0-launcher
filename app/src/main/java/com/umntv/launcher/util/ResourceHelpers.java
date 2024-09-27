package com.umntv.launcher.util;

import android.net.Uri;

import androidx.annotation.AnyRes;

import com.umntv.launcher.constant.AppBuild;

public class ResourceHelpers {

    public static Uri toUri(String packageName, @AnyRes int res) {
        return Uri.parse("android.resource://" + packageName + "/" + res);
    }

    public static String toStringUri(String packageName, @AnyRes int res) {
        return toUri(packageName, res).toString();
    }

    public static String toStringUri(@AnyRes int res) {
        return toStringUri(AppBuild.APPLICATION_ID, res);
    }
}
