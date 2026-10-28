package com.umntv.launcher.main.row.support.detail.support;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import net.n0ender.com.R;

public class DataSource {

    private static final OverviewItem DINERO_DATA = new OverviewItem(
            R.drawable.asian_media_jade_cinema_ic_abc,
            R.drawable.asian_media_jade_cinema_ic_abc_bg,
            "DINERO DATA",
            "DINERO DATA",
            "Data that works for you support@dinerodata.net",
            "",
            new ApkData(
                    "https://dinerodata.net/?page_id=13",
                    "",
                    false
            )
    );

    private static final OverviewItem TECH_SUPPORT = new OverviewItem(
            R.drawable.ic_ads_your_add_here,
            R.drawable.ic_ads_your_add_here,
            "TECH SUPPORT",
            "TECH SUPPORT",
            "Please contact us if you need any support",
            "",
            new ApkData(
                    "https://n0render.com/tech-support",
                    "",
                    false
            )
    );

    private static final OverviewItem ORAMAL_ENTERPRISES = new OverviewItem(
            R.drawable.asian_media_jade_cinema_ic_abc_ormal_ic,
            R.drawable.asian_media_jade_cinema_ic_abc_ormal,
            "ORAMAL ENTERPRISE",
            "ORAMAL ENTERPRISE",
            "Support local businesses support@oramal.com",
            "",
            new ApkData(
                    "http://oramal.com/?page_id=18",
                    "",
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            DINERO_DATA,
            ORAMAL_ENTERPRISES
    );
}
