package com.dranawhite.api.model;

import com.dranawhite.common.exception.ResultCodeEnum;

import lombok.Getter;

/**
 * @author dranawhite
 * @version : DranaResponse.java, v 0.1 2019-07-26 14:00 dranawhite Exp $$
 */
public class DranaResponse<T> extends BaseResponse {

    @Getter
    private int code;

    @Getter
    private String errMsg;

    private boolean success;

    @Getter
    private T body;

    public static <T> DranaResponse<T> success(T body) {
        return new DranaResponse(0, "SUCCESS", true, body);
    }

    public static DranaResponse fail(ResultCodeEnum resultCodeEnum) {
        return new DranaResponse(resultCodeEnum.getCode(), resultCodeEnum.getDesc(), false, null);
    }

    public static DranaResponse fail(int code, String desc) {
        return new DranaResponse(code, desc, false, null);
    }

    private DranaResponse(int code, String errMsg, boolean success, T body) {
        this.code = code;
        this.errMsg = errMsg;
        this.success = success;
        this.body = body;
    }

    public boolean isSuccess() {
        return this.success;
    }

}
