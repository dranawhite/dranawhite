package com.dranawhite.common.encrypt;

import com.dranawhite.common.date.DateUtil;
import com.dranawhite.common.validation.ArgumentValidator;

import org.apache.commons.codec.digest.Md5Crypt;

import java.nio.charset.StandardCharsets;

/**
 * MD5加密
 * <pre>
 *     Commons-Codec包提供支持
 * </pre>
 *
 * @author dranawhite
 * @version [1.0, 2018/4/4 16:38]
 */
public final class EncryptUtil {

    /**
     * Common Codec包Md5加密前缀
     */
    private static final String MD5_PREFIX = "$1$";

    /**
     * MD5加盐加密
     *
     * @param password 密码
     * @param salt     盐值
     * @return 32位密文
     */
    public static String encrypt(String password, String salt) {
        ArgumentValidator.checkNotNull(password, salt);
        String pass = Md5Crypt.md5Crypt(password.getBytes(StandardCharsets.UTF_8), MD5_PREFIX + salt);
        return pass.substring(2);
    }

    /**
     * MD5加密
     *
     * @param password 密码
     * @return 32位密文
     */
    public static String encrypt(String password) {
        ArgumentValidator.checkNotNull(password);
        String pass = Md5Crypt.md5Crypt(password.getBytes());
        return pass.substring(2);
    }

    /**
     * 随机产生32位盐值
     *
     * @return 盐值
     */
    public static String generateSalt() {
        String today = DateUtil.formatSerialSecond(DateUtil.today());
        String salt = Md5Crypt.md5Crypt(today.getBytes());
        return salt.substring(2);
    }

}
