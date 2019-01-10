package com.dranawhite.test.jmeter;

import com.dranawhite.api.model.RespEnum;
import com.dranawhite.api.model.Result;
import com.dranawhite.common.util.JsonUtil;
import com.dranawhite.common.util.StringUtil;
import org.apache.jmeter.samplers.SampleResult;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/28 10:14]
 */
public final class SampleResultBuilder {

	public static SampleResult buildResult(Result<?> result) {
		SampleResult sampleResult = new SampleResult();
		sampleResult.setDataType(SampleResult.TEXT);
		sampleResult.setThreadName("JMeter请求");
		if (result == null) {
			sampleResult.setSuccessful(Boolean.FALSE);
		} else if (StringUtil.isEqual(RespEnum.SUCCESS.getCode(), result.getRespCode())) {
			sampleResult.setResponseCode(result.getRespCode());
			sampleResult.setResponseData(JsonUtil.toJsonString(result.getData()), "UTF-8");
			sampleResult.setSuccessful(Boolean.TRUE);
			sampleResult.setResponseMessageOK();
			sampleResult.setResponseMessage(result.getRespDesc());
		} else {
			sampleResult.setResponseCode(result.getRespCode());
			sampleResult.setResponseMessage(result.getRespDesc());
			sampleResult.setSuccessful(Boolean.FALSE);
		}
		return sampleResult;
	}
}
