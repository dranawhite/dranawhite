package com.dranawhite.common.exception;

import com.dranawhite.common.text.MessageFormatter;

import org.springframework.core.NestedRuntimeException;

/**
 * 运行时异常
 *
 * @author dranawhite
 * @version $Id: DranaRuntimeException.java, v 0.1 2018-09-08 11:09 dranawhite Exp $$
 */
public class DranaRuntimeException extends NestedRuntimeException {

    public DranaRuntimeException(String message) {
        super(message);
    }

    public DranaRuntimeException(String message, Object... args) {
        super(MessageFormatter.format(message, args));
    }

    public DranaRuntimeException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaRuntimeException(String message, Throwable tr, Object... args) {
        super(MessageFormatter.format(message, args), tr);
    }

}
