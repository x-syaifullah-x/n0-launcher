package com.umntv.launcher.main.row.tools;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.umntv.launcher.util.ResourceHelpers;

import net.n0ender.com.R;

import java.util.ArrayList;
import java.util.List;

public class Tools {

    private static final List<ToolsCard> list = new ArrayList<>();

    public static List<ToolsCard> setup(Context c) {
        if (!list.isEmpty()) return list;

        String[] title = {
                "AI SMART",
                "TEVEGRAM",
                "TVMAIL",
                "Zoog VPN".toUpperCase(),
                "SEND FILES TO TV",
                "Screencast".toUpperCase(),
        };
        int[] resourceId = {
                R.drawable.ai_smeartassist_ic,
                R.drawable.tools_telegram_ic,
                R.drawable.ic_tv_mail,
                R.drawable.ic_zoog_vpn,
                R.drawable.ic_utilities_send_files_to_tv,
                R.drawable.ic_utilities_screen_cast,
        };
        String[] packageName = {
                "com.gowittgroup.smartassist",
                "cassian.telegram.ooa.pro",
                "not.a.bug.tvmail",
                "com.zoogvpn.android",
                "com.yablio.sendfilestotv",
                "com.ionitech.airscreen"
        };

        String[] apkUrl = {
                null,
                null,
                null,
//                "https://n0render.com/N0Launcher/TVmail.apk",
                null,
                null,
                null,
        };

        for (int index = 0; index < title.length; ++index) {
            ToolsCard s = new ToolsCard();
            s.setTitle(title[index]);
            s.setIconDrawable(ContextCompat.getDrawable(c, resourceId[index]));
            s.setBackgroundStringUri(ResourceHelpers.toStringUri(R.drawable.bg_row_support_aa));
            s.setPackageName(packageName[index]);
            s.setApkUrl(apkUrl[index]);
            list.add(s);
        }
        return list;
    }
}
