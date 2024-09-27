package com.umntv.launcher.main.row.utilities.details.remote_support;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.DetailsSupportFragmentBackgroundController;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;

import net.n0ender.com.R;

import com.umntv.launcher.main.base.ApkData;
import com.umntv.launcher.main.base.BaseDetailFragment;
import com.umntv.launcher.main.base.OverviewItem;
import com.umntv.launcher.util.Admob;
import com.umntv.launcher.util.AndroidStore;
import com.umntv.launcher.util.view.dialog.ApkUtil;
import com.umntv.launcher.util.view.dialog.DialogEnterCode;
import com.umntv.launcher.util.view.dialog.DialogPassword;
import com.umntv.launcher.util.view.dialog.Download;

import java.util.List;

public class DetailRemoteSupportTvFragment extends BaseDetailFragment {

    public DetailRemoteSupportTvFragment() {
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
            new DialogPassword(requireContext(), "_+N0")
                    .setInputPasswordHint("Please enter the password to access " + overviewItem.titleAction)
                    .setOnConfirmListener(() -> openOrDownload(overviewItem.apkData))
                    .show();
            return;
        }
        boolean isApkUpload = overviewItem.titleAction.equalsIgnoreCase(DataSource.APK_UPLOAD.titleAction);
        if (isApkUpload) {
            new DialogEnterCode(requireContext(), "Download And Install")
                    .setOnConfirmListener(code -> {
                        String link = "https://n0render.com/N0Launcher/apkinstaller/" + code + ".apk";
                        ApkUtil.downloadToCacheDirAndInstall(requireContext(), link);
                    }).show();
            return;
        }
        super.onActionClickListener(overviewItem);
    }

    @Override
    protected void openOrDownload(ApkData apkData) {
        boolean isApk = apkData.packageName != null;
        if (isApk) {
            super.openOrDownload(apkData);
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            Download.toPublicDirectoryDownload(requireContext(), apkData.url);
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int checkSelfPermission = ActivityCompat.checkSelfPermission(
                    requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE
            );
            boolean isGranted = checkSelfPermission == PackageManager.PERMISSION_GRANTED;

            if (isGranted) {
                Download.toPublicDirectoryDownload(requireContext(), apkData.url);
            } else {
                this.link = apkData.url;
                requestPermission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
            return;
        }

        Download.toPublicDirectoryDownload(requireContext(), apkData.url);
    }

    String link = null;

    ActivityResultLauncher<String> requestPermission = registerForActivityResult(new ActivityResultContracts.RequestPermission(), result -> {
        if (result) {
            Download.toPublicDirectoryDownload(requireContext(), link);
        } else {
            /*  */
        }
    });
}
