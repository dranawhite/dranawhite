
package com.dranawhite.common.model;

import com.dranawhite.common.exception.IResultCode;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author dranawhite
 * @version : BiResponse.java, v 0.1 2019-10-11 15:30 dranawhite Exp $$
 */
@Setter
@Getter
public class DranaResponse<T> {

    private T data;

    private boolean isSuccess;

    private int result;

    private String errorMsg;

    public static <T> DranaResponse<T> success(T data) {
        DranaResponse<T> response = new DranaResponse<>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static <T> DranaResponse<T> fail(IResultCode resultCode) {
        DranaResponse<T> response = new DranaResponse<>();
        response.setResult(resultCode.getCode());
        response.setErrorMsg(resultCode.getDesc());
        response.setSuccess(false);
        return response;
    }

    public static <T> DranaResponse<T> fail(int result, String errorMsg) {
        DranaResponse<T> response = new DranaResponse<>();
        response.setResult(result);
        response.setErrorMsg(errorMsg);
        response.setSuccess(false);
        return response;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
