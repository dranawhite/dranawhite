
package com.dranawhite.common.exception;

/**
 * Drana参数异常
 * <pre>
 *     系统内部校验相关-500
 * </pre>
 *
 * @author dranawhite
 * @version : BiArgumentException.java, v 0.1 2019-08-24 13:59 dranawhite Exp $$
 */
public class DranaArgumentException extends DranaAccessException {

    private static final long serialVersionUID = 6546048024050593538L;

    public DranaArgumentException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaArgumentException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaArgumentException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaArgumentException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
