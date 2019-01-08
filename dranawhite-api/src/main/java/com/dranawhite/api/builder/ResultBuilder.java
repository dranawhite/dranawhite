package com.dranawhite.api.builder;

import com.dranawhite.api.model.RespEnum;
import com.dranawhite.api.model.Result;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/25 19:24]
 */
public class ResultBuilder {

	public static <T> Result<T> buildResult(RespEnum respEnum, T data) {
		Result<T> result = new Result<>();
		result.setRespCode(respEnum.getCode());
		result.setRespDesc(respEnum.getDesc());
		result.setData(data);
		return result;
	}

	public static <T> Result<T> buildResult(RespEnum respEnum) {
		return buildResult(respEnum, null);
	}

}
