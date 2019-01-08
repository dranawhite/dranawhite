package com.dranawhite.common.exception.request;

import com.dranawhite.common.exception.DranaRuntimeException;

/**
 * 请求异常
 *
 * @author dranawhite
 * @version $Id: DranaRequestException.java, v 0.1 2018-10-08 9:07 dranawhite Exp $$
 */
public class DranaRequestException extends DranaRuntimeException {

    public DranaRequestException(String message) {
        super(message);
    }

    public DranaRequestException(String message, Object... args) {
        super(message, args);
    }

    public DranaRequestException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaRequestException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
