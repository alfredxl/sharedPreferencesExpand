package com.xwl.shared.library.factory;

import android.content.Context;

/**
 * <br> ClassName:   DataFactory
 * <br> Description: 密钥存储
 * <br>
 * <br> Author:      谢文良
 * <br> Date:        2017/9/30 9:54
 */

class DataFactory {
    private static final String NAME = "SecretFile";

    static String getValue(Context context, String key) {
        return context.getSharedPreferences(NAME, Context.MODE_PRIVATE).getString(key, null);
    }

    static void putValue(Context context, String key, String value) {
        context.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().putString(key, value).apply();
    }
}
