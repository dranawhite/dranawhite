package com.dranawhite.common.util;

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
		if (val == null || val.equals("")) {
			return originStr.toString();
		}
		if (val.length() >= len) {
			return val.substring(0, len);
		}
		String result = originStr.append(val).toString().substring(val.length(), originStr.length());
		return result;
	}

}
