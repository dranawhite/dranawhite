package com.dranawhite.distributed.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口响应体
 *
 * @author liangyq
 * @version [1.0, 2018/7/19 14:44]
 */
@Data
public class Response<T> implements Serializable {

	private static final long serialVersionUID = -3932512043180055539L;

	private String code;

	private String desc;

	private T data;
}
