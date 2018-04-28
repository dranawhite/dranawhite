package com.dranawhite.test.jmeter.dubbo;

import com.dranawhite.api.model.RespEnum;
import com.dranawhite.api.model.Result;
import com.dranawhite.common.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * Dubbo接口压力测试
 *
 * @author liangyq
 * @version [1.0, 2018/4/25 17:06]
 */
@Slf4j
public abstract class AbstractDubboPerformSampler extends AbstractJavaSamplerClient {

	@Override
	public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
		SampleResult result = new SampleResult();
		String contextName = Thread.currentThread().getName();

		log.info(contextName + "-Dubbo开启性能测试");
		long startTime = System.currentTimeMillis();
		Result invokeResult = run(javaSamplerContext);
		long endTime = System.currentTimeMillis();
		log.info(contextName + "-Dubbo完成性能测试， 耗时" + (endTime - startTime) + " 毫秒");

		if (invokeResult == null || StringUtil.isNotEqual(invokeResult.getRespCode(), RespEnum.SUCCESS.getCode())) {
			result.setSuccessful(Boolean.FALSE);
		} else {
			result.setSuccessful(Boolean.TRUE);
			result.setResponseData(invokeResult.getData().toString(), "UTF-8");
			result.setDataType(SampleResult.TEXT);
		}
		return result;
	}

	/**
	 * 业务运行方法
	 *
	 * @param context 取样器上下文
	 * @param <T>     数据封装
	 *
	 * @return Result
	 */
	public abstract <T> Result<T> run(JavaSamplerContext context);

}
