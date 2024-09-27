package com.umntv.launcher.main.row.games.retro_center;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.OverviewItem;

import java.util.List;

import net.n0ender.com.R;

public class DataSource {

    private static final String SUB_TITLE_UMN_RETRO = "Datadogs Communication | Muhammad Usama Nazir | RetroArch";
    private static final String BODY_UMN_RETRO = "N0Render Retro Center is a RetroArch bass platform that allows users to play retro video games in their original formats.This application is still in beta.Please see the instructions for a smoother experience.<br/>RETRO GAMES WILL NOT WORK WITH KEYBOARD OR REMOTE.<br/>PLEASE ATTACH GAME CONTROLLER TO ENJOY THIS FUNCTION.";

    private static final OverviewItem UMN_RETRO = new OverviewItem(
            R.drawable.ic_umn_retro_umn_retro,
            R.drawable.ic_umn_retro_umn_retro_bg_bg,
            "RETRO CENTER",
            "WELCOME TO N0RENDER RETRO CENTER",
            SUB_TITLE_UMN_RETRO,
            BODY_UMN_RETRO,
            new ApkData(
                    "https://n0render.com/N0Launcher/RetroArch%20Plus_1.9.12.apk",
                    "com.retroarch.aarch64",
                    false
            )
    );

    private static final OverviewItem INSTRUCTIONS = new OverviewItem(
            R.drawable.ic_umn_retro_umn_retro_ins,
            R.drawable.ic_umn_retro_umn_retro_ins_bg,
            "INSTRUCTION",
            "WELCOME TO N0RENDER INSTRUCTION",
            SUB_TITLE_UMN_RETRO,
            BODY_UMN_RETRO,
            new ApkData(
                    "https://n0render.com/retrot/",
                    null,
                    false
            )
    );

    private static final OverviewItem GAME_PAD = new OverviewItem(
            R.drawable.ic_retro_umn_games_gamepad,
            R.drawable.ic_retro_umn_games_gamepad_bg,
            "GAMEPAD",
            "WELCOME TO GAMEPAD",
            OverviewItem.SUBTITLE_DEFAULT,
            "Panda Gamepad is a specifically designed keymapper for gamepad.\nSee Instructors for more information.",
            new ApkData(
                    "https://umntvdealers.net/UMNTV/Apks/KODI%2019/Panda_Gamepad.apk",
                    "com.panda.gamepad",
                    false
            )
    );

    public static final String ADB_REMOTE_COMMAND = "sh /sdcard/.chaozhuo.gameassistant2/inject.sh";

    private static final OverviewItem REMOTE_ADB = new OverviewItem(
            R.drawable.ic_retro_umn_games_remote_adb,
            R.drawable.ic_retro_umn_games_remote_adb_bg,
            "REMOTE ADB",
            "WELCOME TO REMOTE ADB",
            OverviewItem.SUBTITLE_DEFAULT,
            "Remote ADB Shell is a terminal app that allows you to connect to the ADB shell service of other Android devices over the network and execute terminal commands.\n" +
                    "PLEASE NOTE: The ADB command link will be automatically copied once the remote ADB tab is selected.\nSee Instructors for more information.",
            new ApkData(
                    ADB_REMOTE_COMMAND + "=https://umntvdealers.net/UMNTV/Apks/KODI%2019/ADBSHELL.apk",
                    "com.cgutman.androidremotedebugger",
                    false
            )
    );

    private static final String SUB_TITLE_RETRO_MODE = "Datadogs Communications | EmuELEC | LIBERELEC";
    private static final String BODY_RETRO_MODE = "N0Render Retro Mode is a EmuELEC platform that allows users to turn their devices into a super retro console.<br/>This application is still in beta. You must see instructions before engagement.<br><br>Special Thanks to: Muhammad Usama Nazir";

    public static final String PACKAGE_NAME_RETRO_MODE = "info.retromode.libreelec";

    public static final OverviewItem UMN_RETRO_MODE = new OverviewItem(
            R.drawable.ic_umn_retro_umn_retro,
            R.drawable.ic_umn_retro_umn_retro_bg_bg,
            "RETRO MODE",
            "WELCOME TO N0RENDER RETRO MODE",
            SUB_TITLE_RETRO_MODE,
            BODY_RETRO_MODE,
            new ApkData(
                    "https://n0render.com/N0Launcher/RetroMode.apk",
                    PACKAGE_NAME_RETRO_MODE,
                    true
            )
    );

    private static final OverviewItem INSTRUCTIONS_RETRO_MODE = new OverviewItem(
            R.drawable.ic_umn_retro_umn_retro_ins,
            R.drawable.ic_umn_retro_umn_retro_ins_bg,
            "R-M INSTRUCTION",
            "WELCOME TO N0RENDER R-M INSTRUCTION",
            SUB_TITLE_RETRO_MODE,
            BODY_RETRO_MODE,
            new ApkData(
                    "https://n0render.com/retro-mode",
                    null,
                    false
            )
    );
    public static final List<OverviewItem> items = List.of(
            UMN_RETRO,
            INSTRUCTIONS,
            GAME_PAD,
            REMOTE_ADB,
            UMN_RETRO_MODE,
            INSTRUCTIONS_RETRO_MODE
    );
}
