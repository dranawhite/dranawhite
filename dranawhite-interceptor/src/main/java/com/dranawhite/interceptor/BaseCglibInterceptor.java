package com.dranawhite.interceptor;

import com.dranawhite.common.exception.DranaRuntimeException;
import com.dranawhite.common.exception.ResultCodeEnum;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib字节码生成
 * <pre>
 *     对代理类所有方法的调用都会调用CGLibInterceptor，
 * 该类执行intercept()方法对方法进行拦截.
 *     被代理类无需实现任何接口
 * </pre>
 *
 * @author dranawhite 2017/8/16
 * @version 1.0
 */
public class BaseCglibInterceptor implements MethodInterceptor {

	public <T> T getProxy(Class<T> clz) {
		return (T) Enhancer.create(clz, this);
	}

	protected void setUp() {
	}

	protected <T> void setUp(T t) {
	}

	protected void tearDown() {
	}

	protected <T> void tearDown(T t) {
	}

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
			throw new DranaRuntimeException("动态代理异常！", ResultCodeEnum.SERVICE_UNAVAILABLE, t);
		}
	}
}
