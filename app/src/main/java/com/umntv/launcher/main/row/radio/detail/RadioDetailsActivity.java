package com.umntv.launcher.main.row.radio.detail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class RadioDetailsActivity extends FragmentActivity {

    public static final String ITEM = "Item";
    public static final String SHARED_ELEMENT_NAME = "hero";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Admob.setup(findViewById(R.id.adView));
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new RadioDetailsFragment())
                    .commitNow();
        }
    }
}
