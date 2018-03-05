package com.infoyb.supplier.system.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.ByteArrayOutputStream;
import java.security.Key;

/**
 * Package_Name: com.blions.utils.url <br/>
 * Created_With: blions-utils <br/>
 * Author: Minty   <br/>
 * Created_Time: 2015-10-12 11:01 <br/>
 * Description: 编码(解密)工具 <br/>
 */
public class Decoder {

    /**
     * 构造函数.
     */
    public Decoder() {
    }

    /**
     * 将16进制字符串转换成字节数组.
     * @param strHex 16进制字符串
     * @return 字节数组.
     */
    public static byte[] hexStringToByteArray(String strHex) {
        byte[] theResult = null;
        byte[] byteArr = new byte[strHex.length() / 2];
        for (int i = 0; i < byteArr.length; i++) {
            byteArr[i] = (byte) Integer.parseInt(strHex.substring(i*2, i*2+2), 16);
        }
        theResult = byteArr;
        return theResult;
    }

    /**
     * 解密数据(对称解密)经http传输使用
     * @param data 待解密数据
     * @param key  密钥
     * @return 解密后的数据
     */
    public static String symmetricDecrypto(String data, String key) throws Exception {
        Key k = Encoder.toKey(Base64.decodeBase64(key));
        Cipher cipher = Cipher.getInstance(Constant.CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);                           //初始化Cipher对象，设置为解密模式
        return new String(cipher.doFinal(Base64.decodeBase64(data)));  //执行解密操作
    }



    /**
     * 对称解密方法
     *
     * @param byteSource 需要解密的数据
     * @return 经过解密的数据
     * @throws Exception
     */
    public static byte[] symmetricDecrypto(byte[] byteSource) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int mode = Cipher.DECRYPT_MODE;
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            byte[] keyData = { 9, 1, 3, 7, 2, 1, 2, 0 };
            DESKeySpec keySpec = new DESKeySpec(keyData);
            Key key = keyFactory.generateSecret(keySpec);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(mode, key);
            int blockSize = cipher.getBlockSize();
            int position = 0;
            int length = byteSource.length;
            boolean more = true;
            while (more) {
                if (position + blockSize <= length) {
                    baos.write(cipher.update(byteSource, position, blockSize));
                    position += blockSize;
                } else {
                    more = false;
                }
            }
            if (position < length) {
                baos.write(cipher.doFinal(byteSource, position, length
                    - position));
            } else {
                baos.write(cipher.doFinal());
            }
            return baos.toByteArray();
        } catch (Exception e) {
            throw e;
        } finally {
            baos.close();
        }
    }

    /**
     * 对称解密方法
     * @param strSource 需解密字符串
     * @return
     * @throws Exception
     */
    public static String symmetricDecrypto(String strSource) throws Exception {
        byte[] byteSource = hexStringToByteArray(strSource);
        byte[] byteArr = symmetricDecrypto(byteSource);
        String result = new String(byteArr);
        return result;
    }

    public static void main(String[] args) throws Exception {
//        byte[] byteArr = Decoder.hexStringToByteArray("18e5e907c60ffeaac25d6b38e84baceec86483c7f185899e");
//        try {
//            byte[] byteArr2 = Decoder.symmetricDecrypto(byteArr);
//            logger.info(new String(byteArr2));
//        } catch (Exception ex) {
//            Logger.getLogger(Decoder.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        logger.info(new String(Decoder.hexStringToByteArray("ced2")));
        System.out.printf(symmetricDecrypto("974f8ed445d0785a"));
    }
}
