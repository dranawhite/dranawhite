package com.dranawhite.common.exception.data;

/**
 * 数据访问异常
 *
 * @author dranawhite
 * @version $Id: DranaDataAccessException.java, v 0.1 2018-09-13 10:03 dranawhite Exp $$
 */
public class DranaDataAccessException extends DranaDataException {

    public DranaDataAccessException(String message) {
        super(message);
    }

    public DranaDataAccessException(String message, Object... args) {
        super(message, args);
    }

    public DranaDataAccessException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaDataAccessException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
