package com.umntv.launcher.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.sdk.AppLovinSdk;
import com.umntv.launcher.util.Admob;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.n0ender.com.BuildConfig;
import net.n0ender.com.R;

import com.applovin.mediation.ads.MaxAdView;

public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG) {
            deleteCache(this);
        }

        setContentView(R.layout.activity_main);

//        MaxAdView adView = new MaxAdView(getString(R.string.applovin_ad_unit_id_type_banner), this);
//        AppLovinSdk.getInstance(adView.getContext()).setMediationProvider("max");
//
////        adView.setListener(this);
////        adView.setRevenueListener(this);
//
//        // Set the height of the banner ad based on the device type.
////        final boolean isTablet = AppLovinSdkUtils.isTablet(this);
////        final int heightPx = AppLovinSdkUtils.dpToPx(this, isTablet ? 90 : 50);
//        // Banner width must match the screen to be fully functional.
//        adView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 90));
//
//        // Need to set the background or background color for banners to be fully functional.
//        adView.setBackgroundColor(Color.BLACK);
//
//        final ViewGroup rootView = (ViewGroup) findViewById(android.R.id.content);
//        rootView.addView(adView);

        // Load the first ad.
//        adView.loadAd();


        MaxAdView v = findViewById(R.id.adView);
        Admob.setup(v);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_browse_fragment, new MainFragment())
                .commitNow();

//        if (savedInstanceState == null) {
//            MaxAdView v = findViewById(R.id.adView);
////            v.loadAd();
//            Admob.setup(v);
//
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.main_browse_fragment, new MainFragment())
//                    .commitNow();
//        }

//        JSONObject consentObject = new JSONObject();
//        try {
//            // Provide correct consent value to sdk which is obtained by User
//            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, true);
//            // Provide 0 if GDPR is not applicable and 1 if applicable
//            consentObject.put("gdpr", "0");
//            // Provide user consent in IAB format
////            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_IAB, “ << consent in IAB format >> ”);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        InMobiSdk.init(this, "e0fb22098ee14a6aaa803ecb84bc77e1", consentObject, new SdkInitializationListener() {
//            @Override
//            public void onInitializationComplete(@Nullable @org.jetbrains.annotations.Nullable Error error) {
//                if (error != null) {
//                    error.printStackTrace();
//                } else {
//                    InMobiSdk.setLogLevel(InMobiSdk.LogLevel.DEBUG);
//                    InterstitialAdEventListener mInterstitialAdEventListener = new InterstitialAdEventListener() {
//                        @Override
//                        public void onAdLoadSucceeded(@NonNull InMobiInterstitial inMobiInterstitial, @NonNull AdMetaInfo info) {
//                            Log.d("TAG", "Ad can now be shown!");
//                            inMobiInterstitial.show();
//                        }
//
//                        @Override
//                        public void onAdLoadFailed(@NonNull InMobiInterstitial inMobiInterstitial, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
//                            super.onAdLoadFailed(inMobiInterstitial, inMobiAdRequestStatus);
//                            Log.d("TAG", "Ad can now be shown!");
//                        }
//                    };
//
//                    InMobiInterstitial interstitialAd = new InMobiInterstitial(
//                            MainActivity.this,
//                            1680826218142L,
//                            mInterstitialAdEventListener
//                    );
//                }
//            }
//        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        View v = findViewById(R.id.adView);

        if (v instanceof MaxAdView) {
            ((MaxAdView) v).destroy();
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager()
                .findFragmentById(R.id.main_browse_fragment); // ganti dengan id container fragment kamu

        if (currentFragment instanceof MainFragment) {
            // di FragmentA, back ditahan (tidak melakukan apa-apa)
            // atau bisa tambahkan logic lain, misal double-tap to exit
        } else {
            // fragment lain, back tetap jalan normal
            super.onBackPressed();
        }
    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            if (children != null) {
                for (String child : children) {
                    boolean success = deleteDir(new File(dir, child));
                    if (!success) {
                        return false;
                    }
                }
            }
            return dir.delete();
        } else if (dir != null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }
}