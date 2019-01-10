package com.dranawhite.common.exception.invoke;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * RPC调用异常
 *
 * @author dranawhite
 * @version $Id: DranaRpcInvokingException.java, v 0.1 2019-01-09 20:31 dranawhite Exp $$
 */
public class DranaRpcInvokingException extends DranaInvokingException {

    public DranaRpcInvokingException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaRpcInvokingException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaRpcInvokingException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaRpcInvokingException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
