package com.dranawhite.common.exception.request;

/**
 * 请求繁忙异常
 *
 * @author dranawhite
 * @version $Id: DranaRequestBusyException.java, v 0.1 2018-09-13 14:56 dranawhite Exp $$
 */
public class DranaRequestBusyException extends DranaRequestException {

    public DranaRequestBusyException(String message) {
        super(message);
    }

    public DranaRequestBusyException(String message, Object... args) {
        super(message, args);
    }

    public DranaRequestBusyException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaRequestBusyException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
