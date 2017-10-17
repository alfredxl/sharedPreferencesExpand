package com.xwl.shared.library.factory;

import android.text.TextUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <br> ClassName:   SHA
 * <br> Description: SHA
 * <br>
 * <br> Author:      谢文良
 * <br> Date:        2017/9/30 11:37
 */

public class SHA {
    /**
     * 定义加密方式
     */
    private final static String KEY_SHA = "SHA";
    private final static String KEY_SHA1 = "SHA-1";
    /**
     * 全局数组
     */
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * SHA 加密
     *
     * @param data 需要加密的字节数组
     * @return 加密之后的字节数组
     */
    public static byte[] encryptSHA(byte[] data) {
        try {
            // 创建具有指定算法名称的信息摘要
            MessageDigest sha = MessageDigest.getInstance(KEY_SHA1);
            // 使用指定的字节数组对摘要进行最后更新
            sha.update(data);
            // 完成摘要计算并返回
            return sha.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * SHA 加密
     *
     * @param data 需要加密的字符串
     * @return 加密之后的字符串
     */
    public static String encryptSHA(String data) {
        try {
            // 验证传入的字符串
            if (TextUtils.isEmpty(data)) {
                return "";
            }
            // 创建具有指定算法名称的信息摘要
            MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
            // 使用指定的字节数组对摘要进行最后更新
            sha.update(data.getBytes());
            // 完成摘要计算
            byte[] bytes = sha.digest();
            // 将得到的字节数组变成字符串返回
            return byteArrayToHexString(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     *
     * @param b 字节数组
     * @return 字符串
     */
    private static String byteToHexString(byte b) {
        int ret = b;
        if (ret < 0) {
            ret += 256;
        }
        int m = ret / 16;
        int n = ret % 16;
        return hexDigits[m] + hexDigits[n];
    }

    /**
     * 转换字节数组为十六进制字符串
     *
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte item : bytes) {
            stringBuilder.append(byteToHexString(item));
        }
        return stringBuilder.toString();
    }
}
