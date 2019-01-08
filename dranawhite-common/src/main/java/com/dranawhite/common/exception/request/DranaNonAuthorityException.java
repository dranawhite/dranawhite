package com.dranawhite.common.exception.request;

/**
 * 无权访问异常
 *
 * @author dranawhite
 * @version $Id: DranaNonAuthorityException.java, v 0.1 2018-09-08 11:07 dranawhite Exp $$
 */
public class DranaNonAuthorityException extends DranaRequestException {

    public DranaNonAuthorityException(String message) {
        super(message);
    }

    public DranaNonAuthorityException(String message, Object... args) {
        super(message, args);
    }

    public DranaNonAuthorityException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaNonAuthorityException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
