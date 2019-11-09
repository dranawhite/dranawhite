
package com.dranawhite.common.exception;

/**
 * BI文本解析异常
 *
 * @author dranawhite
 * @version : BiTextException.java, v 0.1 2019-09-16 14:48 dranawhite Exp $$
 */
public class DranaTextException extends DranaRuntimeException {

    public DranaTextException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaTextException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaTextException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaTextException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
