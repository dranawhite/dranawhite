package com.dranawhite.mq;


import static com.dranawhite.mq.MessageConstants.EXCHANGE_PRIFIX;
import static com.dranawhite.mq.MessageConstants.REQUEUE_SUFFIX;
import static com.dranawhite.mq.MessageConstants.RETRY_SUFFIX;
import static com.dranawhite.mq.MessageConstants.ROUTE_KEY_SUFFIX;
import static com.dranawhite.mq.MessageConstants.ROUTING_KEY_PRIFIX;

import com.dranawhite.mq.builder.BindBuilder;
import com.dranawhite.mq.builder.ExchangeBuilder;
import com.dranawhite.mq.builder.QueueBuilder;
import com.rabbitmq.client.BuiltinExchangeType;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dranawhite 2018/04/23
 */
public class MessageRetryConfig implements ApplicationContextAware, InitializingBean {

	private ApplicationContext applicationContext;

	private AmqpAdmin rabbitAdmin;

	private List<String> queueList = new ArrayList<>();

	@Override
	public void afterPropertiesSet() {
		try {
			//如果消费者没有配置
			QueueConfig queueConfig = applicationContext.getBean(QueueConfig.class);
			if (null != queueConfig) {
				queueList = queueConfig.getSendQueueNameList();
			}
		} catch (Exception e) {
			//do nothing
		}

		matchRabbitAdmin();

		declareErrorLetter();
		declareBusinessLetter();
		declareRequeueLetter();
		declareRetryLetter();
	}

	private void declareErrorLetter() {
		Queue errorQueue = new Queue(MessageConstants.ErrorLetter.QUEUE);
		rabbitAdmin.declareQueue(errorQueue);
		DirectExchange errorExchange = new DirectExchange(MessageConstants.ErrorLetter.EXCHANGE);
		rabbitAdmin.declareExchange(errorExchange);
		Binding errorBinding =
				BindingBuilder.bind(errorQueue).to(errorExchange).with(MessageConstants.ErrorLetter.ROUTE_KEY);
		rabbitAdmin.declareBinding(errorBinding);
	}

	/**
	 * 定义工作队列绑定关系
	 */
	private void declareBusinessLetter() {
		for (String each : queueList) {
			rabbitAdmin.declareQueue(QueueBuilder.newBuilder(each).build());
			rabbitAdmin.declareExchange(
					ExchangeBuilder.newBuilder(EXCHANGE_PRIFIX + each).build(BuiltinExchangeType.DIRECT));
			rabbitAdmin.declareBinding(
					BindBuilder.newBuilder(EXCHANGE_PRIFIX + each, each, ROUTING_KEY_PRIFIX + each).build());
		}

	}

	/**
	 * 定义重试队列
	 */
	private void declareRetryLetter() {
		DirectExchange retryExchange = new DirectExchange(MessageConstants.RetryLetter.EXCHANGE);
		rabbitAdmin.declareExchange(retryExchange);
		for (String busQueue : queueList) {
			String retryQueueName = busQueue.toUpperCase() + RETRY_SUFFIX;
			String retryRouteKey = retryQueueName + ROUTE_KEY_SUFFIX;
			String requeueRouteKey = busQueue.toUpperCase() + REQUEUE_SUFFIX + ROUTE_KEY_SUFFIX;
			Map<String, Object> args = new HashMap<>(4);
			args.put("x-dead-letter-exchange", MessageConstants.RequeueLetter.EXCHANGE);
			args.put("x-dead-letter-routing-key", requeueRouteKey);
			Queue retryQueue = new Queue(retryQueueName, true, false, false, args);
			rabbitAdmin.declareQueue(retryQueue);
			Binding retryBinding = BindingBuilder.bind(retryQueue).to(retryExchange).with(retryRouteKey);
			rabbitAdmin.declareBinding(retryBinding);
		}
	}

	/**
	 * 消息重分配到原始工作队列
	 */
	private void declareRequeueLetter() {
		DirectExchange requeueExchange = new DirectExchange(MessageConstants.RequeueLetter.EXCHANGE);
		rabbitAdmin.declareExchange(requeueExchange);
		for (String busQueue : queueList) {
			String requeueRouteKey = busQueue.toUpperCase() + REQUEUE_SUFFIX + ROUTE_KEY_SUFFIX;
			Binding binding =
					new Binding(busQueue, Binding.DestinationType.QUEUE, MessageConstants.RequeueLetter.EXCHANGE,
							requeueRouteKey, null);
			rabbitAdmin.declareBinding(binding);
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	private void matchRabbitAdmin() {
		Collection<RabbitAdmin> coll = applicationContext.getBeansOfType(RabbitAdmin.class).values();
		if (coll == null || coll.size() == 0) {
			throw new IllegalStateException("RabbitAdmin缺失配置!");
		}
		rabbitAdmin = coll.iterator().next();
	}
}
