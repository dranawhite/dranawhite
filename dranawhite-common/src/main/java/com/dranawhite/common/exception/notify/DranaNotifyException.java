package com.dranawhite.common.exception.notify;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 通知异常
 *
 * @author dranawhite
 * @version [1.0, 2018/11/29 17:35]
 */
public class DranaNotifyException extends DranaRuntimeException {

	public DranaNotifyException(String message, ResultCodeEnum resultCodeEnum) {
		super(message, resultCodeEnum);
	}

	public DranaNotifyException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
		super(message, resultCodeEnum, args);
	}

	public DranaNotifyException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
		super(message, resultCodeEnum, tr);
	}

	public DranaNotifyException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
		super(message, resultCodeEnum, tr, args);
	}
}
