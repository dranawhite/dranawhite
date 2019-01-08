package com.dranawhite.common.exception.request;

/**
 * Bean参数非法异常
 *
 * @author dranawhite
 * @version $Id: DranaBeanArgumentException.java, v 0.1 2018-09-08 17:53 dranawhite Exp $$
 */
public class DranaBeanArgumentException extends DranaRequestException {

    public DranaBeanArgumentException(String message) {
        super(message);
    }

    public DranaBeanArgumentException(String message, Object... args) {
        super(message, args);
    }

    public DranaBeanArgumentException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaBeanArgumentException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
