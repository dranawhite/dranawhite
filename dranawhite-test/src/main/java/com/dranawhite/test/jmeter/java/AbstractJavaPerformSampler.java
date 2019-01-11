package com.dranawhite.test.jmeter.java;

import com.dranawhite.api.model.Result;
import com.dranawhite.test.jmeter.SampleResultBuilder;

import org.apache.commons.collections.MapUtils;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

/**
 * Dubbo接口压力测试
 *
 * @author dranawhite
 * @version [1.0, 2018/4/25 17:06]
 */
@Slf4j
public abstract class AbstractJavaPerformSampler extends AbstractJavaSamplerClient {

	@Override
	public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
		String contextName = Thread.currentThread().getName();
		log.info(contextName + "-开启性能测试");
		long startTime = System.currentTimeMillis();
		Result invokeResult = run(javaSamplerContext);
		long endTime = System.currentTimeMillis();
		log.info(contextName + "-完成性能测试， 耗时" + (endTime - startTime) + " 毫秒");
		return SampleResultBuilder.buildResult(invokeResult);
	}

	@Override
	public Arguments getDefaultParameters() {
		Map<String, String> args = getArguments();
		if (MapUtils.isEmpty(args)) {
			return null;
		}
		Arguments arguments = new Arguments();
		for (Map.Entry<String, String> entry : args.entrySet()) {
			arguments.addArgument(entry.getKey(), entry.getValue());
		}
		return arguments;
	}

	/**
	 * 获取方法参数
	 *
	 * @return 参数集
	 */
	public abstract Map<String, String> getArguments();

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
