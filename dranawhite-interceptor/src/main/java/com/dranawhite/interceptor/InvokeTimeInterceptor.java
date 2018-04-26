package com.dranawhite.interceptor;

import com.dranawhite.exception.DranawhiteException;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法调用计时器
 * <pre>
 *     单位：毫秒
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/4/26 13:52]
 */
@Slf4j
public class InvokeTimeInterceptor implements MethodInterceptor {

	public <T> T getInstance(Class<T> clz) {
		return (T) Enhancer.create(clz, this);
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) {
		try {
			long startTime = System.currentTimeMillis();
			Object result = methodProxy.invokeSuper(obj, args);
			long endTime = System.currentTimeMillis();
			long time = endTime - startTime;
			log.info("耗时：" + time + " ms");
			return result;
		} catch(Throwable t) {
			throw new DranawhiteException("计时器异常！", t);
		}

	}
}
