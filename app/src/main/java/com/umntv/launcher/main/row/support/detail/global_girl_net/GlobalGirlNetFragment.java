package com.umntv.launcher.main.row.support.detail.global_girl_net;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.umntv.launcher.constant.PackageName;
import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class GlobalGirlNetFragment extends BaseDetailFragment {

    public GlobalGirlNetFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));
    }

    @Override
    protected void openOrDownload(ApkData apkData) {
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
        try {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(apkData.url));
            requireContext().startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getContext(), "No application can handle this request." + " Please install a webbrowser", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}