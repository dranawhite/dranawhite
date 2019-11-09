
package com.dranawhite.common.exception;

import com.dranawhite.common.text.MessageFormatter;

import lombok.Getter;

import org.springframework.core.NestedRuntimeException;

/**
 * BI运行时异常
 *
 * @author dranawhite
 * @version : BiRuntimeException.java, v 0.1 2019-08-24 10:07 dranawhite Exp $$
 */
public abstract class DranaRuntimeException extends NestedRuntimeException {

    private static final long serialVersionUID = -618998708189866962L;

    @Getter
    private IResultCode resultCode;

    public DranaRuntimeException(String msg, IResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public DranaRuntimeException(String msg, IResultCode resultCode, Object... args) {
        super(MessageFormatter.format(msg, args));
        this.resultCode = resultCode;
    }

    public DranaRuntimeException(String msg, IResultCode resultCode, Throwable cause) {
        super(msg, cause);
        this.resultCode = resultCode;
    }

    public DranaRuntimeException(String msg, IResultCode resultCode, Throwable cause, Object... args) {
        super(MessageFormatter.format(msg, args), cause);
        this.resultCode = resultCode;
    }

    public int getCode() {
        return resultCode.getCode();
    }

    public String getDesc() {
        return resultCode.getDesc();
    }
}
