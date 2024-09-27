package com.umntv.launcher.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import androidx.annotation.Nullable;

public class MediaStorageHelper {

    @Nullable
    public static Uri exist(ContentResolver cr, Uri mediaStoreUri, String name) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            String[] projection = new String[]{
                    MediaStore.MediaColumns._ID,
                    MediaStore.MediaColumns.DISPLAY_NAME,
                    MediaStore.MediaColumns.SIZE
            };
            Cursor cursor = cr.query(
                    mediaStoreUri,
                    projection,
                    MediaStore.MediaColumns.DISPLAY_NAME + "='" + name + "'",
                    null,
                    null
            );
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    int columnIndexName = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DISPLAY_NAME);
                    if (name.equals(cursor.getString(columnIndexName))) {
                        int columnIndexSize = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.SIZE);
                        long size = cursor.getLong(columnIndexSize);

                        int columnIndexId = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns._ID);
                        long id = cursor.getLong(columnIndexId);
                        return ContentUris.withAppendedId(MediaStore.Downloads.EXTERNAL_CONTENT_URI, id);
                    }
                }
                cursor.close();
            }
        }
        return null;
    }
}
