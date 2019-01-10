package com.dranawhite.common.exception.file;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * Portal文件异常
 *
 * @author dranawhite
 * @version $Id: DranaFileException.java, v 0.1 2018-10-08 9:11 dranawhite Exp $$
 */
public class DranaFileException extends DranaRuntimeException {

    public DranaFileException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaFileException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaFileException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaFileException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
