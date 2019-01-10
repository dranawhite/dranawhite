package com.dranawhite.common.exception.service;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * JOB异常
 *
 * @author dranawhite
 * @version $Id: DranaJobException.java, v 0.1 2019-01-10 17:27 dranawhite Exp $$
 */
public class DranaJobException extends DranaServiceException {
    
    public DranaJobException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaJobException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaJobException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaJobException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
