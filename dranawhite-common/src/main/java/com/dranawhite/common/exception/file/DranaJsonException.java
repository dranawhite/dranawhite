package com.dranawhite.common.exception.file;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * Portal JSON异常
 *
 * @author dranawhite
 * @version $Id: DranaJsonException.java, v 0.1 2018-10-08 9:20 dranawhite Exp $$
 */
public class DranaJsonException extends DranaFileException {

    public DranaJsonException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaJsonException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaJsonException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaJsonException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
