package com.umntv.launcher.main.row.support.detail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.umntv.launcher.main.row.support.Ads;
import com.umntv.launcher.main.row.support.AdsCard;
import com.umntv.launcher.main.row.support.detail.global_girl_net.GlobalGirlNetFragment;
import com.umntv.launcher.main.row.support.detail.support.SupportFragment;

import net.n0ender.com.R;

import java.io.Serializable;

public class AdsDetailsActivity extends FragmentActivity {

    public static final String ITEM = "Item";
    public static final String SHARED_ELEMENT_NAME = "hero";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Serializable s = getIntent().getSerializableExtra(AdsDetailsActivity.ITEM);
            if (s instanceof AdsCard a) {
                if (a.getTitle().equals(Ads.VENDORS_SUPPORT)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_browse_fragment, new SupportFragment())
                            .commitNow();
                } else if (a.getTitle().equals(Ads.GLOBAL_GIRLS_NET)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_browse_fragment, new GlobalGirlNetFragment())
                            .commitNow();
                } else {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_browse_fragment, new AdsDetailsFragment())
                            .commitNow();
                }
            }
        }
    }
}
