package com.dranawhite.common.exception.notify;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 *
 * @author dranawhite
 * @version $Id: DranaEmailException.java, v 0.1 2019-01-08 21:03 dranawhite Exp $$
 */
public class DranaEmailException extends DranaNotifyException {

    public DranaEmailException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaEmailException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaEmailException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaEmailException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
