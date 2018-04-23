package com.dranawhite.mq.builder;

import com.rabbitmq.client.BuiltinExchangeType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.TopicExchange;

/**
 * @author dranawhite 2018/04/23
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ExchangeBuilder {

	private final String name;

	private ExchangeBuilder(Builder builder) {
		name = builder.name;
	}

	public static Builder newBuilder(final String name) {
		return new Builder(name);
	}

	@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	public static final class Builder {
		
		private final String name;

		public Exchange build(BuiltinExchangeType exchangeType) {
			switch (exchangeType) {
				case DIRECT:
					return new DirectExchange(name);
				case TOPIC:
					return new TopicExchange(name);
				case FANOUT:
					return new FanoutExchange(name);
				case HEADERS:
					return new HeadersExchange(name);
			}
			return null;
		}
	}

}
