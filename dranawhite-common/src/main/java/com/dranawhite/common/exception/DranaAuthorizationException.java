
package com.dranawhite.common.exception;

/**
 * Drana认证异常
 * <pre>
 *     认证相关-401
 * </pre>
 *
 * @author dranawhite
 * @version : BiAuthorizationException.java, v 0.1 2019-10-16 18:42 dranawhite Exp $$
 */
public class DranaAuthorizationException extends DranaRuntimeException {

    public DranaAuthorizationException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaAuthorizationException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaAuthorizationException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaAuthorizationException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
