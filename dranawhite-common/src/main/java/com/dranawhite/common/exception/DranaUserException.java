
package com.dranawhite.common.exception;

/**
 * 用户异常
 *
 * @author dranawhite
 * @version : BiUserException.java, v 0.1 2019-10-22 11:13 dranawhite Exp $$
 */
public class DranaUserException extends DranaRuntimeException {

    public DranaUserException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaUserException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaUserException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaUserException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
