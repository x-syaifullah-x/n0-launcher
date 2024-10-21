package com.umntv.launcher.main.row.asian_media;

import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

import net.n0ender.com.R;

public class AsianMedia {

    private static final List<AsianMediaCard> asianMediaCards = new ArrayList<>();

    public static List<AsianMediaCard> setup() {
        if (asianMediaCards.isEmpty()) {
            String[] title = {
                    "JADE CINEMA",
                    "VIKI",
                    "ASIANCRUSH",
                    "CRUNCHYROLL",
//                    "FUNIMATION",
                    "IQIYI",
                    "WU TANG"
            };
            int[] resourceId = {
                    R.drawable.asian_media_jade_cinema_ic,
                    R.drawable.ic_asian_media_viki,
                    R.drawable.ic_asian_media_asianchash,
                    R.drawable.ic_asian_media_crunchyroll,
//                    R.drawable.ic_asian_media_funimation,
                    R.drawable.ic_asian_media_iqiyi,
                    R.drawable.ic_asian_media_tencent,
            };
            String[] packageName = {
                    null,
                    "com.viki.android",
                    "com.dmr.asiancrush.tv",
                    "com.crunchyroll.crunchyroid",
//                    "com.Funimation.FunimationNow.androidtv",
                    "com.iqiyi.i18n.tv",
                    "com.goldenmedia.wutang.tv",
            };

            String[] apkLinkDownload = {
                    null,
                    "https://umntvdealers.net/UMNTV/Apks/VIKI.apk",
                    null,
                    null,
//                    null,
                    null,
                    null
            };

            for (int index = 0; index < title.length; ++index) {
                AsianMediaCard a = new AsianMediaCard();
                a.setTitle(title[index]);
                a.setPackageName(packageName[index]);
                a.setBackgroundStringUri(ResourceHelpers.toStringUri(R.drawable.ic_asian_media_jade_cinema_bg));
                a.setIconStringUri(ResourceHelpers.toStringUri(resourceId[index]));
                a.setLinkApkDownload(apkLinkDownload[index]);
                asianMediaCards.add(a);
            }
        }
        return asianMediaCards;
    }
}
