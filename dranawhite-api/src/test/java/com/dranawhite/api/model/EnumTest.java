package com.dranawhite.api.model;

import com.dranawhite.exception.IllegalArgDranawhiteException;
import org.junit.Test;

/**
 * @author liangyq
 * @version [1.0, 2018/4/25 17:54]
 */
public class EnumTest {

	@Test(expected = IllegalArgDranawhiteException.class)
	public void testGetEnumByCode_Empty() {
		RespEnum.getRespEnumByCode("");
	}
}
