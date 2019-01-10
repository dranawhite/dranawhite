package com.dranawhite.common.exception.request;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 请求繁忙异常
 *
 * @author dranawhite
 * @version $Id: DranaRequestBusyException.java, v 0.1 2018-09-13 14:56 dranawhite Exp $$
 */
public class DranaRequestBusyException extends DranaRequestException {

    public DranaRequestBusyException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaRequestBusyException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaRequestBusyException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaRequestBusyException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
