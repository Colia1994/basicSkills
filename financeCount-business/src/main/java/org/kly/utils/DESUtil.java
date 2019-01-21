package org.kly.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

public class DESUtil {


    /**
     * 加密 解密
     *
     * @param datasource byte[]
     * @param password   String
     * @param type       1 加密 2 解密
     * @return byte[]
     */
    public static byte[] encrypt(byte[] datasource, String password, int type) {
        int cipherType = type == 1 ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE;
        try {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            //创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            //Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
            //用密匙初始化Cipher对象
            cipher.init(cipherType, securekey, random);
            //现在，获取数据并加密 ENCRYPT_MODE
            //正式执行加密操作
            return cipher.doFinal(datasource);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return null;
    }
}