package com.dranawhite.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dranawhite
 * @version [1.0, 2018/3/30 16:17]
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:applicationContext-disconf.xml"
})
public class ConfigTest {

	@Autowired
	private RabbitMq rabbitMq;

	@Test
	public void testDisconf() {
		String user = rabbitMq.getUsername();
		Assert.assertEquals(user, "admin");
	}

}
