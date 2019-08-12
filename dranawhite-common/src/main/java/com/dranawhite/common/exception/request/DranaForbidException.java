package com.dranawhite.common.exception.request;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * @author dranawhite
 * @version : DranaForbidException.java, v 0.1 2019-08-12 11:33 dranawhite Exp $$
 */
public class DranaForbidException extends DranaRequestException {

    public DranaForbidException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaForbidException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaForbidException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaForbidException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
