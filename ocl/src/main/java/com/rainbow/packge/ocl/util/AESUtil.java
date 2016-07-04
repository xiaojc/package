package com.rainbow.packge.ocl.util;

import com.rainbow.packge.ocl.constants.Constants;
import com.rainbow.packge.ocl.constants.DefaultDefine;
import com.rainbow.packge.ocl.excption.ExceptionAdapter;
import com.rainbow.packge.ocl.excption.InteriorException;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加解密算法
 *
 */
@Slf4j
public class AESUtil {

    /**
     * 用AES/CBC/PKCS5Padding模式加密,并以Base64加密后返回
     * @param sSrc  原始字符
     * @param sKey  16位秘钥
     * @return
     * @throws Exception
     */
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); //"算法/模式/补码方式"
        IvParameterSpec iv = new IvParameterSpec(Constants.AES_IVPARAMETER.getBytes("utf-8")); //使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

//        return new BASE64Encoder().encode(encrypted);   //此处使用BASE64做转码功能，同时能起到2次加密的作用。
        return asHex(encrypted);
    }

    /**
     * 用AES/CBC/PKCS5Padding模式解密,并用Base64解密后返回
     * @param sSrc
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            //偏移量
            IvParameterSpec iv = new IvParameterSpec(Constants.AES_IVPARAMETER.getBytes("utf-8"));
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
//            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
            byte[] encrypted1 = asBin(sSrc);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"UTF-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }


    /**
     * 将字节数组转换成16进制字符串
     * @param buf
     * @return
     */
    private static String asHex(byte buf[]) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;
        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10)//小于十前面补零
                strbuf.append("0");
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }

    /**
     * 将16进制字符串转换成字节数组
     * @param src
     * @return
     */
    private static byte[] asBin(String src) {
        if (src.length() < 1)
            return null;
        byte[] encrypted = new byte[src.length() / 2];
        for (int i = 0; i < src.length() / 2; i++) {
            int high = Integer.parseInt(src.substring(i * 2, i * 2 + 1), 16);//取高位字节
            int low = Integer.parseInt(src.substring(i * 2 + 1, i * 2 + 2), 16);//取低位字节
            encrypted[i] = (byte) (high * 16 + low);
        }
        return encrypted;
    }


    public static void main(String[] args){
        try {
            String encryptStr = AESUtil.Encrypt("6225882015743765",Constants.AES_ENCRYPT_KEY);
            System.out.println("AES生成的加密字符串:"+encryptStr);
//            log.info("AES生成的加密字符串:{}",encryptStr);
        } catch (Exception e) {
            throw  new ExceptionAdapter(new InteriorException(DefaultDefine.AES_ENCRYPT_FAIL.getResponseCode(),
                    DefaultDefine.AES_ENCRYPT_FAIL.getResponseMsg()));
        }
    }
}