package com.dranawhite.common.exception.request;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * Bean参数非法异常
 *
 * @author dranawhite
 * @version $Id: DranaRequestArgumentException.java, v 0.1 2018-09-08 17:53 dranawhite Exp $$
 */
public class DranaRequestArgumentException extends DranaRequestException {

    public DranaRequestArgumentException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaRequestArgumentException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaRequestArgumentException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaRequestArgumentException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
