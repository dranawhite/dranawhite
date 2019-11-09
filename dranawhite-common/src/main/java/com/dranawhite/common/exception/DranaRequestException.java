
package com.dranawhite.common.exception;

/**
 * BI请求异常
 * <pre>
 *     Web请求相关-400
 * </pre>
 *
 * @author dranawhite
 * @version : BiRequestException.java, v 0.1 2019-08-24 13:58 dranawhite Exp $$
 */
public class DranaRequestException extends DranaAccessException {

    private static final long serialVersionUID = 2454387407315092156L;

    public DranaRequestException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaRequestException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaRequestException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaRequestException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
