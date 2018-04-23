package com.dranawhite.mq;

import lombok.Setter;
import org.springframework.util.backoff.BackOffExecution;
import org.springframework.util.backoff.ExponentialBackOff;

import javax.annotation.PostConstruct;

/**
 * @author liangyq
 * @version [1.0, 2018/4/12 15:47]
 */
public class MessageRetryCounter {

	/**
	 * 消息重发次数
	 */
	private static final int DEFAULT_RETRY_COUNT = 9;

	/**
	 * 消息重发TTL膨胀指数
	 */
	private static final double DEFAULT_MULTIPLIER = 2;

	/**
	 * 消息重发初始TTL
	 */
	private static final long DEFAULT_INITIAL_INTERVAL = 6 * 1000;

	private ExponentialBackOff backOff;

	public static final long STOP = BackOffExecution.STOP;

	@Setter
	private long initialInterval = DEFAULT_INITIAL_INTERVAL;

	@Setter
	private int retryCount = DEFAULT_RETRY_COUNT;

	@Setter
	private double multiplier = DEFAULT_MULTIPLIER;

	@Setter
	private long maxInterval = Long.MAX_VALUE;

	public MessageRetryCounter() {
		backOff = new ExponentialBackOff();
		init();
	}

	@PostConstruct
	public void init() {
		long maxElapsedTime = calculateMaxElapsedTime();
		backOff.setMaxElapsedTime(maxElapsedTime);
		backOff.setMultiplier(multiplier);
		backOff.setInitialInterval(initialInterval);
		backOff.setMaxInterval(maxInterval);
	}

	public long getTtlByCounter(long counter) {
		BackOffExecution execution = backOff.start();
		long ttl = -1L;
		while (counter > -1) {
			ttl = execution.nextBackOff();
			if (ttl == STOP) {
				return STOP;
			}
			counter--;
		}
		return ttl;
	}

	private long calculateMaxElapsedTime() {
		int counter = 0;
		long elapasedTime = initialInterval;
		long maxIntervalTime;
		while (++counter < retryCount) {
			long tmpMaxIntervalTime = (long) (initialInterval * Math.pow(multiplier, counter));
			maxIntervalTime = tmpMaxIntervalTime < this.maxInterval ? tmpMaxIntervalTime : this.maxInterval;
			elapasedTime += maxIntervalTime;
		}
		return elapasedTime;
	}
}
