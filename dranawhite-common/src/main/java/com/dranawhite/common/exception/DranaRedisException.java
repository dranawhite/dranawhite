
package com.dranawhite.common.exception;

/**
 * @author dranawhite
 * @version : BiRedisException.java, v 0.1 2019-10-24 17:29 dranawhite Exp $$
 */
public class DranaRedisException extends DranaRuntimeException {

    public DranaRedisException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaRedisException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaRedisException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaRedisException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
