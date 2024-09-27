package com.umntv.launcher.main.row.radio;

import androidx.annotation.Nullable;

import com.umntv.launcher.base.CardAppAndLink;
import com.umntv.launcher.base.CardVisitor;

public class RadioCard extends CardAppAndLink {

    private String linkApkDownload;

    private String youtubeId;

    public String getYoutubeId() {
        return youtubeId;
    }

    private String detailDescription;

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

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