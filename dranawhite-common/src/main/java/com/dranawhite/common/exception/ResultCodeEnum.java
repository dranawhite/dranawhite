package com.dranawhite.common.exception;

import lombok.Getter;

/**
 * 系统响应码
 * <pre>
 *     6位响应码：两位模块码+两位类型标志码+两位顺序码
 * </pre>
 *
 * @author dranawhite
 * @version $Id: ResultCodeEnum.java, v 0.1 2019-01-09 19:25 dranawhite Exp $$
 */
@Getter
public enum ResultCodeEnum {

    // 系统异常响应码
    SYSTEM_ERR(100000, "系统异常"),
    SERVICE_UNAVAILABLE(100001, "服务不可用"),

    // 工具和环境问题响应码
    ENVIRONMENT_ERR(100101, "系统环境异常"),
    CONFIG_ERR(100102, "系统配置错误"),
    JSON_ERR(100103, "JSON错误"),
    RPC_ERR(100104, "RPC错误"),
    REDIS_ERR(100105, "REDIS错误"),
    JOB_ERR(100106, "JOB错误"),
    MQ_ERR(100107, "MQ错误"),
    MAIL_ERR(100108, "MAIL错误"),
    EXCEL_ERR(100109, "EXCEL错误"),

    // 用户操作响应码
    ILLEGAL_PARAM(100201, "参数非法"),
    ILLEGAL_REQUEST(100202, "请求非法"),
    SESSION_EXPIRED(100203, "会话过期"),

    // 业务操作响应码
    ;

    private int code;
    private String desc;

    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
