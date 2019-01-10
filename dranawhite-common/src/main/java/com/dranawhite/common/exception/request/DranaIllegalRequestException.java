package com.dranawhite.common.exception.request;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * Bean参数非法异常
 *
 * @author dranawhite
 * @version $Id: DranaIllegalRequestException.java, v 0.1 2018-09-08 17:53 dranawhite Exp $$
 */
public class DranaIllegalRequestException extends DranaRequestException {

    public DranaIllegalRequestException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaIllegalRequestException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaIllegalRequestException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaIllegalRequestException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
