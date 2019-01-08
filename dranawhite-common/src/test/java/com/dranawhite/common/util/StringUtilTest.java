package com.dranawhite.common.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/24 18:16]
 */
public class StringUtilTest {

	@Test
	public void testFillStr() {
		String result = StringUtil.fillStr("123", 6);
		Assert.assertEquals(result, "000123");
	}

}
