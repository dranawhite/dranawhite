package com.dranawhite.common.exception.data;

/**
 * Portal Redis异常
 *
 * @author dranawhite
 * @version $Id: DranaRedisException.java, v 0.1 2018-11-09 10:09 dranawhite Exp $$
 */
public class DranaRedisException extends DranaDataException {
   
    public DranaRedisException(String message) {
        super(message);
    }

    public DranaRedisException(String message, Object... args) {
        super(message, args);
    }

    public DranaRedisException(String message, Throwable tr) {
        super(message, tr);
    }

    public DranaRedisException(String message, Throwable tr, Object... args) {
        super(message, tr, args);
    }
}
