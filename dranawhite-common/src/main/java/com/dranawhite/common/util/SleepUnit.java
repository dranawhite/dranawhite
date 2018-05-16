package com.dranawhite.common.util;

import com.dranawhite.exception.DranawhiteException;

import java.util.concurrent.TimeUnit;

/**
 * @author liangyq
 * @version [1.0, 2018/5/16 15:44]
 */
public final class SleepUnit {

	public static void seconds(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException ex) {
			throw new DranawhiteException(ex);
		}
	}

}
