package com.dranawhite.mq.builder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;

/**
 * @author dranawhite 2018/04/23
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class BindBuilder {
	private final String exchange;

	private final String queue;

	private final String routeKey;

	public static Builder newBuilder(final String exchange,String queue,String routeKey) {
		return new Builder(exchange,queue,routeKey);
	}

	@RequiredArgsConstructor(access= AccessLevel.PRIVATE)
	public static final class Builder {
		private final String exchange;
		private final String queue;
		private final String routeKey;

		public Binding build() {
			return new Binding(queue, Binding.DestinationType.QUEUE, exchange, routeKey, null);
		}
	}
}
