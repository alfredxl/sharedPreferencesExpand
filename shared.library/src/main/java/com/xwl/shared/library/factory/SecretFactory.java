package com.xwl.shared.library.factory;

import android.content.Context;

/**
 * <br> ClassName:   SecretFactory
 * <br> Description: 密钥生产基地
 * <br>
 * <br> Author:      谢文良
 * <br> Date:        2017/9/30 9:28
 */

public class SecretFactory extends DataFactory {

    private static final String SECRET_KEY = "secret_key";

    public static String getSecretKey(Context context) {
        return getValue(context, SECRET_KEY);
    }

    public static void setSecretKey(Context context, String value) {
        putValue(context, SECRET_KEY, value);
    }
}
