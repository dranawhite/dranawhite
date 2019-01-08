package com.dranawhite.common.exception.file;

import com.dranawhite.common.exception.DranaRuntimeException;

/**
 * Portal文件异常
 *
 * @author dranawhite
 * @version $Id: DranaFileException.java, v 0.1 2018-10-08 9:11 dranawhite Exp $$
 */
public class DranaFileException extends DranaRuntimeException {

    public DranaFileException(String message) {
        super(message);
    }

    public DranaFileException(String message, Object... args) {
        super(message, args);
    }

    public DranaFileException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaFileException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
