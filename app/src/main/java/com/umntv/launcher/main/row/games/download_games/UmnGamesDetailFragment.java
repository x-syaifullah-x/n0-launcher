package com.umntv.launcher.main.row.games.download_games;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.main.base.OverviewItem;
import com.umntv.launcher.util.Admob;

import net.n0ender.com.R;

public class UmnGamesDetailFragment extends BaseDetailFragment {
    public UmnGamesDetailFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));
    }

    @Override
    protected void onActionClickListener(OverviewItem overviewItem) {
        ApkData apkData = overviewItem.apkData;
        Uri a = Uri.parse(apkData.url);
        Uri u = new Uri.Builder()
                .scheme("n0render")
                .authority(a.getAuthority())
                .path(a.getPath())
                .build();
        Intent launchIntent = new Intent(Intent.ACTION_VIEW, u);
        launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            requireContext().startActivity(launchIntent);
        } catch (Throwable e) {
            ApkData aaa = new ApkData(
                    com.umntv.launcher.main.row.n0_render.detail.download_center.DataSource.URL_GAME_BROWSER,
                    apkData.packageName,
                    false
            );
            openOrDownload(aaa);
        }
    }
}
