package com.starteam.core.lib.appcontext;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Closeable;
import java.io.IOException;

/**
 * author : guanrunbai
 * time   : 2023/01/04
 * desc   : 初始化工具类，获取上下文，会自动初始化
 * version: 1.0
 */
public final class AppContextUtils {

    private static Application sApplication;

    public static void init(Application app) {
        if (app == null) {
            throw new NullPointerException("Argument 'app' of type Application (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        } else {
            sApplication = app;
        }
    }

    public static Application getApp() {
        if (sApplication != null) {
            return sApplication;
        } else {
            throw new NullPointerException("u should init first");
        }
    }


    @NonNull
    public static <T> T checkNotNull(@Nullable T arg) {
        return checkNotNull(arg, "Argument must not be null");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T arg, @NonNull String message) {
        if (arg == null) {
            throw new NullPointerException(message);
        }
        return arg;
    }


    /**
     * 关闭 IO
     *
     * @param closeables closeables
     */
    public static void closeIO(final Closeable... closeables) {
        if (closeables == null) {
            return;
        }
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static boolean isSpace(final String s) {
        if (s == null) {
            return true;
        }
        for (int i = 0, len = s.length(); i < len; ++i) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
