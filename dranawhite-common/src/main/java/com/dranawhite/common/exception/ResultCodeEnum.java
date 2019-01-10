package com.dranawhite.common.exception;

import lombok.Getter;

/**
 * 系统响应码
 * <pre>
 *     6位响应码：两位模块码+两位类型标志码+两位顺序码
 *     响应码与异常多对多对应，响应码主要与用户提示信息一一对应
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
    SYSTEM_BUSY(100002, "系统繁忙，请稍后重试"),
    NOT_SUPPORTED(100003, "尚不支持"),

    // 业务操作响应码
    // 用户操作响应码
    ILLEGAL_REQUEST(100202, "请求非法"),
    SESSION_EXPIRED(100203, "会话过期"),

    // 模板响应码——Excel, HTML, Freemarker, Velocity
    TEMPLATE_ERR(100301, "模板错误"),
    TEMPLATE_EXCEL_SHEET_LACK(100302, "Sheet页缺失"),
    TEMPLATE_DATA_LACK(100303, "数据缺失"),
    TEMPLATE_ILLEGAL_FORMAT(100304, "模板格式非法"),
    TEMPLATE_ILLEGAL_TITLE(100305, "模板标题非法"),
    ;

    private int code;
    private String desc;

    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
