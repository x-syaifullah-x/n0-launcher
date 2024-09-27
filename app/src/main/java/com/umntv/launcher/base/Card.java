package com.umntv.launcher.base;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public abstract class Card implements Serializable {

    private String title;
    private Drawable iconDrawable;
    private String iconStringUri;
    private String backgroundStringUri;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public String getIconStringUri() {
        return iconStringUri;
    }

    public void setIconStringUri(String iconStringUri) {
        this.iconStringUri = iconStringUri;
    }

    public String getBackgroundStringUri() {
        return backgroundStringUri;
    }

    public void setBackgroundStringUri(String backgroundStringUri) {
        this.backgroundStringUri = backgroundStringUri;
    }

    public abstract void onClicked(CardVisitor visitor);
}
