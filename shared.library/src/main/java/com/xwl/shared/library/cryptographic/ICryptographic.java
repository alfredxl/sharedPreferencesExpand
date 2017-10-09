package com.xwl.shared.library.cryptographic;

/**
 * <br> ClassName:   ICryptographic
 * <br> Description: 加解密（字节）
 * <br>
 * <br> Author:      谢文良
 * <br> Date:         2017/5/10 9:08
 */
public interface ICryptographic {
    /**
     * 加密字节
     *
     * @param context 待加密字节
     * @param key     密钥
     * @return 加密后的字节
     */
    byte[] encryptByte(byte[] context, String key);

    /**
     * 解密字节流
     *
     * @param context 待解密字节
     * @param key     密钥
     * @return 解密后的字节
     */
    byte[] decodeByte(byte[] context, String key);
}
