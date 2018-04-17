package com.dranawhite.config;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;
import org.springframework.stereotype.Service;

/**
 * @author liangyq
 * @version [1.0, 2018/3/30 16:06]
 */
@Service
@DisconfFile(filename = "rabbitmq.properties")
public class RabbitMq {

	private String host;

	private String port;

	private String username;

	private String password;

	@DisconfFileItem(name = "host", associateField = "rabbitmq.host")
	public String getHost() {
		return host;
	}

	@DisconfFileItem(name = "port", associateField = "rabbitmq.port")
	public String getPort() {
		return port;
	}

	@DisconfFileItem(name = "username", associateField = "rabbitmq.username")
	public String getUsername() {
		return username;
	}

	@DisconfFileItem(name = "password", associateField = "rabbitmq.password")
	public String getPassword() {
		return password;
	}
}
