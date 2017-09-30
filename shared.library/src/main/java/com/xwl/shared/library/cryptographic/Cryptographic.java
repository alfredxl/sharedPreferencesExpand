package com.xwl.shared.library.cryptographic;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 * @author: xiewenliang
 * @Filename: Cryptographic
 * @Description: 字节加密解密
 * @Copyright: Copyright (c) 2017 Tuandai Inc. All rights reserved.
 * @date: 2017/5/10 9:24
 */

public class Cryptographic implements ICryptographic {
    private static final String ALGORITHM = "desede";
    private static final String TRANSFORMATION = "desede/ECB/PKCS7Padding";

    @Override
    public byte[] encryptByte(byte[] context, String key) {
        try {
            DESedeKeySpec spec = new DESedeKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            Key desKey = secretKeyFactory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            return cipher.doFinal(context);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public byte[] decodeByte(byte[] context, String key) {
        try {
            DESedeKeySpec spec = new DESedeKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            Key desKey = secretKeyFactory.generateSecret(spec);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            return cipher.doFinal(context);
        } catch (Exception e) {
            return null;
        }
    }
}
