package com.dranawhite.common.exception;

/**
 * @author dranawhite
 * @version : GenericResultCode.java, v 0.1 2019-08-24 15:17 dranawhite Exp $$
 */
public enum GenericResultCode implements IResultCode {

    SUCCESS(0, "成功"),

    /**
     * SYSTEM_ERROR
     */
    SYSTEM_ERROR(100000, "系统异常"),
    ARGUMENT_ERROR(1000001, "参数错误"),
    NOT_SUPPORTED(1000002, "尚未支持"),
    CONFLICT(1000003, "资源冲突"),

    REQUEST_INVALID(4000000, "非法请求"),
    UNAUTHORIZED(4000001, "认证失败"),
    FORBIDDEN(4000003, "禁止访问"),

    USER_NOT_EXIST(5000001, "用户不存在");

    private int code;
    private String desc;

    GenericResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
