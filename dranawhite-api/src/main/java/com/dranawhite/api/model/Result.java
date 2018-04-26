package com.dranawhite.api.model;

import lombok.Data;

/**
 * 结果类
 * <pre>
 *     用于接口间方法调用返回
 * </pre>
 *
 * @author liangyq
 * @version [1.0, 2018/4/25 17:23]
 */
@Data
public class Result<T> {

	/**
	 * 响应码
	 */
	private String respCode;

	/**
	 * 响应描述
	 */
	private String respDesc;

	/**
	 * 响应数据
	 */
	private T data;
}