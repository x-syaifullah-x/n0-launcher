package com.umntv.launcher.main.rss.feed;

import androidx.annotation.MainThread;

import org.json.JSONObject;

public abstract class RssFeedResult {

    @MainThread
    abstract protected void success(JSONObject json);

    @MainThread
    protected <Err extends Throwable> void error(Err err) {
        err.printStackTrace();
    }
}