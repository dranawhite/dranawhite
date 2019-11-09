
package com.dranawhite.common.exception;

/**
 * @author dranawhite
 * @version : BiFileException.java, v 0.1 2019-10-12 11:01 dranawhite Exp $$
 */
public class DranaFileException extends DranaRuntimeException {

    public DranaFileException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaFileException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaFileException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaFileException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
