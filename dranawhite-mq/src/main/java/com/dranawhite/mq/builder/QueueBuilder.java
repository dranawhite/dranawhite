package com.dranawhite.mq.builder;

import com.dranawhite.mq.MessageConstants;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dranawhite 2018/04/23
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class QueueBuilder {

	private final String name;

	private boolean durable;

	private boolean exclusive;

	private boolean autoDelete;

	public static Builder newBuilder(final String name) {
		return new Builder(name);
	}

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
	public static final class Builder {
		private final String name;
		private boolean durable = true;
		private boolean exclusive = false;
		private boolean autoDelete = false;

		public Builder durable(boolean durable) {
			this.durable = durable;
			return this;
		}

		public Builder exclusive(boolean exclusive) {
			this.exclusive = exclusive;
			return this;
		}

		public Builder autoDelete(boolean autoDelete) {
			this.autoDelete = autoDelete;
			return this;
		}

		public Queue build() {
			Map<String, Object> args = new HashMap<>(4);
			args.put("x-dead-letter-exchange", MessageConstants.ErrorLetter.EXCHANGE);
			args.put("x-dead-letter-routing-key", MessageConstants.ErrorLetter.ROUTE_KEY);
			return new Queue(name, durable, exclusive, autoDelete, args);
		}
	}

}
