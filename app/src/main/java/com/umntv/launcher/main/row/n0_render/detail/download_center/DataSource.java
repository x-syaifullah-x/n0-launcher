package com.umntv.launcher.main.row.n0_render.detail.download_center;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import net.n0ender.com.R;

public class DataSource {

    public static final String PACKAGE_NAME_NO_RENDER = "com.umn.n0.render";
    public static final String PACKAGE_NAME_GAME_BROWSER = "com.noreokensoftware.norenderx";
    public static final String PACKAGE_NAME_N0_BROWSER = "com.umn.n0.browser";

    public static final String URL_GAME_BROWSER = "https://n0render.com/N0Launcher/Game_Browser.apk";

    private static final OverviewItem DOWNLOAD_CENTER = new OverviewItem(
            R.drawable.umn_tv_ic_download_center,
            R.drawable.umn_tv_ic_download_center_bg_bg,
            "DOWNLOAD CENTER",
            "WELCOME TO DOWNLOAD CENTER",
            "",
            "Expand your way of thinking by exploring the Download Center.",
            new ApkData(
                    "https://umntv.net/UMNTV/N0Browser.apk",
                    PACKAGE_NAME_N0_BROWSER,
                    false
            )
    );

    private static final OverviewItem N0_BROWSER = new OverviewItem(
            R.drawable.umn_tv_ic_download_center,
            R.drawable.umn_tv_ic_download_center_bg_bg,
            "N0BROWSER",
            "WELCOME TO DOWNLOAD CENTER",
            "",
            "Expand your way of thinking by exploring the Download Center.",
            new ApkData(
                    "https://n0render.com/N0Launcher/N0Browser.apk",
                    PACKAGE_NAME_N0_BROWSER,
                    false
            )
    );

    private static final OverviewItem GAME_BROWSER = new OverviewItem(
            R.drawable.umn_tv_ic_download_center,
            R.drawable.umn_tv_ic_download_center_bg_bg,
            "GAME BROWSER",
            "WELCOME TO DOWNLOAD CENTER",
            "",
            "Expand your way of thinking by exploring the Download Center.",
            new ApkData(
                    URL_GAME_BROWSER,
                    PACKAGE_NAME_NO_RENDER,
                    false
            )
    );

    private static final OverviewItem JIO_BROWSER = new OverviewItem(
            R.drawable.umn_tv_ic_download_center,
            R.drawable.umn_tv_ic_download_center_bg_bg,
            "JIO BROWSER",
            "WELCOME TO DOWNLOAD CENTER",
            "",
            "Expand your way of thinking by exploring the Download Center.",
            new ApkData(
                    "https://umntv.net/UMNTV/Browser.apk",
                    "com.jio.web.androidtv",
                    false
            )
    );

    private static final OverviewItem UPDATE_LAUNCHER = new OverviewItem(
            R.drawable.umn_tv_ic_download_center,
            R.drawable.umn_tv_ic_download_center_bg_bg,
            "N0Render Launcher".toUpperCase(),
            "WELCOME TO DOWNLOAD CENTER",
            "",
            "After installing & updating your launcher please clear the launcher data in the system settings. (Settings>Apps>MATE LAUNCHER> Clear data.",
            new ApkData(
                    "https://n0render.com/N0Launcher/N0Launcher.apk",
//                    "com.umntv.launcher",
                    "-",
                    false
            )
    );

    private static final OverviewItem UMN_LITE = new OverviewItem(
            R.drawable.umn_tv_ic_download_center,
            R.drawable.umn_tv_ic_download_center_bg_bg,
            "UMN LITE",
            "WELCOME TO DOWNLOAD CENTER",
            "",
            "After installing & updating your launcher please clear the launcher data in the system settings. (Settings>Apps>MATE LAUNCHER> Clear data.",
            new ApkData(
                    "https://n0render.com/N0Launcher/N0lite.apk",
                    "com.umntv.launcher.lite", // DOWNLOAD ONLY
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            DOWNLOAD_CENTER,
            UPDATE_LAUNCHER,
            UMN_LITE,
            N0_BROWSER,
            GAME_BROWSER,
            JIO_BROWSER
    );
}