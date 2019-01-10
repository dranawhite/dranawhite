package com.dranawhite.common.exception.service;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * RPC调用异常
 *
 * @author dranawhite
 * @version $Id: DranaRpcException.java, v 0.1 2019-01-09 20:31 dranawhite Exp $$
 */
public class DranaRpcException extends DranaServiceException {

    public DranaRpcException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaRpcException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaRpcException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaRpcException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
