package com.umntv.launcher.main.row.n0_render.media_center;

import net.n0ender.com.R;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

public class DataSource {

    private static final OverviewItem MEDIA_CENTER = new OverviewItem(
            R.drawable.umn_tv_ic_media_center,
            R.drawable.ic_umn_tv_media_center_icon_new,
            "MEDIA CENTER",
            "WELCOME TO MEDIA CENTER",
            OverviewItem.SUBTITLE_DEFAULT,
            "Media Center is a Kodi-based platform that allows users to search the web for content.\n\nSpecial Thanks to XBMC | Abu Bakar | Syaifullah | IC Network",
            new ApkData(
                    "https://n0render.com/N0Launcher/Kodi/Media_Center_1.apk",
                    "tv.lets.www",
                    false
            )
    );

    public static final OverviewItem SPORTS = new OverviewItem(
            R.drawable.ic_umn_tv_media_center_world_start_tv_bg_new,
            R.drawable.ic_umn_tv_media_center_world_start_tv_bg_new,
            "SPORTS",
            "WELCOME TO SPORTS",
            OverviewItem.SUBTITLE_DEFAULT,
            "You can find live sports events. Live pay-per-view events and replays",
//            "UMN SPORTS is an 18 + application that allows users to browse for the latest funniest, violent, and toxic videos trending on social media.",
            new ApkData(
                    "https://n0render.com/N0Launcher/Kodi/N0Sports_1.apk",
                    "tv.lets.sports",
                    true
            )
    );

    private static final OverviewItem PLUS_18_LIVE_CHAT = new OverviewItem(
            R.drawable.ic_umn_tv_media_center_18_plus_bg_live_chat,
            R.drawable.ic_umn_tv_media_center_18_plus_bg_live_chat,
            "18+ LIVE CHAT",
            "WELCOME TO 18+ LIVE CHAT",
            OverviewItem.SUBTITLE_DEFAULT,
            "18 + live chat allows users to view and chat with live nude women, men, or couples from around the world.\nIt also gives you access to an unlimited supply of XXX videos, clips, and movies.<br/>Users must be 18 years of age or older.",
            new ApkData(
                    "https://n0render.com/N0Launcher/Kodi/Live_chat_1.apk",
                    "tv.lets.chat",
                    true
            )
    );

    public static final List<OverviewItem> items = List.of(
            MEDIA_CENTER,
//            TOPAZ_CINEMA,
            SPORTS,
            PLUS_18_LIVE_CHAT
    );
}
