package com.umntv.launcher.main.row.tools;

import androidx.annotation.Nullable;

import com.umntv.launcher.base.Card;
import com.umntv.launcher.base.CardVisitor;

public class ToolsCard extends Card {

    @Nullable
    private String packageName;

    @Nullable
    private String apkUrl;

    @Nullable
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(@Nullable String packageName) {
        this.packageName = packageName;
    }

    @Nullable
    public String getApkUrl() {
        return apkUrl;
    }

    public void setApkUrl(@Nullable String apkUrl) {
        this.apkUrl = apkUrl;
    }

    @Override
    public void onClicked(CardVisitor visitor) {
        visitor.click(this);
    }
}
