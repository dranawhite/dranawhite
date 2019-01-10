package com.dranawhite.common.exception.business;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 业务异常
 *
 * @author dranawhite
 * @version $Id: DranaBusinessException.java, v 0.1 2019-01-09 20:26 dranawhite Exp $$
 */
public class DranaBusinessException extends DranaRuntimeException {

    public DranaBusinessException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaBusinessException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaBusinessException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaBusinessException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
