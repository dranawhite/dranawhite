package com.dranawhite.common.exception.file;

/**
 * Portal JSON异常
 *
 * @author dranawhite
 * @version $Id: DranaJsonException.java, v 0.1 2018-10-08 9:20 dranawhite Exp $$
 */
public class DranaJsonException extends DranaFileException {

    public DranaJsonException(String message) {
        super(message);
    }

    public DranaJsonException(String message, Object... args) {
        super(message, args);
    }

    public DranaJsonException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaJsonException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
