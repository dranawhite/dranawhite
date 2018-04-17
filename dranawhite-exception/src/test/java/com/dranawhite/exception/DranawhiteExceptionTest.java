package com.dranawhite.exception;


import org.junit.Test;

/**
 * @author liangyq
 * @version [1.0, 2018/4/17 15:03]
 */
public class DranawhiteExceptionTest {

	@Test
	public void testFillStackTrace() {
		DranawhiteException ex = new DranawhiteException();
		ex.printStackTrace();
	}

}
