package com.dranawhite.common.exception.request;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 参数非法异常
 *
 * @author dranawhite
 * @version $Id: DranaIllegalArgumentException.java, v 0.1 2018-10-09 15:17 dranawhite Exp $$
 */
public class DranaIllegalArgumentException extends DranaRequestException {

    public DranaIllegalArgumentException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaIllegalArgumentException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaIllegalArgumentException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaIllegalArgumentException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
