
package com.dranawhite.common.exception;

/**
 * @author dranawhite
 * @version : BiSystemException.java, v 0.1 2019-10-17 16:52 dranawhite Exp $$
 */
public class DranaSystemException extends DranaRuntimeException {

    public DranaSystemException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaSystemException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaSystemException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaSystemException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
