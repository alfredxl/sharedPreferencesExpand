package com.xwl.shared.library.custom;

/**
 * <br> ClassName:   IContextDecorate
 * <br> Description: 密钥与密文组装接口
 * <br>
 * <br> Author:      谢文良
 * <br> Date:         2017/5/11 14:17
 */
public interface IContextDecorate {
    /**
     * 获取组装后的字符串
     *
     * @param key        加密密钥
     * @param cipherText 已加密密文
     * @return 返回组装后的字符串
     */
    String getDecorateContext(String key, String cipherText);

    /**
     * 获取密钥和密文
     *
     * @param decorateContext 密文和密钥组装后的字符串
     * @return 返回密钥和密文
     */
    String[] getKeyAndCipherText(String decorateContext);
}
