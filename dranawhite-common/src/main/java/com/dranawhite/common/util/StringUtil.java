package com.dranawhite.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 *
 * @author liangyq
 * @version [1.0, 2018/4/24 18:09]
 */
public final class StringUtil {

	/**
	 * 填充字符串，前面补0
	 *
	 * @param val 待填充的字符串
	 * @param len 字符串完整长度
	 *
	 * @return 填充后的字符串
	 */
	public static String fillStr(String val, int len) {
		StringBuilder originStr = new StringBuilder();
		for (int i = 0; i < len; i++) {
			originStr.append("0");
		}
		if (isEmpty(val)) {
			return originStr.toString();
		}
		if (val.length() >= len) {
			return val.substring(0, len);
		}
		return originStr.append(val).toString().substring(val.length(), originStr.length());
	}

	public static boolean isEmpty(String val) {
		return StringUtils.isEmpty(val);
	}

	public static int compare(String str1, String str2) {
		return StringUtils.compare(str1, str2);
	}

	public static boolean isEqual(String str1, String str2) {
		return StringUtil.compare(str1, str2) == 0;
	}

	public static boolean isNotEqual(String str1, String str2) {
		return StringUtil.compare(str1, str2) != 0;
	}
}
