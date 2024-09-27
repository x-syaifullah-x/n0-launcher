package com.umntv.launcher.main.row.kids.details.e_lerning;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

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
        try {
            Intent launchIntent = requireActivity().getPackageManager().getLaunchIntentForPackage("com.umn.n0.browser");
            if (launchIntent == null) return;
            launchIntent.setData(Uri.parse(apkData.url));
//            intent.setPackage("com.jio.web.androidtv");
            startActivity(launchIntent);
        } catch (Throwable t) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            String uriString = apkData.url;
            intent.setData(Uri.parse(uriString));
            startActivity(intent);
        }
    }
}