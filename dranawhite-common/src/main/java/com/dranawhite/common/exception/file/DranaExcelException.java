package com.dranawhite.common.exception.file;

/**
 * Excel异常
 *
 * @author dranawhite
 * @version $Id: DranaExcelException.java, v 0.1 2018-09-21 20:40 dranawhite Exp $$
 */
public class DranaExcelException extends DranaFileException {

    public DranaExcelException(String message) {
        super(message);
    }

    public DranaExcelException(String message, Object... args) {
        super(message, args);
    }

    public DranaExcelException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaExcelException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
