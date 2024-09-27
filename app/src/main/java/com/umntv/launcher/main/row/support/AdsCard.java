package com.umntv.launcher.main.row.support;

import com.umntv.launcher.base.Card;
import com.umntv.launcher.base.CardVisitor;

public class AdsCard extends Card {

    private String[] site;

    private String subtitle;

    private String icDetailsStringUri;

    private String bgDetailsStringUri;

    public String[] getSite() {
        return site;
    }

    public void setSite(String[] site) {
        this.site = site;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getIcDetailsStringUri() {
        return icDetailsStringUri;
    }

    public void setIcDetailsStringUri(String icDetailsStringUri) {
        this.icDetailsStringUri = icDetailsStringUri;
    }

    public String getBgDetailsStringUri() {
        return bgDetailsStringUri;
    }

    public void setBgDetailsStringUri(String bgDetailsStringUri) {
        this.bgDetailsStringUri = bgDetailsStringUri;
    }

    @Override
    public void onClicked(CardVisitor visitor) {
        visitor.click(this);
    }

    private String detailDescription;

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }
}
