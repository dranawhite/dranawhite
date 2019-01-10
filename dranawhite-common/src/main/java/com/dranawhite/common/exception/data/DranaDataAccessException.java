package com.dranawhite.common.exception.data;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 数据访问异常
 *
 * @author dranawhite
 * @version $Id: DranaDataAccessException.java, v 0.1 2018-09-13 10:03 dranawhite Exp $$
 */
public class DranaDataAccessException extends DranaDataException {

    public DranaDataAccessException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaDataAccessException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaDataAccessException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaDataAccessException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
