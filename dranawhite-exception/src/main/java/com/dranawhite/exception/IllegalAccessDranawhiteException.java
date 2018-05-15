package com.dranawhite.exception;

/**
 * 非法访问异常
 *
 * @author liangyq
 * @version [1.0, 2018/5/15 20:29]
 */
public class IllegalAccessDranawhiteException extends DranawhiteException {

	private static final long serialVersionUID = 334612334992315693L;

	public IllegalAccessDranawhiteException(String message) {
		super(message);
	}

	public IllegalAccessDranawhiteException(String message, Throwable t) {
		super(message, t);
	}

	public IllegalAccessDranawhiteException(Throwable t) {
		super(t);
	}
}
