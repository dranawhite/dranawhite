package com.dranawhite.common.exception.common;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;

/**
 * Bean实例化异常
 *
 * @author dranawhite
 * @version $Id: DranaBeanInstantiationException.java, v 0.1 2019-01-05 11:44 dranawhite Exp $$
 */
public class DranaBeanInstantiationException extends DranaRuntimeException {

    public DranaBeanInstantiationException(String message, ResultCodeEnum resultCodeEnum) {
        super(message, resultCodeEnum);
    }

    public DranaBeanInstantiationException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(message, resultCodeEnum, args);
    }

    public DranaBeanInstantiationException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, resultCodeEnum, tr);
    }

    public DranaBeanInstantiationException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(message, resultCodeEnum, tr, args);
    }
}
