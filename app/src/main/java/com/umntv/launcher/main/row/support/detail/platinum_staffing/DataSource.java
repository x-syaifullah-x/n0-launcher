package com.umntv.launcher.main.row.support.detail.platinum_staffing;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import net.n0ender.com.R;

import java.util.List;

public class DataSource {

    private static final OverviewItem PLAY = new OverviewItem(
            R.drawable.ic_ads_plat_img,
            R.drawable.ic_ads_platinum,
            "PLAY",
            "PLATINUM STAFFING",
            "",
            "Platinum Staffing, Inc. is a full service, staffing agency that has trained and certified recruiters<br/>that are specialists in their respective fields. We staff manufacturing machining. IT, medical,<br/>executive level, engineering, administration and more.<br/><br/>Phone: 1(763) 560-8430 中国人 EXT. 300'",
            new ApkData(
                    "https://www.youtube.com/playlist?list=PLhB5qMsDNiM9eNGxVVK0KOdQhIWDQG_ft",
                    "jade.umn.net",
                    false
            )
    );

    private static final OverviewItem OPEN_SITE = new OverviewItem(
            R.drawable.ic_ads_plat_img,
            R.drawable.ic_ads_platinum,
            "OPEN SITE",
            "PLATINUM STAFFING",
            "",
            "Platinum Staffing, Inc. is a full service, staffing agency that has trained and certified recruiters<br/>that are specialists in their respective fields. We staff manufacturing machining. IT, medical,<br/>executive level, engineering, administration and more.<br/><br/>Phone: 1(763) 560-8430 中国人 EXT. 300'",
            new ApkData(
                    "https://www.platinumstaffing.net",
                    "jade.umn.net",
                    false
            )
    );

    private static final OverviewItem ITEM_GLOBAL_GIRL_NET = new OverviewItem(
            R.drawable.ic_umn_tv_network_detail_global_girl_net,
            R.drawable.ic_umn_tv_network_detail_global_girl_net,
            "GLOBAL GIRLS NET",
            "WELCOME TO GLOBAL GIRLS NET",
            OverviewItem.SUBTITLE_DEFAULT,
            "Join the social media revolution!<br/>" +
                    "Download it on your mobile device today.<br/>" +
                    "Network with our global community.",
            new ApkData(
                    "https://umntv.net/UMNTV/N0Browser.apk",
                    "com.umn.n0.browser,https://globelgirl-2c269.web.app",
                    false
            )
    );

    private static final OverviewItem ITEM_GGN_SHOPPING = new OverviewItem(
            R.drawable.ic_umn_tv_network_detail_ggn_shopping,
            R.drawable.ic_umn_tv_network_detail_ggn_shopping,
            "GGN SHOPPING",
            "WELCOME TO GGN SHOPPING",
            OverviewItem.SUBTITLE_DEFAULT,
            "Check out the newest and the latest products on the market.<br/>" +
                    "Shop for your business, shop for your family, shopping for adventure.",
            new ApkData(
                    "https://umntv.net/UMNTV/N0Browser.apk",
                    "com.umn.n0.browser,https://globalgnet.net",
                    false
            )
    );

    private static final OverviewItem ITEM_GGN_ACCOUNTING = new OverviewItem(
            R.drawable.ic_umn_tv_network_detail_ggn_accounting,
            R.drawable.ic_umn_tv_network_detail_ggn_accounting,
            "GGN ACCOUNTING",
            "WELCOME TO GGN ACCOUNTING",
            OverviewItem.SUBTITLE_DEFAULT,
            "Home and business accounting software!<br/>" +
                    "Organize your home and/or business with user-friendly accounting software",
            new ApkData(
                    "https://umntv.net/UMNTV/N0Browser.apk",
                    "com.umn.n0.browser,https://account.globalgnet.net",
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            PLAY,
            OPEN_SITE
    );
}
