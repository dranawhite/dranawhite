package com.dranawhite.common.exception.data;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * Portal Redis异常
 *
 * @author dranawhite
 * @version $Id: DranaRedisException.java, v 0.1 2018-11-09 10:09 dranawhite Exp $$
 */
public class DranaRedisException extends DranaDataException {
   
    public DranaRedisException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaRedisException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaRedisException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaRedisException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
