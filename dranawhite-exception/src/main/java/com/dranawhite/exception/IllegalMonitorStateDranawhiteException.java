package com.dranawhite.exception;

/**
 * @author liangyq
 * @version [1.0, 2018/5/15 16:33]
 */
public class IllegalMonitorStateDranawhiteException extends DranawhiteException {

	private static final long serialVersionUID = 8999046153796933280L;

	public IllegalMonitorStateDranawhiteException(String message) {
		super(message);
	}

	public IllegalMonitorStateDranawhiteException(String message, Throwable t) {
		super(message, t);
	}

	public IllegalMonitorStateDranawhiteException(Throwable t) {
		super(t);
	}
}
