package com.dranawhite.common.exception.business;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 *
 * @author dranawhite
 * @version $Id: DranaIllegalStateException.java, v 0.1 2019-01-12 11:34 dranawhite Exp $$
 */
public class DranaIllegalStateException extends DranaBusinessException {

    public DranaIllegalStateException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaIllegalStateException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaIllegalStateException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaIllegalStateException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
