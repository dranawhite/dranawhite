
package com.dranawhite.common.exception;

/**
 * RPC异常
 *
 * @author dranawhite
 * @version : BiRpcException.java, v 0.1 2019-08-24 10:28 dranawhite Exp $$
 */
public class DranaRpcException extends DranaRuntimeException {

    private static final long serialVersionUID = -2036507682092488688L;

    public DranaRpcException(String msg, IResultCode resultCode) {
        super(msg, resultCode);
    }

    public DranaRpcException(String msg, IResultCode resultCode, Object... args) {
        super(msg, resultCode, args);
    }

    public DranaRpcException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, resultCode, cause);
    }

    public DranaRpcException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(msg, resultCode, cause, args);
    }
}
