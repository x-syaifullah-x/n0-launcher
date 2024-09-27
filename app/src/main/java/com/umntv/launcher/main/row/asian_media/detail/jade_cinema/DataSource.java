package com.umntv.launcher.main.row.asian_media.detail.jade_cinema;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import net.n0ender.com.R;

import java.util.List;

public class DataSource {

    private static final OverviewItem ITEM_JADE_CINEMA = new OverviewItem(
            R.drawable.asian_media_jade_cinema_ic,
            R.drawable.ic_asian_media_jade_cinema_detail_bg,
            "ASIAN MEDIA",
            "WELCOME TO ASIAN MEDIA",
            OverviewItem.SUBTITLE_DEFAULT,
            "Jade Cinema is a Kodi-based platform that allows users to search for TV shows and movies specifically in Asian countries.\n\nSpecial Thanks to XBMC | Abu Bakar | Syaifullah | IC Network",
            new ApkData(
                    "https://n0render.com/N0Launcher/Kodi/Asian_Media_1.apk",
                    "tv.lets.asianmedia",
                    false
            )
    );

    private static final OverviewItem ITEM_JADE_ANIME = new OverviewItem(
            R.drawable.ic_asian_media_jade_anime_detail_bg,
            R.drawable.ic_asian_media_jade_anime_detail_bg,
            "ANIME",
            "WELCOME TO ANIME",
            OverviewItem.SUBTITLE_DEFAULT,
            "Jade anime allows users to search for their favorite anime movies and series.",
            new ApkData(
                    "https://n0render.com/N0Launcher/Kodi/Anime_.apk",
                    "tv.lets.anime",
                    false
            )
    );

    private static final OverviewItem ASIAN_LIVE_CHAT = new OverviewItem(
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            "ASIAN LIVE CHAT",
            "WELCOME TO 18+ JADE CHAT",
            OverviewItem.SUBTITLE_DEFAULT,
            "Jade Cinema 18 + live chat allows users to view and chat with live Asian women, men, and couples. It also gives you an unlimited supply of xxx, videos, movies, and clips.<br/>Users must be 18 years of age or older.",
            new ApkData(
                    "https://n0render.com/N0Launcher/Kodi/Asian_Chat_1.apk",
                    "tv.lets.asian",
                    true
            )
    );

    public static String URL_CHINESE_XXX_MEDIA = "https://n0render.com/N0Launcher/Chinese%20xxx.apk";

    public static String XXX_CHINESE_MEDIA_PACKAGE_NAME = "com.hhllssqq.app";

    private static final OverviewItem XXX_CHINESE_MEDIA = new OverviewItem(
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            "CHINESE XXX MEDIA",
            "WELCOME TO CHINESE XXX MEDIA",
            OverviewItem.SUBTITLE_DEFAULT,
            "This application provides and direct connection to Chinese XXX media culture.<br/>" +
                    "Datadogs Communications takes no responsibility for the content of this application.<br/>" +
                    "Users must be 18 years of age or older.<br/> This application requires a traditional mouse and keyboard separate or combined.",
            new ApkData(
                    URL_CHINESE_XXX_MEDIA,
                    XXX_CHINESE_MEDIA_PACKAGE_NAME,
                    true
            )
    );

    public static String URL_LIST_CRAWLER = "https://adultsearch.com";

    private static final OverviewItem ITEM_LIST_CRAWLER = new OverviewItem(
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            R.drawable.asian_media_jade_cinema_18_plus_jade_chat_bg,
            "LIST CRAWLERS",
            "WELCOME TO LIST CRAWLERS",
            OverviewItem.SUBTITLE_DEFAULT,
            "WE TAKE ON RESPONSIBILITY.<br/>Users must be 18 years of age or older." + "<br><br>\t\t\t\t\t\t\t\t\t\t\t" + "<b>(AD BLOCKER DISABLE NEEDED)</b>",
            new ApkData(
                    "https://umntv.net/UMNTV/N0Browser.apk",
                    "com.umn.n0.browser," + URL_LIST_CRAWLER,
                    true
            )
    );

    public static final List<OverviewItem> items = List.of(
            ITEM_JADE_CINEMA,
            ITEM_JADE_ANIME,
            ASIAN_LIVE_CHAT,
            XXX_CHINESE_MEDIA,
            ITEM_LIST_CRAWLER
    );
}
