package com.dranawhite.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 初始化集合数据
 *
 * @author dranawhite
 * @version [1.0, 2018/4/27 11:33]
 */
public class CollectionInit {

	public static final int DEFAULT_NUM = 100000;

	/**
	 * 初始化数组数据
	 *
	 * @param num 数据量
	 *
	 * @return 数组
	 */
	public static Integer[] getRandomArray(int num) {
		List<Integer> list = new ArrayList<>(num);
		randomInitList(list, num);
		return list.toArray(new Integer[]{});
	}

	/**
	 * 初始化列表数据
	 *
	 * @param list 列表
	 * @param num  数据量
	 */
	public static void randomInitList(List<Integer> list, int num) {
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			list.add(random.nextInt(10000));
		}
	}
}
