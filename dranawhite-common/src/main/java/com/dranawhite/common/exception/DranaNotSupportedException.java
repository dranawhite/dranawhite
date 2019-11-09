
package com.dranawhite.common.exception;

/**
 * @author dranawhite
 * @version : BiNotSupported.java, v 0.1 2019-10-24 18:10 dranawhite Exp $$
 */
public class DranaNotSupportedException extends DranaRuntimeException {
    public DranaNotSupportedException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaNotSupportedException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaNotSupportedException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaNotSupportedException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
