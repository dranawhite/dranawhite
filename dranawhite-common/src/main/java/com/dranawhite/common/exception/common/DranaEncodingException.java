package com.dranawhite.common.exception.common;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 编码异常
 *
 * @author dranawhite
 * @version $Id: DranaEncodingException.java, v 0.1 2019-01-09 20:36 dranawhite Exp $$
 */
public class DranaEncodingException extends DranaRuntimeException {

    public DranaEncodingException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaEncodingException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaEncodingException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaEncodingException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
