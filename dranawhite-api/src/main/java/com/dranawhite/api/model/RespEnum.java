package com.dranawhite.api.model;

import com.dranawhite.common.util.StringUtil;
import com.dranawhite.exception.IllegalArgDranawhiteException;
import lombok.Getter;

/**
 * 公共返回码
 *
 * @author dranawhite
 * @version [1.0, 2018/4/25 17:28]
 */
public enum RespEnum {

	SYS_ERROR("000000", "系统异常"),
	SUCCESS("000001", "成功"),
	PARAM_INVALID("000002", "参数非法");

	@Getter
	private String code;

	@Getter
	private String desc;

	RespEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static RespEnum getRespEnumByCode(String code) {
		if (StringUtil.isEmpty(code)) {
			throw new IllegalArgDranawhiteException("Code值：" + code);
		}

		RespEnum[] respEnumArr = RespEnum.values();
		for (RespEnum respEnum : respEnumArr) {
			if (respEnum.getCode().equals(code)) {
				return respEnum;
			}
		}
		throw new IllegalArgDranawhiteException("Code值：" + code);
	}
}
