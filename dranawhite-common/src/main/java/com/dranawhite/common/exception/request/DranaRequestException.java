package com.dranawhite.common.exception.request;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 请求异常
 *
 * @author dranawhite
 * @version $Id: DranaRequestException.java, v 0.1 2018-10-08 9:07 dranawhite Exp $$
 */
public class DranaRequestException extends DranaRuntimeException {

    public DranaRequestException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaRequestException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaRequestException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaRequestException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
