package com.dranawhite.common.util;

import com.alibaba.fastjson.JSON;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/28 10:19]
 */
public final class JsonUtil {

	public static String toJson(Object obj) {
		return JSON.toJSONString(obj);
	}

	public static <T> T parseJson(String str) {
		return (T) JSON.parse(str);
	}
}
