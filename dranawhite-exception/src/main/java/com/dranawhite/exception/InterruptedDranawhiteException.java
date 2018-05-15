package com.dranawhite.exception;

/**
 * 中断异常
 *
 * @author liangyq
 * @version [1.0, 2018/5/15 16:40]
 */
public class InterruptedDranawhiteException extends DranawhiteException {

	private static final long serialVersionUID = 6491298702040045568L;

	public InterruptedDranawhiteException(String message) {
		super(message);
	}

	public InterruptedDranawhiteException(String message, Throwable t) {
		super(message, t);
	}

	public InterruptedDranawhiteException(Throwable t) {
		super(t);
	}
}
