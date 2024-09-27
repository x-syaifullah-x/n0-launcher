package com.umntv.launcher.main.row.n0_render;

import androidx.annotation.Nullable;

import com.umntv.launcher.base.CardAppAndLink;
import com.umntv.launcher.base.CardVisitor;

public class UmnTvCard extends CardAppAndLink {

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
