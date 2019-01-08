package com.dranawhite.common.exception.data;

import com.dranawhite.common.exception.DranaRuntimeException;

/**
 * 数据异常
 *
 * @author dranawhite
 * @version $Id: DranaDataException.java, v 0.1 2018-10-08 9:03 dranawhite Exp $$
 */
public class DranaDataException extends DranaRuntimeException {

    public DranaDataException(String message) {
        super(message);
    }

    public DranaDataException(String message, Object... args) {
        super(message, args);
    }

    public DranaDataException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaDataException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
