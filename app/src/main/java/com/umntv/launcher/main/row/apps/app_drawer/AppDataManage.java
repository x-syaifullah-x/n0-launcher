package com.umntv.launcher.main.row.apps.app_drawer;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

import com.umntv.launcher.base.Card;
import com.umntv.launcher.constant.AppBuild;
import com.umntv.launcher.main.row.n0_render.detail.download_center.DataSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppDataManage {

    public static List<String> hideApps = List.of(
            AppBuild.APPLICATION_ID,
            "ws.umn.net",  /* WORLD STAR TV IN UMN_TV/MEDIA CENTER */
            "lc.umn.net", /* 18+ LIVE CHAT IN UMN_TV/MEDIA CENTER */
            "jc.umn.net", /* 18+ JADE CHAT IN ASIAN_MEDIA/JADE_CINEMA */
            "com.jio.web.androidtv" /* BrowseHer */,
            "com.doc.paymentchecker",
            "com.teamviewer.quicksupport.market",
            "mobi.omegacentauri.SpeakerBoost",
            "com.ndcsolution.androidtv.leankeykeyboard",
            "com.furnaghan.android.photoscreensaver",
            com.umntv.launcher.main.row.asian_media.detail.jade_cinema.DataSource.XXX_CHINESE_MEDIA_PACKAGE_NAME,
            com.umntv.launcher.main.row.asian_media.detail.jade_cinema.DataSource.PACKAGE_ASIAN_LIVE_CHAT,
            DataSource.PACKAGE_NAME_N0_BROWSER,
            DataSource.PACKAGE_NAME_GAME_BROWSER,
            DataSource.PACKAGE_NAME_NO_RENDER,
            com.umntv.launcher.main.row.n0_render.media_center.DataSource.PACKAGE_NAME_18_PLUS_LIVE_CHAT,
            "n0.saver.render",
            com.umntv.launcher.main.row.games.retro_center.DataSource.PACKAGE_NAME_RETRO_MODE,
            "com.retroarch.aarch64",
            "net.n0.render",
             "org.mupen64plusae.v3.fzurita",
            "com.liskovsoft.leankeykeyboard"
    );

    public static ArrayList<Card> getLaunchAppList(Context mContext) {
        PackageManager packageManager = mContext.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(intent, 0);
        Iterator<ResolveInfo> resolveInfoIterator;
        ArrayList<Card> launchApps = new ArrayList<>();
        if (resolveInfo.size() != 0) {
            resolveInfoIterator = resolveInfo.iterator();
            while (resolveInfoIterator.hasNext()) {
                ResolveInfo next = resolveInfoIterator.next();
                LaunchApp launchApp = new LaunchApp();
//                Log.i("abc", next.activityInfo.packageName);
                Drawable banner = next.activityInfo.loadBanner(packageManager);
                Drawable icon = next.activityInfo.loadIcon(packageManager);
                if (banner != null) {
                    launchApp.setIconDrawable(banner);
                } else {
                    launchApp.setIconDrawable(icon);
                }
                launchApp.setTitle(next.activityInfo.loadLabel(packageManager).toString());
                launchApp.setPackageName(next.activityInfo.packageName);
                launchApp.setDataDir(next.activityInfo.applicationInfo.publicSourceDir);
                launchApp.setLauncherName(next.activityInfo.name);
                String pkgName = next.activityInfo.packageName;
                PackageInfo mPackageInfo;
                try {
                    mPackageInfo = mContext.getPackageManager().getPackageInfo(pkgName, 0);
                    if ((mPackageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) > 0) {
                        launchApp.setSysApp(true);
                    }
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }

                if (!hideApps.contains(launchApp.getPackageName())) {
                    launchApps.add(launchApp);
                }
            }
        }
        return launchApps;
    }
}
