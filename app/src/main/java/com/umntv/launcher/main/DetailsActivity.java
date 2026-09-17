package com.umntv.launcher.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.applovin.mediation.ads.MaxAdView;
import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class DetailsActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        MaxAdView v = findViewById(R.id.adView_detail);
        Admob.setup(v);

        if (savedInstanceState == null) {

//            try {
//                String fragmentClassName = getIntent().getAction();
//                @SuppressWarnings("unchecked")
//                Class<Fragment> fragmentClass = (Class<Fragment>) Class.forName(fragmentClassName);
//                if (fragmentClassName.isEmpty()) {
//                    throw new Error("Please set action in intent");
//                }
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.main_browse_fragment, fragmentClass, null, null)
//                        .commit();
//            } catch (Throwable t) {
//                t.printStackTrace();
//                finishAfterTransition();
//            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        View v = findViewById(R.id.adView_detail);
        if (v instanceof MaxAdView) {
            ((MaxAdView) v).destroy();
        }
    }
}