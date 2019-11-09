
package com.dranawhite.common.exception;

/**
 * 唯一性，幂等性校验
 * <pre>
 *     407
 * </pre>
 *
 * @author dranawhite
 * @version : BiConflictException.java, v 0.1 2019-10-25 11:09 dranawhite Exp $$
 */
public class DranaConflictException extends DranaRuntimeException {
    public DranaConflictException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaConflictException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaConflictException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaConflictException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
