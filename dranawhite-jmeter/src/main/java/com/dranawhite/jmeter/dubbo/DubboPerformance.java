package com.dranawhite.jmeter.dubbo;

import com.dranawhite.api.builder.ResultBuilder;
import com.dranawhite.api.model.RespEnum;
import com.dranawhite.api.model.Result;

/**
 * @author liangyq
 * @version [1.0, 2018/4/25 19:23]
 */
public class DubboPerformance extends AbstractDubboPerformSampler {

	@Override
	public <T> Result<T> run() {
		return ResultBuilder.buildResult(RespEnum.SUCCESS);
	}
}
