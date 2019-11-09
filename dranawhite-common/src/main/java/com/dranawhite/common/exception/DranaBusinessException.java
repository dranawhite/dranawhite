
package com.dranawhite.common.exception;

/**
 * Drana业务异常
 *
 * @author dranawhite
 * @version : BiBusinessException.java, v 0.1 2019-10-16 18:42 dranawhite Exp $$
 */
public class DranaBusinessException extends DranaRuntimeException {

    public DranaBusinessException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaBusinessException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaBusinessException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaBusinessException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
