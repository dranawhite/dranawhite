package com.dranawhite.exception;

import lombok.NoArgsConstructor;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/17 14:55]
 */
@NoArgsConstructor
public class DranawhiteException extends RuntimeException {

	public DranawhiteException(String name) {
		super(name);
	}

	public DranawhiteException(Exception e) {
		super(e);
	}

	public DranawhiteException(String name, Exception e) {
		super(name, e);
	}

	@Override
	public DranawhiteException fillInStackTrace() {
		return this;
	}

}