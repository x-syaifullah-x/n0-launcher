package com.umntv.launcher.main.row.kids;

import net.n0ender.com.R;

import com.umntv.launcher.util.ResourceHelpers;

import java.util.ArrayList;
import java.util.List;

public class Kids {

    public static final String TITLE_E_LEARNING = "E-LEARNING";

    private static final List<KidsCard> kids = new ArrayList<>();

    public static List<KidsCard> setup() {
        if (kids.isEmpty()) {
            String[] downloadUrl = {
                    "https://n0render.com/N0Launcher/Kodi/EKids_Media_1.apk",
                    null,
                    "https://n0render.com/N0Launcher/IXL_7.0.0_Apkpure.apk",
                    null
            };
            String[] title = {
                    "E-KIDS MEDIA",
                    TITLE_E_LEARNING,
                    "IXL",
                    "KIDS NURSERY SONGS"
            };
            int[] icon = {
                    R.drawable.kids_ic_umn_kids,
                    R.drawable.kids_ic_e_learning,
                    R.drawable.kids_ic_umn_ixl,
                    R.drawable.kids_ic_kids_nursery
            };
            String[] packageName = {
                    "tv.lets.kids",
                    null,
                    "com.ixl.ixlmath",
                    "net.colorcity.kidsy",
            };

            int[] bg = {
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
