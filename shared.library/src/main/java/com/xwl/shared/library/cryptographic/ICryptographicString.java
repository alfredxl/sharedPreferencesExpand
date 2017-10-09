package com.xwl.shared.library.cryptographic;

/**
 * <br> ClassName:   ICryptographicString
 * <br> Description: 加解密（字符串）
 * <br>
 * <br> Author:      谢文良
 * <br> Date:         2017/5/10 9:18
 */
public interface ICryptographicString extends ICryptographic {
    /**
     * 加密字符串
     *
     * @param context 待加密字符串
     * @return 加密后的字符串
     */
    String encryptString(String context);

    /**
     * 解密字符串
     *
     * @param context 待解密字符串
     * @return 解密后的字符串
     */
    String decodeString(String context);

    /**
     * <br> Description: 获取加密key
     * <br> Author:      谢文良
     * <br> Date:        2017/9/27 16:08
     *
     * @return 返回加密key
     */
    String getKey();
}
