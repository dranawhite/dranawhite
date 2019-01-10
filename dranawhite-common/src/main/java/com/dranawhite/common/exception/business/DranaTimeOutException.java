package com.dranawhite.common.exception.business;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 超时异常
 *
 * @author dranawhite
 * @version $Id: DranaTimeOutException.java, v 0.1 2019-01-09 20:34 dranawhite Exp $$
 */
public class DranaTimeOutException extends DranaBusinessException {

    public DranaTimeOutException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaTimeOutException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaTimeOutException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaTimeOutException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
