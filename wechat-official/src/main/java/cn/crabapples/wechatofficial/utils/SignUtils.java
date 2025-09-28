package cn.crabapples.wechatofficial.utils;

import java.security.MessageDigest;

/**
 * 加密工具类
 * 2019年1月8日 下午2:15:52
 *
 * @author H
 * TODO 对字符串进行加密
 * Admin
 */
public class SignUtils {
    /**
     * SHA1计算
     *
     * @param string 需要进行计算的字符串
     * @return sha1值
     */
    public static String getSHA1(String string) {
        return encode("sha1", string);
    }

    /**
     * MD5计算
     *
     * @param string 需要进行计算的字符串
     * @return MD5值
     */
    public static String getMD5(String string) {
        return encode("md5", string);
    }

    private static String encode(String algorithm, String value) {
        if (value == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(value.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (byte aByte : bytes) {
            buf.append(HEX_DIGITS[(aByte >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[aByte & 0x0f]);
        }
        return buf.toString();
    }

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
}