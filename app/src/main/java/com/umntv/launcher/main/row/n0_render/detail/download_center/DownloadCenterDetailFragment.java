package com.umntv.launcher.main.row.n0_render.detail.download_center;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class DownloadCenterDetailFragment extends BaseDetailFragment {
    public DownloadCenterDetailFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));
    }

    @Override
    protected void openOrDownload(ApkData apkData) {
        if (apkData.url.contains("https://n0render.com/dc")) {
            Uri uri = Uri.parse(apkData.url);
            Intent i = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(i);
        } else {
            super.openOrDownload(apkData);
        }
    }

    //    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        RssView.show(requireView());
//    }
}
