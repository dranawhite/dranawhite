package com.dranawhite.common.exception.bean;

import com.dranawhite.common.exception.DranaRuntimeException;

/**
 * Bean实例化异常
 *
 * @author dranawhite
 * @version $Id: DranaBeanInstantiationException.java, v 0.1 2019-01-05 11:44 dranawhite Exp $$
 */
public class DranaBeanInstantiationException extends DranaRuntimeException {

    public DranaBeanInstantiationException(String message) {
        super(message);
    }

    public DranaBeanInstantiationException(String message, Object... args) {
        super(message, args);
    }

    public DranaBeanInstantiationException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaBeanInstantiationException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
