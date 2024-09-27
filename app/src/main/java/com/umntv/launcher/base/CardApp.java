package com.umntv.launcher.base;

import androidx.annotation.Nullable;

public abstract class CardApp extends Card {

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
}
