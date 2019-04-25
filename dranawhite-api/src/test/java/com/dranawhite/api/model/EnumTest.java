package com.dranawhite.api.model;

import com.dranawhite.common.exception.request.DranaIllegalArgumentException;

import org.junit.Test;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/25 17:54]
 */
public class EnumTest {

	@Test(expected = DranaIllegalArgumentException.class)
	public void testGetEnumByCode_Empty() {
		RespEnum.getRespEnumByCode("");
	}
}
