package com.umntv.launcher.main.row.radio_workout;

import com.umntv.launcher.util.ResourceHelpers;

import net.n0ender.com.R;

import java.util.ArrayList;
import java.util.List;

public final class Radio {

    public final static String FIT_WORKOUT = "FIT WORKOUT";
    public final static String TUNE_IN = "TUNE IN";
    public final static String VLC_PLAYER = "VLC PLAYER";
    public final static String FITON = "FITON";
    public final static String SPOTIFY = "SPOTIFY";

    private static final List<RadioCard> radio = new ArrayList<>();

    public static List<RadioCard> setup() {
        if (radio.isEmpty()) {
            String[] title = {
                    "RADIO.NET",
                    "PELOTON",
                    "iHEART RADIO",
                    FIT_WORKOUT,
                    FITON,
                    SPOTIFY,
                    TUNE_IN,
                    "HOME WORKOUT",
                    "AMAZON MUSIC",
                    "UNDERBELLY APP",
//                    VLC_PLAYER,
            };
            String[] apkLinkDownloadApk = {
//                    "https://n0render.com/N0Launcher/Radio-Workout/de.radio.android_tv.apk",
//                    "https://n0render.com/N0Launcher/Radio-Workout/fiton.android_1.3.8.com.apk",
//                    "https://n0render.com/N0Launcher/Radio-Workout/pandora.android.apk",
//                    null,
//                    "https://n0render.com/N0Launcher/Radio-Workout/radioline_3.0.0.apk",
//                    "https://n0render.com/N0Launcher/Radio-Workout/vlc_1.7.5.apk"

                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
//                    null,
            };

            String[] packageName = {
                    "de.radio.android",
                    "com.onepeloton.callisto",
                    "com.clearchannel.iheartradio.tv",
                    "com.joyer.tv.fitness",
                    "com.fiton.android",
                    "com.spotify.tv.android",
                    "tunein.player",
                    "com.sugarapple.workout",
                    "com.amazon.music.tv",
                    "com.theunderbelly",
//                    "org.videolan.vlc"
            };

            String[] youtubeId = {
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
//                    null
            };

            String[] description = {
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    "",
                    null,
                    "",
//                    "",
            };

            String[] link = {
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    "https://www.youtube.com/embed/j3AhWUx7IqA?list=PLjk8Jdc9PVxuqIzqiST9h1bZQtLcJQFV3 https://www.youtube.com/embed/ehCBXmvSxhs?list=PLrteebjlQmI9eyxcVAVtiM3Ue43dUBpxt https://www.youtube.com/embed/bEKUOx_owFk?list=PLHKAN8O8G3sc8K9XdSTzh6QRISFgUvE8_ https://www.youtube.com/embed/VeRGx1lDWBI?list=PL3Gd7XKQifYdEiUvgmjLyeZZ1dzUyKqN8",
                    "https://www.youtube.com/embed/Zp2g1MFWqJk?app=desktop&feature=emb_imp_woyt&list=PLG-JAis-cw0IU_-GHrJ0Q7CPsU1oGNg3_ https://www.youtube.com/embed/ukdZ4DTALBo?app=desktop&feature=emb_imp_woyt&list=PL0651CF9C8154D178 https://www.youtube.com/embed/960HaJ4J0kk?app=desktop&feature=emb_imp_woyt&list=PLJ6dsbVCaLPhtQ3e3-OHl_sW20JLhkRL1 https://www.youtube.com/embed/b2s5FYpH_y4?app=desktop&feature=emb_imp_woyt&list=PLAGiZc-0D7Jm_9PwXU9bCtGLPWORNsQtL",
                    null,
                    "https://www.youtube.com/embed/PunLBJwAiX0?list=PLXR4R2rvC8Z5i9SURXbjVMV6icSVUWk2w https://www.youtube.com/embed/Ds7sDGAPl5I?list=PLispDnzIMNq70c3k6xAAuEjdzA6ENJMbf https://www.youtube.com/embed/3rT8gyV5RX0?list=PLdZzClTcgSlU_YzWu99YJPPqcEMEpIKBw https://www.youtube.com/embed/wqJsZYibWcI?list=PLeQlgf5H84mfXRDGtaFiGOOef-szLM7Ov",
//                    null,
            };

            String[] cardImageUrl = {
                    ResourceHelpers.toStringUri(R.drawable.radio_ic_umn_radio),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_peloton),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_i_heart),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_trap_beats),
                    ResourceHelpers.toStringUri(R.drawable.ic_radio_karaoke),
                    ResourceHelpers.toStringUri(R.drawable.spotity),
                    ResourceHelpers.toStringUri(R.drawable.tune_in),
                    ResourceHelpers.toStringUri(R.drawable.home_workout),
                    ResourceHelpers.toStringUri(R.drawable.amazon_music),
                    ResourceHelpers.toStringUri(R.drawable.underbily_app),
//                    ResourceHelpers.toStringUri(R.drawable.ic_radio_thai),
            };

            for (int index = 0; index < title.length; ++index) {
                radio.add(
                        buildRadioInfo(
                                youtubeId[index],
                                packageName[index],
                                apkLinkDownloadApk[index],
                                title[index],
                                description[index],
                                link[index],
                                cardImageUrl[index]
//                                detailImageUrl[index]
                        )
                );
            }
        }
        return radio;
    }

    private static RadioCard buildRadioInfo(
            String youtubeId,
            String packageName,
            String linkDownloadApk,
            String title,
            String description,
            String link,
            String cardImageUrl
    ) {
        RadioCard r = new RadioCard();
        r.setYoutubeId(youtubeId);
        r.setPackageName(packageName);
        r.setLinkApkDownload(linkDownloadApk);
        r.setTitle(title);
        r.setDetailDescription(description);
        r.setIconStringUri(cardImageUrl);
        r.setBackgroundStringUri(ResourceHelpers.toStringUri(R.drawable.radio_bg_umn_radio));
        r.setLink(link);
        return r;
    }
}