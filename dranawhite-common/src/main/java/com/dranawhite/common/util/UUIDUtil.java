package com.dranawhite.common.util;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @author liangyq
 * @version [1.0, 2018/4/17 14:19]
 */
public final class UUIDUtil {

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
