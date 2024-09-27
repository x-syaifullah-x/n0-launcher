package com.umntv.launcher.main.row.apps.app_drawer.error;

import android.os.Bundle;
import android.util.Log;

import androidx.core.content.ContextCompat;

import net.n0ender.com.R;

/*
 * This class demonstrates how to extend ErrorFragment
 */
public class ErrorFragment extends androidx.leanback.app.ErrorSupportFragment {
    private static final String TAG = "ErrorFragment";
    private static final boolean TRANSLUCENT = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.app_name));
    }

    void setErrorContent() {
        setImageDrawable(ContextCompat.getDrawable(requireActivity(), androidx.leanback.R.drawable.lb_ic_sad_cloud));
        setMessage(getResources().getString(R.string.error_fragment_message));
        setDefaultBackground(TRANSLUCENT);

        setButtonText(getResources().getString(R.string.dismiss_error));
        setButtonClickListener(
                arg0 -> requireActivity().getSupportFragmentManager().
                        beginTransaction().remove(ErrorFragment.this).commit());
    }
}