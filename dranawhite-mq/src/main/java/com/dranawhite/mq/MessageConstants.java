package com.dranawhite.mq;

/**
 * 消息常量
 *
 * @author liangyq
 * @version [1.0, 2018/4/12 18:53]
 */
public final class MessageConstants {
	
	public static final String EXCHANGE_PRIFIX = "EX_";
	
	public static final String ROUTING_KEY_PRIFIX = "RK_";

	public static final String RETRY_SUFFIX = "_RETRY";

	public static final String REQUEUE_SUFFIX = "_REQUEUE";

	public static final String ROUTE_KEY_SUFFIX = "_ROUTE_KEY";

	/**
	 * 错误信息
	 */
	public static final class ErrorLetter {

		public static final String EXCHANGE = "LEND_DEAD_EXCHANGE";

		public static final String QUEUE = "LEND_DEAD_QUEUE";

		public static final String ROUTE_KEY = "LEND_DEAD_ROUTE_KEY";

	}

	/**
	 * 重发信息
	 */
	public static final class RetryLetter {

		public static final String EXCHANGE = "LEND_RETRY_EXCHANGE";

	}

	/**
	 * 重入队信息
	 */
	public static final class RequeueLetter {

		public static final String EXCHANGE = "LEND_REQUEUE_EXCHANGE";

	}

}
