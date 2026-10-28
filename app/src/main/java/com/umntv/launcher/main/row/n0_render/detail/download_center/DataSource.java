package com.umntv.launcher.main.row.n0_render.detail.download_center;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import net.n0ender.com.R;

public class DataSource {

    public static final String NO_RENDER_PACKAGE_NAME = "com.umn.n0.render";
    public static final String GAME_BROWSER_PACKAGE_NAME = "com.noreokensoftware.norenderx";
    public static final String N0_BROWSER_PACKAGE_NAME = "com.umn.n0.browser";

    public static final String URL_GAME_BROWSER = "https://n0render.com/N0Launcher/Game_Browser.apk";

    private static final String DOWNLOAD_CENTER_TITLE = "WELCOME TO DOWNLOAD CENTER";

    private static final OverviewItem DOWNLOAD_CENTER = new OverviewItem(
            R.drawable.umn_tv_ic_download_center,
            R.drawable.umn_tv_ic_download_center_bg_bg,
            "DOWNLOAD CENTER",
            DOWNLOAD_CENTER_TITLE,
            "",
            "Expand your way of thinking by exploring the Download Center.",
            new ApkData(
                    "https://umntv.net/UMNTV/N0Browser.apk",
                    N0_BROWSER_PACKAGE_NAME,
                    false
            )
    );

    private static final OverviewItem N0_BROWSER = new OverviewItem(
            R.drawable.umn_tv_ic_download_center,
            R.drawable.umn_tv_ic_download_center_bg_bg,
            "N0BROWSER",
            DOWNLOAD_CENTER_TITLE,
            "",
            "Expand your way of thinking by exploring the Download Center.",
            new ApkData(
                    "https://n0render.com/N0Launcher/N0Browser.apk",
                    N0_BROWSER_PACKAGE_NAME,
                    false
            )
    );

    private static final OverviewItem GAME_BROWSER = new OverviewItem(
            R.drawable.umn_tv_ic_download_center,
            R.drawable.umn_tv_ic_download_center_bg_bg,
            "GAME BROWSER",
            DOWNLOAD_CENTER_TITLE,
            "",
            "Expand your way of thinking by exploring the Download Center.",
            new ApkData(
                    URL_GAME_BROWSER,
                    NO_RENDER_PACKAGE_NAME,
                    false
            )
    );

    private static final OverviewItem JIO_BROWSER = new OverviewItem(
            R.drawable.umn_tv_ic_download_center,
            R.drawable.umn_tv_ic_download_center_bg_bg,
            "JIO BROWSER",
            DOWNLOAD_CENTER_TITLE,
            "",
            "Expand your way of thinking by exploring the Download Center.",
            new ApkData(
                    "https://umntv.net/UMNTV/Browser.apk",
                    "com.jio.web.androidtv",
                    false
            )
    );

    private static final OverviewItem N0RENDER_LAUNCHER = new OverviewItem(
            R.drawable.umn_tv_ic_download_center,
            R.drawable.umn_tv_ic_download_center_bg_bg,
            "N0RENDER LAUNCHER",
            DOWNLOAD_CENTER_TITLE,
            "",
            "After installing & updating your launcher please clear the launcher data in the system settings. (Settings>Apps>MATE LAUNCHER> Clear data.",
            new ApkData(
                    "https://n0render.com/N0Launcher/N0Launcher.apk",
                    "-1", // DOWNLOAD ONLY
                    false
            )
    );

    private static final OverviewItem UMN_LITE = new OverviewItem(
            R.drawable.umn_tv_ic_download_center,
            R.drawable.umn_tv_ic_download_center_bg_bg,
            "UMN LITE",
            DOWNLOAD_CENTER_TITLE,
            "",
            "After installing & updating your launcher please clear the launcher data in the system settings. (Settings>Apps>MATE LAUNCHER> Clear data.",
            new ApkData(
                    "https://n0render.com/N0Launcher/N0lite.apk",
                    "-1", // DOWNLOAD ONLY
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            DOWNLOAD_CENTER,
            N0RENDER_LAUNCHER,
            UMN_LITE,
            N0_BROWSER,
            GAME_BROWSER,
            JIO_BROWSER
    );
}