package com.dranawhite.test.jmeter;

import com.dranawhite.common.exception.GenericResultCode;
import com.dranawhite.common.model.Result;
import com.dranawhite.common.text.JsonUtil;

import org.apache.jmeter.samplers.SampleResult;

import java.nio.charset.StandardCharsets;


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
        } else if (GenericResultCode.SUCCESS.getCode() == result.getCode()) {
            sampleResult.setResponseCode(String.valueOf(result.getCode()));
            sampleResult.setResponseData(JsonUtil.toJsonString(result.getData()), StandardCharsets.UTF_8.name());
            sampleResult.setSuccessful(Boolean.TRUE);
            sampleResult.setResponseMessageOK();
            sampleResult.setResponseMessage(result.getDesc());
        } else {
            sampleResult.setResponseCode(String.valueOf(result.getCode()));
            sampleResult.setResponseMessage(result.getDesc());
            sampleResult.setSuccessful(Boolean.FALSE);
        }
        return sampleResult;
    }
}
