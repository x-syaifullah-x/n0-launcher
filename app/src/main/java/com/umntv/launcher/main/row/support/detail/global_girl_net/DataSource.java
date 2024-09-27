package com.umntv.launcher.main.row.support.detail.global_girl_net;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import net.n0ender.com.R;

public class DataSource {

    private static final OverviewItem DINERO_DATA = new OverviewItem(
            R.drawable.ic_ads_global_inc_card,
            R.drawable.ic_ads_global_inc_bg,
            "PLAY",
            "GLOBAL GIRLS NET",
            "",
            "Grow your business by placing your ads on our platform for as little as $5 a month.<br/>Users will have a direct link to your information or content.<br/>Contact us support@umntv.com",
            new ApkData(
                    "https://www.youtube.com/playlist?list=PLhB5qMsDNiM-rlANEez6jigbfST_nZRmL",
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
            DINERO_DATA,
            ITEM_GLOBAL_GIRL_NET,
            ITEM_GGN_SHOPPING,
            ITEM_GGN_ACCOUNTING
    );
}
