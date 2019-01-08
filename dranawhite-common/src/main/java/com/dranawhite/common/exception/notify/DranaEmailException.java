package com.dranawhite.common.exception.notify;

/**
 *
 * @author dranawhite
 * @version $Id: DranaEmailException.java, v 0.1 2019-01-08 21:03 dranawhite Exp $$
 */
public class DranaEmailException extends DranaNotifyException {

    public DranaEmailException(String message) {
        super(message);
    }

    public DranaEmailException(String message, Object... args) {
        super(message, args);
    }

    public DranaEmailException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaEmailException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
