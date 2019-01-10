package com.dranawhite.common.exception.file;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * Excel异常
 *
 * @author dranawhite
 * @version $Id: DranaExcelException.java, v 0.1 2018-09-21 20:40 dranawhite Exp $$
 */
public class DranaExcelException extends DranaFileException {

    public DranaExcelException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaExcelException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaExcelException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaExcelException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
