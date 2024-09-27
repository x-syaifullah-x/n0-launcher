package com.umntv.launcher.main.row.n0_render.network;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class NetworkDetailFragment extends BaseDetailFragment {

    public NetworkDetailFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Admob.setup(requireActivity().findViewById(R.id.adView));
    }

    @Override
    public void openOrDownload(ApkData apkData) {
        if (apkData.packageName == null || apkData.packageName.isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.parse(apkData.url);
            try {
                intent.setData(uri);
                intent.setPackage("com.jio.web.androidtv");
                startActivity(intent);
            } catch (ActivityNotFoundException t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        } else {
            super.openOrDownload(apkData);
        }
    }
}
