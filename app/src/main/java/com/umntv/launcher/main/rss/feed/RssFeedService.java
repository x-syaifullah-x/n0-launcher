package com.umntv.launcher.main.rss.feed;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.WorkerThread;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;

public class RssFeedService {

    private final Handler handler = new Handler(Looper.getMainLooper());

    private final String url;

    private HttpsURLConnection connection = null;

    public RssFeedService(String UrlRssFeed) {
        this.url = "https://api.rss2json.com/v1/api.json?rss_url=" + UrlRssFeed;
    }

    public void openConnection(RssFeedResult result) {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                if (connection != null)
                    connection.disconnect();
                final URL URL = new URL(url);
                connection = (HttpsURLConnection) URL.openConnection();
                if (connection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                    JSONObject j = asJSONObject(connection.getInputStream());
                    handler.post(() -> result.success(j));
                } else {
                    JSONObject jsonObject = asJSONObject(connection.getErrorStream());
                    String message = jsonObject.getString("message");
                    throw new Exception(message);
                }
            } catch (Throwable err) {
                handler.post(() -> result.error(err));
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        });
    }

    @WorkerThread
    private JSONObject asJSONObject(InputStream is) throws JSONException {
        byte[] data = new byte[1024];
        long currentSize = 0;
        int count;

        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        StringBuilder sb = new StringBuilder();
        try {
            while ((count = is.read(data)) != -1) {
                currentSize += count;
                buf.write(data);
            }
            sb.append(buf);
            buf.close();
        } catch (IOException err) {
            err.printStackTrace();
        }
        return new JSONObject(sb.toString());
    }
}
