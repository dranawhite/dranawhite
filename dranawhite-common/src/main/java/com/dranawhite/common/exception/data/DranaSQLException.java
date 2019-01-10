package com.dranawhite.common.exception.data;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * SQL解析异常
 *
 * @author dranawhite
 * @version $Id: DranaSQLException.java, v 0.1 2018-09-20 16:05 dranawhite Exp $$
 */
public class DranaSQLException extends DranaDataException {

    public DranaSQLException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaSQLException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaSQLException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaSQLException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
