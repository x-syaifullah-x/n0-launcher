package com.umntv.launcher.util;

import android.content.Context;
import android.view.View;

import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

import net.n0ender.com.R;

public class Admob {

    public static void setup(View view) {
        try {
            if (view instanceof AdView adView) {
//                                MobileAds.initialize(adView.getContext(), initializationStatus -> {});
                adView.bringToFront();
                AdRequest adRequest = new AdRequest.Builder().build();
                adView.loadAd(adRequest);
            } else if (view instanceof MaxAdView adView) {
                Context context = adView.getContext();
                AppLovinSdk.getInstance(context).setMediationProvider("max");
//                AppLovinSdkSettings settings = new AppLovinSdkSettings(context);
//                List<String> adUnitIds = new ArrayList<>();
//                settings.setInitializationAdUnitIds(adUnitIds);
//                AppLovinSdk.getInstance(settings, context).setMediationProvider("max");
                adView.bringToFront();
                adView.loadAd();
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
