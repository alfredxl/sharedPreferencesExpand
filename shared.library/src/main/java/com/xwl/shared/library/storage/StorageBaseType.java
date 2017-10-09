package com.xwl.shared.library.storage;

import android.content.SharedPreferences;

/**
 * <br> ClassName:   StorageBaseType
 * <br> Description: 基本类型存储封装
 * <br>
 * <br> Author:      谢文良
 * <br> Date:         2017/5/10 15:32
 */
public class StorageBaseType extends StorageString implements IStorageBaseType {


    /**
     * <br> Description: 构造函数
     * <br> Author:      谢文良
     * <br> Date:        2017/9/27 16:12
     *
     * @param sharedPreferences SharedPreferences
     * @param mUserFlag         用户标识
     * @param mVersion          版本标识
     * @param encryptionKey     密钥
     */
    public StorageBaseType(SharedPreferences sharedPreferences, String mUserFlag, String mVersion,
                           String encryptionKey) {
        super(sharedPreferences, mUserFlag, mVersion, encryptionKey);
    }

    @Override
    public void putInt(String key, int value) {
        putString(key, String.valueOf(value));
    }

    @Override
    public int getInt(String key, int defValue) {
        return Integer.parseInt(getString(key, String.valueOf(defValue)));
    }

    @Override
    public void putLong(String key, long value) {
        putString(key, String.valueOf(value));
    }

    @Override
    public long getLong(String key, long defValue) {
        return Long.parseLong(getString(key, String.valueOf(defValue)));
    }

    @Override
    public void putFloat(String key, float value) {
        putString(key, String.valueOf(value));
    }

    @Override
    public float getFloat(String key, float defValue) {
        return Float.parseFloat(getString(key, String.valueOf(defValue)));
    }

    @Override
    public void putBoolean(String key, boolean value) {
        putString(key, String.valueOf(value));
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return Boolean.parseBoolean(getString(key, String.valueOf(defValue)));
    }

    @Override
    public void putDouble(String key, double value) {
        putString(key, String.valueOf(value));
    }

    @Override
    public double getDouble(String key, double defValue) {
        return Double.parseDouble(getString(key, String.valueOf(defValue)));
    }
}
