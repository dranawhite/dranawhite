
package com.dranawhite.common.exception;

/**
 * @author dranawhite
 * @version : ResultCode.java, v 0.1 2019-08-24 15:10 dranawhite Exp $$
 */
public interface IResultCode {

    /**
     * return result code
     *
     * @return code
     */
    int getCode();

    /**
     * return result desc
     *
     * @return desc
     */
    String getDesc();
}
