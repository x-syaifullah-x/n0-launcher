package com.umntv.launcher.main.row.e_kids;

import net.n0ender.com.R;

import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

public class Kids {

    public static final String TITLE_E_LEARNING = "E-LEARNING";

    private static final List<KidsCard> kids = new ArrayList<>();

    public static List<KidsCard> setup() {
        if (kids.isEmpty()) {
            String[] title = {
                    "E-KIDS MEDIA",
                    "YOUTUBE KIDS",
                    TITLE_E_LEARNING,
                    "IXL",
                    "KIDS NURSERY SONGS",
                    "LOOLOO KIDS",
            };
            String[] downloadUrl = {
                    "https://n0render.com/N0Launcher/Kodi/EKids_Media_1.apk",
                    null,
                    null,
                    "https://n0render.com/N0Launcher/IXL_7.0.0_Apkpure.apk",
                    null,
                    null,
            };
            int[] icon = {
                    R.drawable.kids_ic_umn_kids,
                    R.drawable.kids_ic_youtube_kids,
                    R.drawable.kids_ic_e_learning,
                    R.drawable.kids_ic_umn_ixl,
                    R.drawable.kids_ic_kids_nursery,
                    R.drawable.kids_ic_kids_looloo_kids,
            };
            String[] packageName = {
                    "tv.lets.kids",
                    "com.google.android.youtube.tvkids",
                    null,
                    "com.ixl.ixlmath",
                    "net.colorcity.kidsy",
                    "net.colorcity.loolookids",
            };

            int[] bg = {
                    R.drawable.kids_ic_umn_kids_bggg,
                    R.drawable.kids_ic_umn_kids_bggg,
                    R.drawable.kids_ic_umn_kids_bggg,
                    R.drawable.kids_ic_umn_kids_bggg,
                    R.drawable.kids_ic_umn_kids_bggg,
                    R.drawable.kids_ic_umn_kids_bggg
            };

            for (int index = 0; index < title.length; ++index) {
                KidsCard k = new KidsCard();
                k.setTitle(title[index]);
                k.setDownloadUrl(downloadUrl[index]);
                k.setPackageName(packageName[index]);
                k.setIconStringUri(ResourceHelpers.toStringUri(icon[index]));
                k.setBackgroundStringUri(ResourceHelpers.toStringUri(bg[index]));
                kids.add(k);
            }
        }
        return kids;
    }
}
