package com.umntv.launcher.main.row.apps;

import com.umntv.launcher.base.Card;
import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

import net.n0ender.com.R;

public class Apps {

    private static final List<Card> list = new ArrayList<>();

    public static List<Card> setup() {
        if (!list.isEmpty()) return list;

        String[] title = {
//                "APP DRAWER",
                "Google Play",
                "CHROME ",
                "GOOGLE MEET",
                "GOOGLE MOVIES & TV",
                "TED TV",
                "TWITCH",
        };
        int[] resourceId = {
//                R.drawable.ic_apps_app_drawer,
                R.drawable.ic_apps_google_play,
                R.drawable.ic_apps_chrome,
                R.drawable.ic_apps_google_meet,
                R.drawable.ic_play_movies_tv,
                R.drawable.ic_ted_talks,
                R.drawable.ic_twitch,
        };
        String[] packageName = {
//                null,
                "com.android.vending",
                "com.android.chrome",
                "com.google.android.apps.tachyon",
                "com.google.android.videos",
                "com.ted.android.tv",
                "tv.twitch.android.app",
        };

        String backgroundImageUrl = ResourceHelpers.toStringUri(R.drawable.ic_apps_banner);

        String[] detailClass = {
//                AppDrawerFragment.class.getName(),
                null,
                null,
                null,
                null,
                null,
                null
        };

        for (int index = 0; index < title.length; ++index) {
            AppsCard a = new AppsCard();
            a.setClassNameActivityDetail(detailClass[index]);
            a.setTitle(title[index]);
            a.setPackageName(packageName[index]);
            a.setBackgroundStringUri(backgroundImageUrl);
            a.setIconStringUri(ResourceHelpers.toStringUri(resourceId[index]));
            list.add(a);
        }
        return list;
    }
}
