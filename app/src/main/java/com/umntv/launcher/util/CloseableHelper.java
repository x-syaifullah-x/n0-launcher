package com.umntv.launcher.util;

import androidx.annotation.Nullable;

public class CloseableHelper {

    public static <T extends AutoCloseable> void close(@Nullable T t) {
        try {
            if (t != null) t.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
