package com.umntv.launcher.main.row.apps;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import net.n0ender.com.R;

public class AppsActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_app_drawer);

        String action = getIntent().getAction();

        if (savedInstanceState == null) {
            try {
                Class<?> aClass = Class.forName(action);
                //noinspection unchecked
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.app_drawer_fragment, ((Class<? extends Fragment>) aClass).newInstance())
                        .commitNow();
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
}
