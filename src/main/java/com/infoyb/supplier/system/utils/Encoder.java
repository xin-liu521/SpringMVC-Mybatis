package com.infoyb.supplier.system.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by infoyb on 2017.11.02.
 */
public class Encoder {

    public Encoder() {}

    private static final Logger logger = Logger.getLogger(Encoder.class);

    /**
     * 生成密钥
     */
    public static String initkey() throws NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance(Constant.KEY_ALGORITHM); //实例化密钥生成器
        kg.init(56);                                               //初始化密钥生成器
        SecretKey secretKey = kg.generateKey();                    //生成密钥
        return Base64.encodeBase64String(secretKey.getEncoded());  //获取二进制密钥编码形式
    }


    /**
     * 转换密钥
     */
    public static Key toKey(byte[] key) throws Exception {
        DESKeySpec dks = new DESKeySpec(key);                                      //实例化Des密钥
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(Constant.KEY_ALGORITHM); //实例化密钥工厂
        SecretKey secretKey = keyFactory.generateSecret(dks);                      //生成密钥
        return secretKey;
    }


    /**
     * 加密数据(对称加密),经http传输使用
     * @param data 待加密数据
     * @param key  密钥
     * @return 加密后的数据
     */
    public static String symmetricEncrypto(String data, String key) throws Exception {
        Key k = toKey(Base64.decodeBase64(key));                           //还原密钥
        Cipher cipher = Cipher.getInstance(Constant.CIPHER_ALGORITHM);     //实例化Cipher对象，它用于完成实际的加密操作
        cipher.init(Cipher.ENCRYPT_MODE, k);                               //初始化Cipher对象，设置为加密模式
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes())); //执行加密操作。加密后的结果通常都会用Base64编码进行传输
    }





    /**
     * 将字节数组转换成16进制字符串.
     * @param byteArr
     * @return 16进制字符串.
     */
    public static String byteArrayToHexString(byte[] byteArr) {
        StringBuffer hexString = new StringBuffer();
        String plainText;

        for (int i = 0; i < byteArr.length; i++) {
            plainText = Integer.toHexString(0xFF & byteArr[i]);
            if (plainText.length() < 2) {
                plainText = "0" + plainText;
            }
            hexString.append(plainText);
        }
        return hexString.toString();
    }

    /**
     * MD5 编码.
     * @param byteArr
     * @return String
     */
    public static String MD5Encode(byte[] byteArr) {
        String theResult = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            theResult = byteArrayToHexString(md.digest(byteArr));
        } catch (Exception e) {
        }
        return theResult;
    }

    /**
     * SHA-1 编码.
     * @param byteArr
     * @return String
     */
    public static String SHA1Encode(byte[] byteArr) {
        String theResult = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            theResult = byteArrayToHexString(md.digest(byteArr));
        } catch (Exception e) {
        }
        return theResult;
    }

    /**
     * SHA-256 编码.
     * @param byteArr
     * @return String
     */
    public static String SHA256Encode(byte[] byteArr) {
        String theResult = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            theResult = byteArrayToHexString(md.digest(byteArr));
        } catch (Exception e) {
        }

        return theResult;
    }
    /**
     * SHA-256 编码. 字符串加密
     * @param source
     * @return
     */
//	public static final String encryptMD5(String source) {
//		if (source == null) {
//			source = "";
//		}
//		Sha256Hash hash = new Sha256Hash(source);
//		return new Md5Hash(hash).toString();
//	}
    /**
     * SHA-512 编码.
     * @param byteArr
     * @return String
     */
    public static String SHA512Encode(byte[] byteArr) {
        String theResult = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            theResult = byteArrayToHexString(md.digest(byteArr));
        } catch (Exception e) {
        }
        return theResult;
    }

    /**
     * 对称加密方法.
     *
     * @param byteSource 需要加密的数据
     * @return 经过加密的数据
     * @throws Exception
     */
    public static byte[] symmetricEncrypto(byte[] byteSource) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int mode = Cipher.ENCRYPT_MODE;
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            byte[] keyData = {9, 1, 3, 7, 2, 1, 2, 0};
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
     * 对称加密方法.
     *
     * @param strSource 需要加密的数据
     * @return 经过加密的数据
     * @throws Exception
     */
    public static String symmetricEncrypto(String strSource) throws Exception {
        byte[] byteSource = strSource.getBytes("UTF-8");
        byte[] byteArr = symmetricEncrypto(byteSource);
        String result = byteArrayToHexString(byteArr);
        return result;
    }

    /**
     * 密码加密
     * @param password 需要加密的密码
     * @return 加密后的密码
     * @throws Exception
     */
    public static String encoderPassword(String password) throws Exception{
        String sha256 = SHA256Encode(password.getBytes());
        return MD5Encode(sha256.getBytes());
    }


    public static void main(String[] args) throws Exception {
//        logger.info(Encoder.byteArrayToHexString("我".getBytes()));
//        logger.info(Encoder.MD5Encode("我".getBytes()));
//        logger.info(Encoder.SHA1Encode("我".getBytes()));

//        String uiatc = Encoder.encryptMD5("111");
//        try {
//            byte[] byteArr = Encoder.symmetricEncrypto("fee".getBytes());
//            uiatc = Encoder.byteArrayToHexString(byteArr);
//        } catch (Exception ex) {
//        }
//        try {
//            uiatc = Encoder.symmetricEncrypto(System.currentTimeMillis() + "," + "fee");
//        } catch (Exception ex) {
//            Logger.getLogger(Encoder.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        logger.info(uiatc);
//        try {
//            logger.info(Decoder.symmetricDecrypto("82d9eda349f249b881458e2ad409bba41e161e00191cd0b1"));
//        } catch (Exception ex) {
//            Logger.getLogger(Encoder.class.getName()).log(Level.SEVERE, null, ex);
//        }

        ;


        logger.info(encoderPassword("123ABC"));
//        logger.info(Encoder.MD5Encode(Encoder.SHA512Encode("123456454546677".getBytes()).getBytes()));
        logger.info(symmetricEncrypto("123456"));

    }
}
