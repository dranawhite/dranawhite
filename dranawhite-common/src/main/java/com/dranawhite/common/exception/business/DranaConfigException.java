package com.dranawhite.common.exception.business;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 业务配置异常
 *
 * @author dranawhite
 * @version $Id: DranaConfigException.java, v 0.1 2019-01-09 20:32 dranawhite Exp $$
 */
public class DranaConfigException extends DranaBusinessException {

    public DranaConfigException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaConfigException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaConfigException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaConfigException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
