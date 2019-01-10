package com.dranawhite.common.exception.business;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 找不到Model异常
 *
 * @author dranawhite
 * @version $Id: DranaModelNotFoundException.java, v 0.1 2019-01-09 20:27 dranawhite Exp $$
 */
public class DranaModelNotFoundException extends DranaBusinessException {

    public DranaModelNotFoundException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaModelNotFoundException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaModelNotFoundException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaModelNotFoundException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
