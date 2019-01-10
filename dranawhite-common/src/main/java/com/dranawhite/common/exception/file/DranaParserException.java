package com.dranawhite.common.exception.file;

import com.dranawhite.common.exception.ResultCodeEnum;

/**
 *
 * @author dranawhite
 * @version $Id: DranaParserException.java, v 0.1 2019-01-10 17:31 dranawhite Exp $$
 */
public class DranaParserException extends DranaFileException {
  
    public DranaParserException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaParserException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaParserException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaParserException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
