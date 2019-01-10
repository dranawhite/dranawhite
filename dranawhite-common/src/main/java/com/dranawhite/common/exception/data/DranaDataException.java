package com.dranawhite.common.exception.data;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 数据异常
 *
 * @author dranawhite
 * @version $Id: DranaDataException.java, v 0.1 2018-10-08 9:03 dranawhite Exp $$
 */
public class DranaDataException extends DranaRuntimeException {

    public DranaDataException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaDataException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaDataException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaDataException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
