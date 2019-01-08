package com.dranawhite.common.exception.data;

/**
 * SQL解析异常
 *
 * @author dranawhite
 * @version $Id: DranaSQLException.java, v 0.1 2018-09-20 16:05 dranawhite Exp $$
 */
public class DranaSQLException extends DranaDataException {

    public DranaSQLException(String message) {
        super(message);
    }

    public DranaSQLException(String message, Object... args) {
        super(message, args);
    }

    public DranaSQLException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaSQLException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
