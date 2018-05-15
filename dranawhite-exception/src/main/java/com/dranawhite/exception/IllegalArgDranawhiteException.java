package com.dranawhite.exception;

/**
 * 参数非法异常
 *
 * @author liangyq
 * @version [1.0, 2018/4/25 17:38]
 */
public class IllegalArgDranawhiteException extends DranawhiteException {

	private static final long serialVersionUID = 5917454928241041601L;

	public IllegalArgDranawhiteException(String message) {
		super(message);
	}

	public IllegalArgDranawhiteException(String message, Throwable t) {
		super(message, t);
	}

	public IllegalArgDranawhiteException(Throwable t) {
		super(t);
	}
}
