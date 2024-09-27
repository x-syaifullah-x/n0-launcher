package com.umntv.launcher.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.applovin.mediation.ads.MaxAdView;
import com.umntv.launcher.util.Admob;

import java.io.File;

import net.n0ender.com.BuildConfig;
import net.n0ender.com.R;

public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG) {
            deleteCache(this);
        }

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            MaxAdView v = findViewById(R.id.adView);
//            v.loadAd();
            Admob.setup(v);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MainFragment())
                    .commitNow();
        }

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

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        /**/
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