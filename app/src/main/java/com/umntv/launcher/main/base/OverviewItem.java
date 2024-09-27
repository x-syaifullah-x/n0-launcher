package com.umntv.launcher.main.base;

import androidx.annotation.DrawableRes;

public class OverviewItem {

    public static final String SUBTITLE_DEFAULT = "Datadogs Communications | Universal Media Network";

    @DrawableRes
    public final int icon;
    @DrawableRes
    public final int bg;
    public final String titleAction;
    public final String title;
    public final String subTitle;
    public final String body;
    public final ApkData apkData;

    public OverviewItem(int icon, int bg, String titleAction, String title, String subTitle, String body, ApkData apkData) {
        this.icon = icon;
        this.bg = bg;
        this.titleAction = titleAction;
        this.title = title;
        this.subTitle = subTitle;
        this.body = body;
        this.apkData = apkData;
    }
}