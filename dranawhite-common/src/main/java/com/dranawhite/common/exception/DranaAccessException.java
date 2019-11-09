
package com.dranawhite.common.exception;

/**
 * Drana访问异常
 * <pre>
 *     权限相关-403
 * </pre>
 *
 * @author dranawhite
 * @version : BiAccessException.java, v 0.1 2019-08-24 13:57 dranawhite Exp $$
 */
public class DranaAccessException extends DranaRuntimeException {

    private static final long serialVersionUID = 4111625713485765349L;

    public DranaAccessException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaAccessException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaAccessException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaAccessException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
