package com.umntv.launcher.main.row.utilities.details.preload_tv;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import net.n0ender.com.R;

import java.util.List;

public class DataSource {

    private static final String URL_WELCOME = "https://n0render.com/N0Launcher/Preloads/welcome.tmb";
    private static final String URL_WELCOME_BACK = "https://n0render.com/N0Launcher/Preloads/welcomebk.tmb";
    private static final String URL_MAC = "https://n0render.com/N0Launcher/Preloads/mac.tmb";
    private static final String URL_CUSTOMER_1 = "https://n0render.com/N0Launcher/Preloads/cus1.tmb";
    private static final String URL_CUSTOMER_2 = "https://n0render.com/N0Launcher/Preloads/cus2.tmb";
    public static final String URL_SELF_LOAD = "https://n0render.com/Selfload";
    public static final String URL_CODE_REQUEST = "n0browser://n0render.com/self-loaded-preload";

    private static final OverviewItem WELCOME = new OverviewItem(
            R.drawable.ic_utilities_preload_tv_new,
            R.drawable.ic_utilities_preload_tv_new,
            "WELCOME",
            "LIVE TV SETTINGS<GENERAL<RESTORE",
            "",
            "LIVE TV < SETTINGS < GENERAL < RESTORE < (Select local backup) < (Internal shared storage) < download < PRELOADED#",
            new ApkData(
                    URL_WELCOME,
                    null,
                    true
            )
    );

    private static final OverviewItem WELCOME_BACK = new OverviewItem(
            R.drawable.ic_utilities_preload_tv_new,
            R.drawable.ic_utilities_preload_tv_new,
            "WELCOME BACK",
            "LIVE TV SETTINGS<GENERAL<RESTORE",
            "",
            "LIVE TV < SETTINGS < GENERAL < RESTORE < (Select local backup) < (Internal shared storage) < download < PRELOADED#",
            new ApkData(
                    URL_WELCOME_BACK,
                    null,
                    true
            )
    );

    private static final OverviewItem MAC = new OverviewItem(
            R.drawable.ic_utilities_preload_tv_new,
            R.drawable.ic_utilities_preload_tv_new,
            "MAC",
            "LIVE TV SETTINGS<GENERAL<RESTORE",
            "",
            "LIVE TV < SETTINGS < GENERAL < RESTORE < (Select local backup) < (Internal shared storage) < download < PRELOADED#",
            new ApkData(
                    URL_MAC,
                    null,
                    true
            )
    );

    private static final OverviewItem CUSTOMER_1 = new OverviewItem(
            R.drawable.ic_utilities_preload_tv_new,
            R.drawable.ic_utilities_preload_tv_new,
            "CUSTOMER 1",
            "LIVE TV SETTINGS<GENERAL<RESTORE",
            "",
            "LIVE TV < SETTINGS < GENERAL < RESTORE < (Select local backup) < (Internal shared storage) < download < PRELOADED#",
            new ApkData(
                    URL_CUSTOMER_1,
                    null,
                    true
            )
    );

    private static final OverviewItem CUSTOMER_2 = new OverviewItem(
            R.drawable.ic_utilities_preload_tv_new,
            R.drawable.ic_utilities_preload_tv_new,
            "CUSTOMER 2",
            "LIVE TV SETTINGS<GENERAL<RESTORE",
            "",
            "LIVE TV < SETTINGS < GENERAL < RESTORE < (Select local backup) < (Internal shared storage) < download < PRELOADED#",
            new ApkData(
                    URL_CUSTOMER_2,
                    null,
                    true
            )
    );

    private static final OverviewItem SELF_LOAD = new OverviewItem(
            R.drawable.ic_utilities_preload_tv_new,
            R.drawable.ic_utilities_preload_tv_new,
            "SELF LOAD",
            "ENTER YOUR PRELOAD CODE",
            "",
            "Please request a preload code",
            new ApkData(
                    URL_SELF_LOAD,
                    null,
                    true
            )
    );

    private static final OverviewItem CODE_REQUEST = new OverviewItem(
            R.drawable.ic_utilities_preload_tv_new,
            R.drawable.ic_utilities_preload_tv_new,
            "REQUEST CODE",
            "REQUEST CODE",
            "",
            "Please use your account activation email to request your preload backup.",
            new ApkData(
                    URL_CODE_REQUEST,
                    null,
                    true
            )
    );

    public static final List<OverviewItem> items = List.of(
            WELCOME,
            WELCOME_BACK,
            MAC,
            CUSTOMER_1,
            CUSTOMER_2,
            SELF_LOAD,
            CODE_REQUEST
    );
}
