package com.umntv.launcher.main.row.utilities.details;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.umntv.launcher.main.row.utilities.details.preload_tv.DetailPreloadTvFragment;
import com.umntv.launcher.main.row.utilities.details.remote_support.DetailRemoteSupportTvFragment;
import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class UtilitiesDetailsActivity extends FragmentActivity {

    public static final String DATA_EXTRA_REMOTE_SUPPORT = "DATA_EXTRA_REMOTE_SUPPORT";
    public static final String DATA_EXTRA_PRELOAD_TV = "DATA_EXTRA_PRELOAD_TV";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Admob.setup(findViewById(R.id.adView));

        if (savedInstanceState == null) {
            if (getIntent().getBooleanExtra(DATA_EXTRA_REMOTE_SUPPORT, false)) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_browse_fragment, DetailRemoteSupportTvFragment.class, null)
                        .commitNow();
            } else if (getIntent().getBooleanExtra(DATA_EXTRA_PRELOAD_TV, false)) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_browse_fragment, DetailPreloadTvFragment.class, null)
                        .commitNow();
            }
        }
    }
}
