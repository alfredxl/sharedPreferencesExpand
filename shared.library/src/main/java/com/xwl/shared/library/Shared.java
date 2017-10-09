package com.xwl.shared.library;

import android.content.Context;

import com.xwl.shared.library.factory.SecretFactory;

/**
 * <br> ClassName:   Shared
 * <br> Description: 本地数据存储(SharedPreferences)
 * <br>
 * <br> Author:      谢文良
 * <br> Date:         2017/5/10 10:44
 */
public class Shared {

    /**
     * 获取本地数据存储管理类
     *
     * @param context Context
     * @return 返回管理类
     */
    public static SharedManager with(Context context) {
        return with(context, SharedConfig.builder().build());
    }

    /**
     * 获取本地数据存储管理类
     *
     * @param context      Context
     * @param sharedConfig 配置信息
     * @return 返回管理类
     */
    public static SharedManager with(Context context, SharedConfig sharedConfig) {
        return SharedManager.get(context, sharedConfig);
    }

    /**
     * 清除本地数据
     *
     * @param context Context
     */
    public static void clear(Context context) {
        clear(context, SharedConfig.builder().build());
    }

    /**
     * 清除本地数据
     *
     * @param context      Context
     * @param sharedConfig 配置信息
     */
    public static void clear(Context context, SharedConfig sharedConfig) {
        with(context, sharedConfig).clear();
    }

    /**
     * <br> Description: 初始化默认密钥
     * <br> Author:      谢文良
     * <br> Date:        2017/9/30 9:48
     *
     * @param context       Context
     * @param encryptionKey 加密密钥
     */
    public static void initEncryptionKey(Context context, String encryptionKey) {
        SecretFactory.setSecretKey(context, encryptionKey);
    }
}
