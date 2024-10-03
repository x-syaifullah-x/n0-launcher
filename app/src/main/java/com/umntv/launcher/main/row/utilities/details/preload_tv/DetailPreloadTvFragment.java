package com.umntv.launcher.main.row.utilities.details.preload_tv;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.main.base.OverviewItem;
import com.umntv.launcher.util.Admob;
import com.umntv.launcher.util.view.dialog.DialogEnterCode;
import com.umntv.launcher.util.view.dialog.DialogPassword;
import com.umntv.launcher.util.view.dialog.Download;

import net.n0ender.com.R;

public class DetailPreloadTvFragment extends BaseDetailFragment {

    public DetailPreloadTvFragment() {
        super(DataSource.items);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Admob.setup(requireActivity().findViewById(R.id.adView));
    }

    @Override
    protected void onActionClickListener(OverviewItem overviewItem) {
        if (overviewItem.apkData.isPrivate) {
            if (overviewItem == DataSource.SELF_LOAD) {
                new DialogPassword(requireContext(), "N02025")
                        .setInputPasswordHint("Please enter the password to access " + overviewItem.titleAction)
                        .setOnConfirmListener(() -> openOrDownload(overviewItem.apkData))
                        .show();
                return;
            }
            new DialogPassword(requireContext(), "_+N0")
                    .setInputPasswordHint("Please enter the password to access " + overviewItem.titleAction)
                    .setOnConfirmListener(() -> openOrDownload(overviewItem.apkData))
                    .show();
        }
    }

    @Override
    protected void openOrDownload(ApkData apkData) {
        if (apkData.url.equalsIgnoreCase(DataSource.URL_SELF_LOAD)) {
            new DialogEnterCode(requireContext())
                    .setOnConfirmListener(code -> {
                        download(apkData.url + "/" + code + ".tmb");
                    }).show();
            return;
        }

        if (apkData.url.equalsIgnoreCase(DataSource.URL_CODE_REQUEST)) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(apkData.url));
            startActivity(i);
            return;
        }

        download(apkData.url);
    }

    private void download(String link) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Download.toPublicDirectoryDownload(requireContext(), link);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                int checkSelfPermission = ActivityCompat.checkSelfPermission(
                        requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE
                );
                boolean isGranted = checkSelfPermission == PackageManager.PERMISSION_GRANTED;

                if (isGranted) {
                    Download.toPublicDirectoryDownload(requireContext(), link);
                } else {
                    this.link = link;
                    requestPermission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }
            } else {
                Download.toPublicDirectoryDownload(requireContext(), link);
            }
        }
    }

    private String link = null;

    ActivityResultLauncher<String> requestPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), result -> {
        if (result) {
            Download.toPublicDirectoryDownload(requireContext(), link);
        } else {
            /*  */
        }
    });
}
