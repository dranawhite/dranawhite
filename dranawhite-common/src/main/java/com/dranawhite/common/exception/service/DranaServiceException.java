package com.dranawhite.common.exception.service;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 第三方调用异常
 *
 * @author dranawhite
 * @version $Id: DranaServiceException.java, v 0.1 2019-01-09 20:29 dranawhite Exp $$
 */
public class DranaServiceException extends DranaRuntimeException {

    public DranaServiceException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaServiceException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaServiceException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaServiceException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
