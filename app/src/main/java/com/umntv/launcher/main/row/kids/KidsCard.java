package com.umntv.launcher.main.row.kids;

import com.umntv.launcher.base.Card;
import com.umntv.launcher.base.CardVisitor;

import java.io.Serializable;

public class KidsCard extends Card {

    private String packageName;
    private String downloadUrl;

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public void onClicked(CardVisitor visitor) {
        visitor.click(this);
    }
}
