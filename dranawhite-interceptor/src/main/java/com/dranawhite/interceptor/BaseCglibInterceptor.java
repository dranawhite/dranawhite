package com.dranawhite.interceptor;

import com.dranawhite.exception.DranawhiteException;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;

/**
 * 抽象Cglib拦截器
 *
 * @author liangyq
 * @version [1.0, 2018/4/26 14:55]
 */
public class BaseCglibInterceptor implements MethodInterceptor {

	public <T> T getProxy(Class<T> clz) {
		return (T) Enhancer.create(clz, this);
	}

	protected void setUp(){}

	protected <T> void setUp(T t){}

	protected void tearDown() {}

	protected <T> void tearDown(T t){}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) {
		try {
			setUp();
			setUp(obj);
			Object result = methodProxy.invokeSuper(obj, args);
			tearDown(obj);
			tearDown();
			return result;
		} catch (Throwable t) {
			throw new DranawhiteException("动态代理异常！", t);
		}
	}
}
