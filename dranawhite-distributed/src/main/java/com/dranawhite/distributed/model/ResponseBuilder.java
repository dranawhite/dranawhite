package com.dranawhite.distributed.model;

/**
 * @author dranawhite
 * @version [1.0, 2018/7/19 14:44]
 */
public class ResponseBuilder {

	public static <T> Response<T> buildResponse(int code, String desc, T data) {
		Response response = new Response();
		response.setCode(code);
		response.setDesc(desc);
		response.setData(data);
		return response;
	}

	public static <T> Response<T> buildResponse(int code, String desc) {
		return buildResponse(code, desc, null);
	}

}
