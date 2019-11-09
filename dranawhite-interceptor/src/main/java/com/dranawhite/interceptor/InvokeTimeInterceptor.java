package com.dranawhite.interceptor;

import com.dranawhite.common.exception.DranaSystemException;
import com.dranawhite.common.exception.GenericResultCode;

import lombok.extern.slf4j.Slf4j;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法调用计时器
 * <pre>
 *     单位：默认毫秒
 * </pre>
 *
 * @author dranawhite
 * @version [1.0, 2018/4/26 13:52]
 */
@Slf4j
public class InvokeTimeInterceptor extends BaseCglibInterceptor {

	protected long setUpTime() {
		return System.currentTimeMillis();
	}

	protected long tearDownTime() {
		return System.currentTimeMillis();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) {
		try {
			long startTime = setUpTime();
			Object result = methodProxy.invokeSuper(obj, args);
			long endTime = tearDownTime();
			long time = endTime - startTime;
			log.info("耗时：" + time);
			return result;
		} catch(Throwable t) {
			throw new DranaSystemException("计时器异常！", GenericResultCode.SYSTEM_ERROR, t);
		}
	}
}
