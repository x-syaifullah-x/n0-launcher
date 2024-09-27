package com.umntv.launcher.main.row.asian_media;

import androidx.annotation.Nullable;

import com.umntv.launcher.base.CardApp;
import com.umntv.launcher.base.CardVisitor;

public class AsianMediaCard extends CardApp {

    private String linkApkDownload;

    @Nullable
    public String getLinkApkDownload() {
        return linkApkDownload;
    }

    public void setLinkApkDownload(String linkApkDownload) {
        this.linkApkDownload = linkApkDownload;
    }

    @Override
    public void onClicked(CardVisitor visitor) {
        visitor.click(this);
    }
}
