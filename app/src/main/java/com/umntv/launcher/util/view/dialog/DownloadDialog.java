package com.umntv.launcher.util.view.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.umntv.launcher.util.CloseableHelper;
import com.umntv.launcher.util.Convert;
import com.umntv.launcher.util.ToastHelpers;
import com.umntv.launcher.util.download.AbstractDownload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.n0ender.com.R;

public abstract class DownloadDialog extends AbstractDownload {

    private final ExecutorService executors = Executors.newFixedThreadPool(1);
    private final android.os.Handler handler = new android.os.Handler(Looper.myLooper());

    private final Context mContext;

    private final AlertDialog alertDialog;
    private final Button btnCancel;
    private final TextView tvProgressDownload;
    private final ProgressBar progressBar;
    private final TextView tvSizeDownload;
    private final TextView tvMessage;

    private final File directoryDestination;
    private File outputDestination = null;

    private FileOutputStream fileOutputStream = null;

    public DownloadDialog(Context mContext, File directoryDestination) {
        this.mContext = mContext;
        this.directoryDestination = directoryDestination;

        @SuppressLint("InflateParams")
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_direct_download, null, false);


        alertDialog = createDialogDownload(view);

        btnCancel = view.findViewById(R.id.btn_cancel);
        tvProgressDownload = view.findViewById(R.id.tv_progress_download);
        progressBar = view.findViewById(R.id.progress_bar);
        tvSizeDownload = view.findViewById(R.id.tv_size_download);
        tvMessage = view.findViewById(R.id.tv_message);
        btnCancel.setOnClickListener(v -> {
            disconnect();
            handler.post(() -> {
                ToastHelpers.showSort(mContext, "Download canceled");
            });
            alertDialog.cancel();
        });
    }

    private static AlertDialog createDialogDownload(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                view.getContext(), androidx.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert
        );

        alertDialogBuilder.setView(view);
        alertDialogBuilder.setCancelable(false);
        return alertDialogBuilder.create();
    }

    public Handler getHandler() {
        return handler;
    }

    public final File getDestinationOutput() {
        return outputDestination;
    }

    public final void setFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    @CallSuper
    @Override
    protected void onConnected(Header header) throws Throwable {
        String contentDisposition = header.getContentDisposition();
        String fileName;
        if (contentDisposition != null) {
            fileName = contentDisposition.replaceFirst("(?i)^.*filename=\"?([^\"]+)\"?.*$", "$1");
            if (fileName.isEmpty()) {
                fileName = Uri.parse(header.getUrl().getPath()).getLastPathSegment();
            }
        } else {
            fileName = Uri.parse(header.getUrl().getPath()).getLastPathSegment();
        }

//        String messageDownload = "please wait " + fileName + " is downloaded...";
        String messageDownload = "N0Render Download Center";
        String contentLengthInMegaByte = Convert.toMegaByteString(header.getContentLength());
        handler.post(() -> {
            tvMessage.setText(messageDownload);
            tvSizeDownload.setText(contentLengthInMegaByte);
        });

        if (directoryDestination != null) {
            outputDestination = new File(directoryDestination, fileName);
        } else
            throw new Throwable("please set directory destination");
    }

    @Override
    protected void onDownloadProgress(byte[] currentData, int count, long currentSize, long length) throws Throwable {
        checkNullFileOutputStream(fileOutputStream);
        fileOutputStream.write(currentData, 0, count);
        handler.post(() -> {
            try {
                int progressInPercent = Integer.parseInt(String.valueOf((currentSize * 100) / length));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    progressBar.setProgress(progressInPercent, true);
                } else {
                    progressBar.setProgress(progressInPercent);
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }

            String progressInMegaByte = Convert.toMegaByteString(currentSize);
            tvProgressDownload.setText(progressInMegaByte);
        });
    }

    @Override
    protected void onDownloadError(ErrorResponse errorResponse) {
        handler.post(() -> {
            ToastHelpers.showSort(mContext, errorResponse.getLocalizedMessage());
        });
    }

    @Override
    @CallSuper
    protected void onDownloadFinish() throws IOException {
        checkNullFileOutputStream(fileOutputStream);
        fileOutputStream.flush();
    }

    @Override
    @CallSuper
    protected void onFinally() {
        CloseableHelper.close(fileOutputStream);
        alertDialog.cancel();
    }

    public final void open(String link) {
        alertDialog.show();
        executors.submit(() -> start(link));
    }

    public void checkNullFileOutputStream(@Nullable FileOutputStream fileOutputStream) throws NullPointerException {
        if (fileOutputStream == null)
            throw new NullPointerException("please setFileOutputStream(...)");
    }
}
