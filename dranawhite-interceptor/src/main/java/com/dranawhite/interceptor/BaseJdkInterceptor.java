package com.dranawhite.interceptor;

import com.dranawhite.exception.DranawhiteException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理的类必须要实现一个接口
 *
 * @author dranawhite 2017/8/9
 * @version 1.0
 */
public class BaseJdkInterceptor<T> implements InvocationHandler {

	private T proxyObj;

	public void setProxyObj(T proxyObj) {
		this.proxyObj = proxyObj;
	}

	/**
	 * @param clz 被代理的类型
	 *
	 * <pre>
	 * 创建代理对象 在这个过程中，
	 *      a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
	 *      b.然后根据相应的字节码转换成对应的class，
	 *      c.然后调用newInstance()创建实例
	 * </pre>
	 *
	 * @return 被代理对象
	 */
	public <T> T getProxy(Class<T> clz) {
		return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{clz}, this);
	}

	protected void setUp(){}

	protected void setUp(T proxyObj){};

	protected void tearDown() {}

	protected void tearDown(T proxyObj) {}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) {
		try {
			setUp();
			setUp(proxyObj);
			Object result = method.invoke(proxy, args);
			tearDown(proxyObj);
			tearDown();
			return result;
		} catch (Throwable t) {
			throw new DranawhiteException("动态代理异常", t);
		}
	}
}
