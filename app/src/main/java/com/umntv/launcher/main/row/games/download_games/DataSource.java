package com.umntv.launcher.main.row.games.download_games;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import net.n0ender.com.R;

public class DataSource {

    private static final OverviewItem UMN_PS_1 = new OverviewItem(
            R.drawable.ic_games_umn_games_ps1_ic,
            R.drawable.ic_games_umn_games_ps1_bg,
            "PLAYSTATION",
            "WELCOME TO PLAYSTATION",
            OverviewItem.SUBTITLE_DEFAULT,
            "PLAYSTATION offers unlimited online game-playing of the original Sony PlayStation.<br/>" +
                    "SD cards or memory sticks are recommended for game storage.<br/>See Instructors for more information.<br/><br/><font color='black'>NOTE: YOU WILL NEED TO DOWNLOAD THE PS1 BIOS FILE BEFORE PLAYING</font>",
            new ApkData(
                    "https://n0render.com/ps1/",
                    "com.umn.n0.render",
                    false
            )
    );

    private static final OverviewItem UMN_PSP = new OverviewItem(
            R.drawable.ic_retro_umn_games_umn_psp_bg,
            R.drawable.ic_games_umn_games_ps1_bg,
            "SONY PSP",
            "WELCOME TO SONY PSP",
            OverviewItem.SUBTITLE_DEFAULT,
            "SONY PSP offers unlimited online game-playing of the original Sony PlayStation Portable.<br/>" +
                    "SD cards or memory sticks are recommended for game storage.<br/>" +
                    "See Instructors for more information.<br/><br/><font color='black'>NOTE: SOME GAMES USERS WILL NEED TO ADJUST FAME SKIPPING</font>",
            new ApkData(
                    "https://n0render.com/psp/",
                    "com.umn.n0.render",
                    false
            )
    );

    private static final OverviewItem UMN_N64 = new OverviewItem(
            R.drawable.ic_games_umn_games_n64,
            R.drawable.ic_games_umn_games_n64_bg,
            "NINTENDO 64",
            "WELCOME TO NINTENDO 64",
            OverviewItem.SUBTITLE_DEFAULT,
            "NINTENDO 64 offers game-playing on the Nintendo 64.\n" +
                    "SD cards or memory sticks are recommended for game storage.\nSee Instructors for more information.",
            new ApkData(
                    "https://n0render.com/n64/",
                    "com.umn.n0.render",
                    false
            )
    );

    private static final OverviewItem INSTRUCTIONS = new OverviewItem(
            R.drawable.ic_umn_retro_umn_retro_ins,
            R.drawable.ic_umn_retro_umn_retro_ins_bg,
            "INSTRUCTIONS",
            "WELCOME TO INSTRUCTIONS",
            OverviewItem.SUBTITLE_DEFAULT,
            "",
            new ApkData(
                    "https://n0render.com/inst",
                    "com.umn.n0.render",
                    false
            )
    );

    public static final List<OverviewItem> items = List.of(
            UMN_PS_1,
            UMN_PSP,
            UMN_N64,
            INSTRUCTIONS
    );
}
