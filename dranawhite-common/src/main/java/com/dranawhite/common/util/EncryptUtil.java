package com.dranawhite.common.util;

import org.apache.commons.codec.digest.Md5Crypt;

/**
 * MD5加密
 *
 * <pre>
 *     Commons-Codec包提供支持
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/4/4 16:38]
 */
public final class EncryptUtil {

	/**
	 * MD5加密
	 *
	 * @param passwd 密码
	 * @param salt   盐值
	 *
	 * @return 密文
	 */
	public static String encrypt(String passwd, String salt) {
		return Md5Crypt.md5Crypt(passwd.getBytes(), salt);
	}

	/**
	 * 随机产生盐值
	 *
	 * @return 盐值
	 */
	public static String generateSalt() {
		String today = DateUtil.getToday();
		return Md5Crypt.md5Crypt(today.getBytes());
	}

}
