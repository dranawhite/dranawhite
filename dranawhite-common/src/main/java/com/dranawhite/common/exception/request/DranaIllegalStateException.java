package com.dranawhite.common.exception.request;

/**
 * 状态非法异常
 *
 * @author dranawhite
 * @version $Id: DranaIllegalStateException.java, v 0.1 2018-09-08 17:54 dranawhite Exp $$
 */
public class DranaIllegalStateException extends DranaRequestException {

    public DranaIllegalStateException(String message) {
        super(message);
    }

    public DranaIllegalStateException(String message, Object... args) {
        super(message, args);
    }

    public DranaIllegalStateException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaIllegalStateException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
