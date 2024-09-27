package com.umntv.launcher.main.row.n0_render.faq;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import net.n0ender.com.R;

public class DataSource {

    private static final OverviewItem ENGLISH = new OverviewItem(
            R.drawable.umn_tv_ic_movies_and_series,
            R.drawable.umn_tv_bg_movies_and_series,
            "ENGLISH",
            "Frequently Asked Questions",
            OverviewItem.SUBTITLE_DEFAULT,
            "Learn to navigate.\nLearn to maintain.\nLearn tricks and shortcuts.",
            new ApkData(
                    "https://www.youtube.com/playlist?list=PLhB5qMsDNiM-iqWKYpQTSS6S_I4IoDWRf",
                    null,
                    false
            )
    );

    private static final OverviewItem ESPANOL = new OverviewItem(
            R.drawable.umn_tv_ic_movies_and_series,
            R.drawable.umn_tv_bg_movies_and_series,
            "ESPANOL",
            "Frequently Asked Questions",
            OverviewItem.SUBTITLE_DEFAULT,
            "Learn to navigate.\nLearn to maintain.\nLearn tricks and shortcuts.",
            new ApkData(
                    "https://www.youtube.com/playlist?list=PLhB5qMsDNiM-1B5_5UU1NMph-wg78y421",
                    null,
                    false
            )
    );

    private static final OverviewItem CHINESE = new OverviewItem(
            R.drawable.umn_tv_ic_movies_and_series,
            R.drawable.umn_tv_bg_movies_and_series,
            "CHINESE",
            "Frequently Asked Questions",
            OverviewItem.SUBTITLE_DEFAULT,
            "Learn to navigate.\nLearn to maintain.\nLearn tricks and shortcuts.",
            new ApkData(
                    "https://www.youtube.com/playlist?list=PLhB5qMsDNiM_4JQhm57nrHtEIcbONtJZm",
                    null,
                    false
            )
    );

    private static final OverviewItem PROMOS = new OverviewItem(
            R.drawable.umn_tv_ic_movies_and_series,
            R.drawable.umn_tv_bg_movies_and_series,
            "PROMOS",
            "Frequently Asked Questions",
            OverviewItem.SUBTITLE_DEFAULT,
            "Learn to navigate.\nLearn to maintain.\nLearn tricks and shortcuts.",
            new ApkData(
                    "https://www.youtube.com/watch_popup?v=A0R6SDRMfek&list=PLhB5qMsDNiM8Hb9lO95lSwDoeOfrRUOUL&index=1",
                    null,
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            ENGLISH, ESPANOL, CHINESE, PROMOS
    );
}
