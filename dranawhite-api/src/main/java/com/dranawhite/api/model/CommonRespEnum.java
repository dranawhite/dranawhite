package com.dranawhite.api.model;

import com.dranawhite.common.util.StringUtil;
import com.dranawhite.exception.IllegalArgDranawhiteException;
import lombok.Getter;

/**
 * 公共返回码
 *
 * @author liangyq
 * @version [1.0, 2018/4/25 17:28]
 */
public enum CommonRespEnum {

	SYS_ERROR("000000", "系统异常"),
	PARAM_INVALID("000001", "参数非法");

	@Getter
	private String code;

	@Getter
	private String desc;

	CommonRespEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static CommonRespEnum getRespEnumByCode(String code) {
		if (StringUtil.isEmpty(code)) {
			throw new IllegalArgDranawhiteException("Code值：" + code);
		}

		CommonRespEnum[] commonRespEnumArr = CommonRespEnum.values();
		for (CommonRespEnum commonRespEnum : commonRespEnumArr) {
			if (commonRespEnum.getCode().equals(code)) {
				return commonRespEnum;
			}
		}
		throw new IllegalArgDranawhiteException("Code值：" + code);
	}
}
