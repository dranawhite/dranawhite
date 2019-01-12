package com.dranawhite.common.date;

import org.junit.Test;

import java.util.Date;

/**
 *
 * @author liangyuquan
 * @version $Id: DateUtilTest.java, v 0.1 2019-01-12 14:02 liangyuquan Exp $$
 */
public class DateUtilTest {

    @Test
    public void testFormat() {
        Date tomorrow = DateUtil.dateAfterDay(1);
        System.out.println(DateUtil.formatSeconds(tomorrow));
    }
}
