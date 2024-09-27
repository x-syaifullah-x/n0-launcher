package com.umntv.launcher.main.row.n0_render.network;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import net.n0ender.com.R;

public class DataSource {

    private static final OverviewItem MY_ACCOUNT = new OverviewItem(
            R.drawable.ic_umn_tv_network_detail_whats_new_account,
            R.drawable.ic_umn_tv_network_detail_whats_new_account,
            "MY ACCOUNT",
            "WELCOME TO MY ACCOUNT",
            OverviewItem.SUBTITLE_DEFAULT,
            "",
            new ApkData(
                    "https://n0render.com/N0Launcher/N0accounting.apk",
                    "net.n0.render",
                    false
            )
    );

    private static final OverviewItem SPEED_TEST = new OverviewItem(
            R.drawable.ic_umn_tv_network_detail_whats_new_speed_test,
            R.drawable.ic_umn_tv_network_detail_whats_new_speed_test,
            "SPEED TEST",
            "WELCOME TO SPEED TEST",
            OverviewItem.SUBTITLE_DEFAULT,
            "",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/FAST%20Speed%20Test_.apk",
                    "com.netflix.Speedtest",
                    false
            )
    );

    private static final OverviewItem ITEM_WHATS_NEWS = new OverviewItem(
            R.drawable.ic_umn_tv_network_detail_whats_new_bg_bg,
            R.drawable.ic_umn_tv_network_detail_whats_new_bg_bg,
            "WHAT'S NEW",
            "WELCOME TO WHAT'S NEW",
            OverviewItem.SUBTITLE_DEFAULT,
            "Check out the latest devices and accessories! Stay in touch with the latest movies and TV show reviews and more.",
            new ApkData(
                    "https://umntvdealers.net/?page_id=34",
                    null,
                    false
            )
    );

    private static final OverviewItem FAQ = new OverviewItem(
            R.drawable.ic_umn_tv_network_detail_whats_new_bg,
            R.drawable.ic_umn_tv_network_detail_whats_new_bg,
            "FAQ",
            "WELCOME TO FAQ",
            OverviewItem.SUBTITLE_DEFAULT,
            "",
            new ApkData(
                    "https://www.youtube.com/playlist?list=PLhB5qMsDNiM-iqWKYpQTSS6S_I4IoDWRf",
                    null,
                    false
            )
    );
    public static final List<OverviewItem> items = List.of(
            MY_ACCOUNT,
            SPEED_TEST,
            ITEM_WHATS_NEWS,
            FAQ
    );
}
