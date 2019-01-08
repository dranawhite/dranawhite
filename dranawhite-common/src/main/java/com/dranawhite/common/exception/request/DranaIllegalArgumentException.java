package com.dranawhite.common.exception.request;

/**
 * 参数非法异常
 *
 * @author dranawhite
 * @version $Id: DranaIllegalArgumentException.java, v 0.1 2018-10-09 15:17 dranawhite Exp $$
 */
public class DranaIllegalArgumentException extends DranaRequestException {

    public DranaIllegalArgumentException(String message) {
        super(message);
    }

    public DranaIllegalArgumentException(String message, Object... args) {
        super(message, args);
    }

    public DranaIllegalArgumentException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaIllegalArgumentException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
