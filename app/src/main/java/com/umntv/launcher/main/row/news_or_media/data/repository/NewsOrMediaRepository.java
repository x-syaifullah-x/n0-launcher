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
                    "YOUTUBE KIDS",
                    "YOUTUBE TV",
                    "TUBI",
//                    YOUTUBE_ENJOYABLES,
//                    INT_NEWS,
                    "TIKTOK",
                    "FACEBOOK",
            };
            String[] description = {
                    null,
                    null,
                    null,
                    null,
//                    null,
//                    "",
                    null,
                    null,
//                    "Channels Television is a leading 24-hour news channel broadcasting live from Lagos, Nigeria - West Africa. Our mission" +
//                            " is to produce and broadcast television programs of quality and integrity that recognize and challenge, the " +
//                            "intelligence and curiosity of our viewers.",
//                    "Watch CNA's 24-hour live coverage of the latest headlines and top stories from Singapore, Asia and around the world, as" +
//                            " well as documentaries and features that bring you a deeper look at Singapore and Asian issues.",
//                    null,
            };

            String[] packageName = {
                    "com.google.android.youtube.tv",
                    "com.google.android.youtube.tvkids",
                    "com.google.android.youtube.tvunplugged",
                    "com.tubitv",
//                    null,
//                    null,
                    "com.tiktok.tv",
                    "com.facebook.katana",
//                    null,
//                    null,
//                    "com.bloomberg.btva",
            };

            String[] youtubeId = {
                    null,
                    null,
                    null,
                    null,
//                    null,
//                    null,
                    null,
                    null,
//                    "-c8LoR84Xjs",
//                    "XWq5kBlakcQ",
//                    null,
            };
            String[] bannerImage = {
                    ResourceHelpers.toStringUri(R.drawable.ic_apps_banner),
                    ResourceHelpers.toStringUri(R.drawable.ic_apps_banner),
                    ResourceHelpers.toStringUri(R.drawable.ic_apps_banner),
                    ResourceHelpers.toStringUri(R.drawable.ic_apps_banner),
//                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_youtube_tv),
//                    ResourceHelpers.toStringUri(R.drawable.news_and_media_bg_yotube_enjoy_ables),
//                    ResourceHelpers.toStringUri(R.drawable.news_and_media_bg_int_news),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_titok),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_haystack_news_bg),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_african_news_banner),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_asian_news_banner),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_bloomberg),
            };
            String[] cardImage = {
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_youtube),
                    ResourceHelpers.toStringUri(R.drawable.kids_ic_youtube_kids),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_youtube_tv),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_tubi),
//                    ResourceHelpers.toStringUri(R.drawable.news_and_media_bg_yotube_enjoy_ables),
//                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_int_news),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_titok),
                    ResourceHelpers.toStringUri(R.drawable.news_or_media_ic_haystack_news),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_african_news),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_asian_news),
//                    ResourceHelpers.toStringUri(R.drawable.ic_news_bloomberg),
            };
//            String[] iconDetailImage = {
//                    null,
//                    null,
//                    null,
//                    ResourceHelpers.toStringUri(R.drawable.bg_int_news),
//                    null,
//                    null,
////                    ResourceHelpers.toStringUri(R.drawable.ic_news_african_news_detail_icon),
////                    ResourceHelpers.toStringUri(R.drawable.ic_news_asian_news_detail_icon),
////                    null,
//            };

            String[] apkUrl = {
                    null,
                    null,
                    null,
                    null,
//                    null,
//                    null,
                    null,
                    "https://umntvdealers.net/UMNTV/Apks/com.facebook.katana_.apk",
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
