package com.dranawhite.common.util;

import com.dranawhite.common.constants.Separator;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @author dranawhite
 * @version [1.0, 2018/4/17 14:19]
 */
public final class UUIDUtil {

	public static String getUUID() {
		return UUID.randomUUID().toString().replace(Separator.MIDDLELINE, "");
	}

}
