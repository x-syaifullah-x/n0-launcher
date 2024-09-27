package com.umntv.launcher.main.row.asian_media.detail.jade_cinema;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.umntv.launcher.constant.PackageName;
import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class DetailFragment extends BaseDetailFragment {
    public DetailFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));
    }

    @Override
    public void openOrDownload(ApkData apkData) {
        if (apkData.packageName.contains(PackageName.N0_BROWSER)) {
            String[] a = apkData.packageName.split(",");
            String packageName = a[0];
            String data = a[1];
            Intent launchIntent = requireActivity().getPackageManager().getLaunchIntentForPackage(packageName);
            if (launchIntent == null) {
                launchIntent = requireActivity().getPackageManager().getLeanbackLaunchIntentForPackage(packageName);
            }
            if (launchIntent != null) {
                launchIntent.setData(Uri.parse(data));
                startActivity(launchIntent);
            } else {
                super.openOrDownload(apkData);
            }
            return;
        }

        if (apkData.url.isEmpty() || apkData.packageName.isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            try {
                intent.setData(Uri.parse(apkData.url));
                intent.setPackage("com.jio.web.androidtv");
                startActivity(intent);
            } catch (Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                String uriString = apkData.url;
                intent.setData(Uri.parse(uriString));
                startActivity(intent);
            }
        } else {
            super.openOrDownload(apkData);
        }
    }
}