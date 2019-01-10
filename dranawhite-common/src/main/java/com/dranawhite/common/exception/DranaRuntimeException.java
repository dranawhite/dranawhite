package com.dranawhite.common.exception;

import com.dranawhite.common.text.MessageFormatter;

import org.springframework.core.NestedRuntimeException;

import lombok.Getter;

/**
 * 运行时异常
 *
 * @author dranawhite
 * @version $Id: DranaRuntimeException.java, v 0.1 2018-09-08 11:09 dranawhite Exp $$
 */
public class DranaRuntimeException extends NestedRuntimeException {

    @Getter
    protected ResultCodeEnum resultCodeEnum;

    public DranaRuntimeException(String message, ResultCodeEnum resultCodeEnum) {
        super(message);
        this.resultCodeEnum = resultCodeEnum;
    }

    public DranaRuntimeException(String message, ResultCodeEnum resultCodeEnum, Object... args) {
        super(MessageFormatter.format(message, args));
        this.resultCodeEnum = resultCodeEnum;
    }

    public DranaRuntimeException(String message, ResultCodeEnum resultCodeEnum, Throwable tr) {
        super(message, tr);
        this.resultCodeEnum = resultCodeEnum;
    }

    public DranaRuntimeException(String message, ResultCodeEnum resultCodeEnum, Throwable tr, Object... args) {
        super(MessageFormatter.format(message, args), tr);
        this.resultCodeEnum = resultCodeEnum;
    }

}
