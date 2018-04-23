package com.dranawhite.mq;

import com.dranawhite.common.util.RetryUtil;
import lombok.Setter;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/13 16:08]
 */
public class MessageRetryExecution {

	@Setter
	private RabbitTemplate rabbitTemplate;

	@SuppressWarnings("unchecked")
	public boolean retryMessage(Message message) {
		long counter = 0;
		Map<String, Object> headerMap = message.getMessageProperties().getHeaders();
		if (headerMap != null && headerMap.size() > 0) {
			List<Map<String, Object>> deathInfoList = (List<Map<String, Object>>) headerMap.get("x-death");
			if (deathInfoList != null && deathInfoList.size() > 0) {
				counter = (long) deathInfoList.get(0).get("count");
			}
		}
		long ttl = RetryUtil.getTtlByCounter(counter);
		if (ttl == RetryUtil.STOP) {
			return false;
		} else {
			message.getMessageProperties().setExpiration(String.valueOf(ttl));
			String consumerQueue = message.getMessageProperties().getConsumerQueue();
			String routeKey = consumerQueue.toUpperCase() + MessageConstants.RETRY_SUFFIX +
					MessageConstants.ROUTE_KEY_SUFFIX;
			rabbitTemplate.send(MessageConstants.RetryLetter.EXCHANGE, routeKey, message);
			return true;
		}
	}
}
