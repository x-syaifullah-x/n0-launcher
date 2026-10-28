package com.umntv.launcher.main.row.news_or_media.data.repository;

import com.umntv.launcher.main.row.news_or_media.domain.model.NewsMediaModel;
import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

import net.n0ender.com.R;

public class NewsOrMediaRepository {

    public static String YOUTUBE_ENJOYABLES = "YOUTUBE ENJOYABLES";

    public static String INT_NEWS = "INT NEWS";

    private static final List<NewsMediaModel> v = new ArrayList<>();

    public static List<NewsMediaModel> getItems() {
        if (v.isEmpty()) {
            String[] title = {
                    "YOUTUBE",
                    "SMARTTUBE",
                    "TUBI",
                    "PLUTO TV",
                    "PLEX",
                    "FREEVEE",
                    "TIKTOK",
            };
            String[] description = {
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
            };

            String[] packageName = {
                    "com.google.android.youtube.tv",
                    "com.teamsmart.videomanager.tv",
                    "com.tubitv",
                    "tv.pluto.android",
                    "com.plexapp.android",
                    "com.imdbtv.livingroom",
                    "com.tiktok.tv",
            };

            String[] youtubeId = {
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
            };
            String[] bannerImage = {
                    ResourceHelpers.toStringUri(R.drawable.ic_apps_banner),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_smarttube),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_tubi),
                    ResourceHelpers.toStringUri(R.drawable.news_and_media_bg_pluto_tv),
                    ResourceHelpers.toStringUri(R.drawable.news_and_media_bg_plex),
                    ResourceHelpers.toStringUri(R.drawable.news_and_media_bg_freevee),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_titok),
            };
            String[] cardImage = {
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_youtube),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_smarttube),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_tubi),
                    ResourceHelpers.toStringUri(R.drawable.news_and_media_bg_pluto_tv),
                    ResourceHelpers.toStringUri(R.drawable.news_and_media_bg_plex),
                    ResourceHelpers.toStringUri(R.drawable.news_and_media_bg_freevee),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_titok),
            };

            String[] apkUrl = {
                    null,
                    "https://n0render.com/N0Launcher/com.teamsmart.videomanager.tv_27.53-19.apk",
                    null,
                    null,
                    null,
                    null,
                    null,
            };

            for (int index = 0; index < title.length; ++index) {
                v.add(
                        buildNewsInfo(
                                title[index],
                                description[index],
                                youtubeId[index],
                                cardImage[index],
                                bannerImage[index],
                                packageName[index],
                                apkUrl[index]
                        )
                );
            }
        }
        return v;
    }

    private static NewsMediaModel buildNewsInfo(
            String title,
            String description,
            String youtubeId,
            String cardImageUrl,
            String backgroundImageUrl,
            String packageName,
            String apkUrl) {
        NewsMediaModel newsMediaModel = new NewsMediaModel();
        newsMediaModel.setPackageName(packageName);
        newsMediaModel.setTitle(title);
        newsMediaModel.setDetailDescription(description);
        newsMediaModel.setIconStringUri(cardImageUrl);
        newsMediaModel.setBackgroundStringUri(backgroundImageUrl);
        newsMediaModel.setYoutubeId(youtubeId);
        newsMediaModel.setApkUrl(apkUrl);
        return newsMediaModel;
    }
}
