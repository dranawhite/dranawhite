package com.dranawhite.exception;

/**
 * 状态非法异常
 *
 * @author liangyq
 * @version [1.0, 2018/4/27 16:29]
 */
public class IllegalStateDranawhiteException extends DranawhiteException {

	private static final long serialVersionUID = 4719044596447974988L;

	public IllegalStateDranawhiteException(String message) {
		super(message);
	}
}
