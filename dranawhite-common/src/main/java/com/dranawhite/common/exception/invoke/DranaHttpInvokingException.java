package com.dranawhite.common.exception.invoke;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * HTTP调用异常
 *
 * @author dranawhite
 * @version $Id: DranaHttpInvokingException.java, v 0.1 2019-01-09 20:30 dranawhite Exp $$
 */
public class DranaHttpInvokingException extends DranaInvokingException {

    public DranaHttpInvokingException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaHttpInvokingException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaHttpInvokingException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaHttpInvokingException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
