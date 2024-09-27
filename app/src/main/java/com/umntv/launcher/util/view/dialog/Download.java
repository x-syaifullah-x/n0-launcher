package com.umntv.launcher.util.view.dialog;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.provider.Settings;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import com.umntv.launcher.constant.AppBuild;
import com.umntv.launcher.util.CloseableHelper;
import com.umntv.launcher.util.MediaStorageHelper;
import com.umntv.launcher.util.ToastHelpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Download {

    private static DownloadDialog createDialog(Context context, File publicDirectory) {
        return new DownloadDialog(context, publicDirectory) {
            private ParcelFileDescriptor parcelFileDescriptor = null;

            @Override
            protected void onConnected(Header header) throws Throwable {
                super.onConnected(header);

                File destinationOutput = getDestinationOutput();

                ContentResolver cr = context.getContentResolver();

                Uri uriResult;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    String fileName = getDestinationOutput().getName();
                    Uri exist = MediaStorageHelper.exist(cr, MediaStore.Downloads.EXTERNAL_CONTENT_URI, fileName);
                    if (exist != null) {
                        boolean deleteResult = cr.delete(exist, null, null) > 0;
                    }

                    ContentValues contentValues = new ContentValues();
                    contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, destinationOutput.getName());
                    contentValues.put(MediaStore.MediaColumns.SIZE, header.getContentLength());
                    contentValues.put(MediaStore.MediaColumns.DATE_TAKEN, destinationOutput.getAbsolutePath());
                    uriResult = cr.insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, contentValues);
                } else {
                    /* REQUIRED STORAGE PERMISSION */
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                            onDownloadError(new ErrorResponse(new Error("required permission " + Manifest.permission.WRITE_EXTERNAL_STORAGE)));
                            return;
                        }
                    }
                    uriResult = FileProvider.getUriForFile(context, AppBuild.AUTHORITY, destinationOutput);
                }

                if (uriResult == null) {
                    /* REQUEST RESET MEDIA STORAGE */
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    String packageNameProviderMedia = "com.android.providers.media";
                    Uri uriProviderMedia = Uri.fromParts("package", packageNameProviderMedia, null);
                    intent.setData(uriProviderMedia);

                    getHandler().post(() ->
                            Toast.makeText(context, "Please clear data media storage and try again", Toast.LENGTH_LONG).show()
                    );
                    context.startActivity(intent);
                    disconnect();
                }

                parcelFileDescriptor = cr.openFileDescriptor(uriResult, "rw");

                setFileOutputStream(new FileOutputStream(parcelFileDescriptor.getFileDescriptor()));
            }

            @Override
            protected void onDownloadFinish() throws IOException {
                super.onDownloadFinish();
                getHandler().post(() -> ToastHelpers.showLong(context, "Downloaded successfully"));
            }

            @Override
            protected void onFinally() {
                super.onFinally();
                CloseableHelper.close(parcelFileDescriptor);
            }
        };
    }

    private static void toPublicDirectory(Context context, String link, File publicDirectory) {
        createDialog(context, publicDirectory).open(link);
    }

    public static void toInternalDirectory(Context context, String link, File dirDestination, ResultCallback resultCallback) {
        if (!dirDestination.exists()) {
            boolean isSuccess = dirDestination.mkdirs();
            if (!isSuccess) {
                throw new Error("can't make directory " + dirDestination.getAbsolutePath());
            }
        }

        DownloadDialog downloadDialog = new DownloadDialog(context, dirDestination) {

            private Uri uriOutput = null;

            @Override
            protected void onConnected(Header header) throws Throwable {
                super.onConnected(header);

                setFileOutputStream(new FileOutputStream(getDestinationOutput()));
            }

            @Override
            protected void onDownloadFinish() throws IOException {
                super.onDownloadFinish();
                uriOutput = FileProvider.getUriForFile(context, AppBuild.AUTHORITY, getDestinationOutput());
                getHandler().post(() -> ToastHelpers.showLong(context, "Downloaded successfully"));
            }

            @Override
            protected void onFinally() {
                if (uriOutput != null) {
                    resultCallback.onResult(uriOutput);
                }
                super.onFinally();
            }
        };

        downloadDialog.open(link);
    }

    public static void toPublicDirectoryDownload(Context context, String link) {
        toPublicDirectory(
                context, link, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        );
    }
}