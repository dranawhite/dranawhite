package com.dranawhite.common.exception.service;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * MQ异常
 * 
 * @author dranawhite
 * @version $Id: DranaMQException.java, v 0.1 2019-01-10 17:28 dranawhite Exp $$
 */
public class DranaMQException extends DranaServiceException {
    
    public DranaMQException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaMQException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaMQException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaMQException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
