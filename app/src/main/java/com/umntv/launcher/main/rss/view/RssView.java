package com.umntv.launcher.main.rss.view;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import net.n0ender.com.R;
import com.umntv.launcher.main.rss.feed.RssFeedResult;
import com.umntv.launcher.main.rss.feed.RssFeedService;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.InvalidParameterException;
import java.util.concurrent.Executors;

public class RssView {

    public static <T extends View> void show(T viewGroup) {
        show(viewGroup, "https://media.rss.com/umn/feed.xml");
    }

    public static <T extends View> void show(T view, String URL) {
        new RssFeedService(URL)
                .openConnection(new RssFeedResult() {
                    @Override
                    protected void success(JSONObject json) {
                        show(view, json);
                    }

                    @Override
                    protected <Err extends Throwable> void error(Err err) {
                        showError(view, err.getLocalizedMessage());
                    }
                });
    }

    private static void show(View view, JSONObject jsonObject) {
        try {
            JSONObject feed = jsonObject.getJSONObject("feed");
            String title = feed.getString("title");
            String description = feed.getString("description");

            if (view instanceof ViewGroup) {
                ViewGroup vg = (ViewGroup) view;
                View rss = LayoutInflater.from(view.getContext()).inflate(R.layout.rss, vg, false);
                TextView tv = rss.findViewById(R.id.text);

                tv.setText(title);
                vg.addView(rss);
                AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(view.getContext(), R.anim.move);

                animationSet.setAnimationListener(new Animation.AnimationListener() {
                    private final String[] message = new String[]{title, description};

                    private int messageSelected = 1;

                    @Override
                    public void onAnimationStart(Animation animation) {
                        /*  */
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Executors.newSingleThreadExecutor().execute(() -> {
                            try {
                                Thread.sleep(2000);
                                tv.setText(message[messageSelected]);

                                if (messageSelected == 0) {
                                    messageSelected = 1;
                                } else if (messageSelected == 1) {
                                    messageSelected = 0;
                                }
                                new Handler(Looper.getMainLooper())
                                        .post(() -> {
                                            tv.startAnimation(animationSet);
                                        });
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        /*  */
                    }
                });
                tv.startAnimation(animationSet);
            } else {
                throw new InvalidParameterException("view must be instanceof view group");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void showError(View view, String message) {
        if (view instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) view;
            View rss = LayoutInflater.from(view.getContext()).inflate(R.layout.rss, vg, false);
            TextView tv = rss.findViewById(R.id.text);
            tv.setText(message);
            tv.setTextColor(view.getContext().getResources().getColor(android.R.color.holo_red_dark));
            vg.addView(rss);
            AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(view.getContext(), R.anim.move);
            animationSet.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    /*  */
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Executors.newSingleThreadExecutor().execute(() -> {
                        try {
                            Thread.sleep(2000);
                            tv.startAnimation(animationSet);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    /*  */
                }
            });
            tv.startAnimation(animationSet);
        } else {
            throw new InvalidParameterException("view must be instanceof view group");
        }
    }
}