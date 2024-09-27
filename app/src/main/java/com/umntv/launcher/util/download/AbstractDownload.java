package com.umntv.launcher.util.download;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.umntv.launcher.util.CloseableHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

abstract public class AbstractDownload {

    private static final String TAG = AbstractDownload.class.getSimpleName();

    public static class Header implements Serializable {

        private URL url;

        private long contentLength = 0;

        private String contentType;

        private int responseCode;

        private String contentDisposition;

        public URL getUrl() {
            return url;
        }

        public void setUrl(URL url) {
            this.url = url;
        }

        @Nullable
        public String getContentDisposition() {
            return contentDisposition;
        }

        public void setContentDisposition(String contentDisposition) {
            this.contentDisposition = contentDisposition;
        }

        public int getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(int responseCode) {
            this.responseCode = responseCode;
        }

        public long getContentLength() {
            return contentLength;
        }

        public void setContentLength(long mContentLength) {
            this.contentLength = mContentLength;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        @Override
        @NonNull
        public String toString() {
            return "Header{" +
                    "url=" + url +
                    ", contentLength=" + contentLength +
                    ", contentType='" + contentType + '\'' +
                    ", responseCode=" + responseCode +
                    ", contentDisposition='" + contentDisposition + '\'' +
                    '}';
        }
    }

    public static class ErrorResponse extends Throwable {

        private String msg = null;

        public ErrorResponse(@Nullable Throwable cause) {
            super(cause);
        }

        public ErrorResponse(@Nullable Throwable cause, String msg) {
            this(cause);
            this.msg = msg;
        }

        /**
         * @return message error from server
         */
        @Nullable
        public String getMsg() {
            return msg;
        }
    }

    private HttpURLConnection conn = null;

    protected abstract void onConnected(Header header) throws Throwable;

    protected void onDownloadProgress(byte[] currentData, int count) throws Throwable {
        /**/
    }

    protected void onDownloadProgress(byte[] currentData, int count, long currentSize) throws Throwable {
        onDownloadProgress(currentData, count);
    }

    protected void onDownloadProgress(byte[] currentData, int count, long currentSize, long length) throws Throwable {
        onDownloadProgress(currentData, count, currentSize);
    }

    protected void onDownloadError(ErrorResponse errorResponse) {

    }

    protected void onDownloadFinish() throws Throwable {
        /**/
    }

    protected void onFinally() {
        /**/
    }

    public final void disconnect() {
        if (conn != null) {
            conn.disconnect();
        } else {
            Log.i(TAG, "connection no initialize");
        }
    }

    public void start(String link) {

        InputStream is = null;

        try {
            URL url = new URL(link);

            conn = (HttpURLConnection) url.openConnection();

            final Header header = new Header();
            header.setUrl(conn.getURL());
            header.setContentLength(conn.getContentLength());
            header.setContentType(conn.getContentType());
            header.setResponseCode(conn.getResponseCode());
            header.setContentDisposition(conn.getHeaderField("Content-Disposition"));
            onConnected(header);

            byte[] data = new byte[10 * (1024 * 1024)];
            long size = 0;
            int count;

            is = conn.getInputStream();
            while ((count = is.read(data)) != -1) {
                size += count;
                onDownloadProgress(data, count, size, header.contentLength);
            }
            onDownloadFinish();
        } catch (Throwable t) {
            t.printStackTrace();
            ErrorResponse e = new ErrorResponse(t);
            InputStream errorInputStream = conn.getErrorStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            try {
                byte[] data = new byte[1024];
                int size = 0;
                int count;
                while ((count = errorInputStream.read(data)) != -1) {
                    size += count;
                    byteArrayOutputStream.write(data, 0, size);
                }
            } catch (IOException ee) {
                e.printStackTrace();
            } finally {
                CloseableHelper.close(byteArrayOutputStream);
                CloseableHelper.close(errorInputStream);
            }
            disconnect();
            e.msg = byteArrayOutputStream.toString();
            onDownloadError(e);
        } finally {
            CloseableHelper.close(is);
            onFinally();
        }
    }
}
