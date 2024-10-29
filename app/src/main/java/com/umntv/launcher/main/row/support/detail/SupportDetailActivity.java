package com.umntv.launcher.main.row.support.detail;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.umntv.launcher.main.row.support.Support;
import com.umntv.launcher.main.row.support.SupportCard;
import com.umntv.launcher.main.row.support.detail.global_girl_net.GlobalGirlNetFragment;
import com.umntv.launcher.main.row.support.detail.leeway.LeewayFragment;
import com.umntv.launcher.main.row.support.detail.platinum_staffing.PlatinumStaffingFragment;
import com.umntv.launcher.main.row.support.detail.support.SupportFragment;
import com.umntv.launcher.main.row.support.detail.the_dale_studios.TheDaleStudiosFragment;

import net.n0ender.com.R;

import java.io.Serializable;

public class SupportDetailActivity extends FragmentActivity {

    public static final String ITEM = "Item";
    public static final String SHARED_ELEMENT_NAME = "hero";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Serializable s = getIntent().getSerializableExtra(SupportDetailActivity.ITEM);
            if (s instanceof SupportCard a) {
                if (a.getTitle().equals(Support.VENDORS_SUPPORT)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_browse_fragment, new SupportFragment())
                            .commitNow();
                } else if (a.getTitle().equals(Support.GLOBAL_GIRLS_NET)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_browse_fragment, new GlobalGirlNetFragment())
                            .commitNow();
                } else if (a.getTitle().equals(Support.PLATINUM_STAFFING)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_browse_fragment, new PlatinumStaffingFragment())
                            .commitNow();
                } else if (a.getTitle().equals(Support.THE_DALE_STUDIOS)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_browse_fragment, new TheDaleStudiosFragment())
                            .commitNow();
                } else if (a.getTitle().equals(Support.TITLE_LEEWAY_ENDEAVORS)) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_browse_fragment, new LeewayFragment())
                            .commitNow();
                }
            }
        }
    }
}
