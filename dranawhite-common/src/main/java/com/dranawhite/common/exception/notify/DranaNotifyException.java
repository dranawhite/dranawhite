package com.dranawhite.common.exception.notify;

import com.dranawhite.common.exception.DranaRuntimeException;

/**
 * 通知异常
 *
 * @author dranawhite
 * @version [1.0, 2018/11/29 17:35]
 */
public class DranaNotifyException extends DranaRuntimeException {

	public DranaNotifyException(String message) {
		super(message);
	}

	public DranaNotifyException(String message, Object... args) {
		super(message, args);
	}

	public DranaNotifyException(String message, Throwable tr) {
		super(message, tr);
	}

	public DranaNotifyException(String message, Throwable tr, Object... args) {
		super(message, tr, args);
	}
}
