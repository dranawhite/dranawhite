package com.dranawhite.common.exception.service;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * HTTP调用异常
 *
 * @author dranawhite
 * @version $Id: DranaHttpException.java, v 0.1 2019-01-09 20:30 dranawhite Exp $$
 */
public class DranaHttpException extends DranaServiceException {

    public DranaHttpException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaHttpException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaHttpException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaHttpException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
