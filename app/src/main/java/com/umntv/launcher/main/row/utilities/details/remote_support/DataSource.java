package com.umntv.launcher.main.row.utilities.details.remote_support;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import net.n0ender.com.R;

import java.util.List;

public class DataSource {

    private static final OverviewItem ANY_DESK = new OverviewItem(
            R.drawable.ic_utilities_remote_support,
            R.drawable.ic_utilities_remote_support,
            "ANYDESK",
            "REMOTE SUPPORT",
            "",
            "",
            new ApkData(
                    "https://play.google.com",
                    "com.anydesk.anydeskandroid",
                    false
            )
    );

    private static final OverviewItem TEAMVIEWER = new OverviewItem(
            R.drawable.ic_utilities_remote_support,
            R.drawable.ic_utilities_remote_support,
            "TEAMVIEWER",
            "REMOTE SUPPORT",
            "",
            "",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/QuickSupport-15.21.113.apk",
                    "com.teamviewer.quicksupport.market",
                    false
            )
    );

    private static final OverviewItem TV_ADDON = new OverviewItem(
            R.drawable.ic_utilities_remote_support,
            R.drawable.ic_utilities_remote_support,
            "TV ADDON",
            "REMOTE SUPPORT",
            "",
            "",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/QuickSupport Add-On-10.0.3086.apk",
                    "com.teamviewer.quicksupport.addon.aosp",
                    false
            )
    );

    private static final OverviewItem ZIP_UPLOAD = new OverviewItem(
            R.drawable.ic_utilities_remote_support,
            R.drawable.ic_utilities_remote_support,
            "ZIP-UPLOAD",
            "REMOTE SUPPORT",
            "",
            "",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/zip-upload.zip",
                    null,
                    true
            )
    );

    public static final OverviewItem APK_UPLOAD = new OverviewItem(
            R.drawable.ic_utilities_remote_support,
            R.drawable.ic_utilities_remote_support,
            "APK-UPLOAD",
            "REMOTE SUPPORT",
            "",
            "",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/apk-upload.apk",
                    null,
                    false
            )
    );

    private static final OverviewItem BUTTON_MAP = new OverviewItem(
            R.drawable.ic_utilities_remote_support,
            R.drawable.ic_utilities_remote_support,
            "BUTTON MAP",
            "REMOTE SUPPORT",
            "",
            "",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/Button-Mapper-Pro).apk",
                    "flar2.homebutton",
                    false
            )
    );
    public static final List<OverviewItem> items = List.of(
            ANY_DESK,
            TEAMVIEWER,
            TV_ADDON,
            ZIP_UPLOAD,
            APK_UPLOAD,
            BUTTON_MAP
    );
}
