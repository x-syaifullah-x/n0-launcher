package com.umntv.launcher.main.row.news_or_media.data.repository;

import com.umntv.launcher.main.row.news_or_media.presentation.detail.OverviewItem;

import net.n0ender.com.R;

import java.util.List;

public class DataSource {

    private static final OverviewItem AFRICAN_NEWS = new OverviewItem(
            R.drawable.news_or_media_ic_int_news,
            R.drawable.news_or_media_int_news_bg_int_news,
            "NIGERIA",
            "AFRICAN NEWS",
            "",
            "We bring you all the latest and breaking news happening in Nigeria. You will also find interesting headline topics from news from around the world on different topical issues in Politics, Health, Business, Entertainment, Environment, Sports, and more.\n" +
                    "\n" +
                    "TVC News...First With Breaking News",
//            "https://www.youtube.com/watch_popup?v=ydjm-aR9XEs",
//            "https://www.youtube.com/embed/ydjm-aR9XEs?autoplay=1",
            "https://www.youtube.com/results?search_query=live+nigeria+news",
            null
    );

    private static final OverviewItem ASIAN_NEWS = new OverviewItem(
            R.drawable.news_or_media_ic_int_news,
            R.drawable.news_or_media_int_news_bg_int_news,
            "SINGAPORE",
            "ASIAN NEWS",
            "",
            "Watch CNA's 24-hour live coverage of the latest headlines and top stories from Singapore, Asia and around the world, as" +
                    " well as documentaries and features that bring you a deeper look at Singapore and Asian issues.",
//            "https://www.youtube.com/watch_popup?autoplay=1&v=XWq5kBlakcQ",
            "https://www.youtube.com/embed/XWq5kBlakcQ?autoplay=1",
            null
    );

    private static final OverviewItem INDIA = new OverviewItem(
            R.drawable.news_or_media_ic_int_news,
            R.drawable.news_or_media_int_news_bg_int_news,
            "INDIA",
            "INDIA NEWS",
            "",
            "India Today TV is India's leading English News Channel. India Today YouTube channel offers latest news videos on Politics, Business, Cricket, Bollywood, Lifestyle, Auto, Technology, Travel, Entertainment and a lot more.",
//            "https://www.youtube.com/watch_popup?v=Nen3UXaWDDE",
            "https://www.youtube.com/embed/Nen3UXaWDDE?autoplay=1",
            null
    );

    private static final OverviewItem UK = new OverviewItem(
            R.drawable.news_or_media_ic_int_news,
            R.drawable.news_or_media_int_news_bg_int_news,
            "UK",
            "UK NEWS",
            "",
            "The best of Sky News video from the UK and around the world.",
//            "https://www.youtube.com/watch_popup?autoplay=1&v=9Auq9mYxFEE",
            "https://www.youtube.com/embed/9Auq9mYxFEE?autoplay=1",
            null
    );

    public static final List<OverviewItem> items = List.of(
            AFRICAN_NEWS,
            ASIAN_NEWS,
            INDIA,
            UK
    );
}
