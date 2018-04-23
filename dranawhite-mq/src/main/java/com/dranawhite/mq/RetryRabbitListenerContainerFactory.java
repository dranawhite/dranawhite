package com.dranawhite.mq;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author dranawhite
 */
public class RetryRabbitListenerContainerFactory extends SimpleRabbitListenerContainerFactory
		implements InitializingBean {

	private static final int INIT_CONSUMERS = 4;
	private static final int MAX_CONSUMERS = 16;

	@Override
	public void afterPropertiesSet() {
		setAcknowledgeMode(AcknowledgeMode.AUTO);
		setDefaultRequeueRejected(Boolean.FALSE);
		setConcurrentConsumers(INIT_CONSUMERS);
		setMaxConcurrentConsumers(MAX_CONSUMERS);
	}
}
