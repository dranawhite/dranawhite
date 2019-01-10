package com.dranawhite.common.exception.request;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * 无权访问异常
 *
 * @author dranawhite
 * @version $Id: DranaNonAuthorityException.java, v 0.1 2018-09-08 11:07 dranawhite Exp $$
 */
public class DranaNonAuthorityException extends DranaRequestException {

    public DranaNonAuthorityException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaNonAuthorityException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaNonAuthorityException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaNonAuthorityException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
