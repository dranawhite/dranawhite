package com.dranawhite.dal.mybatis;

import com.dranawhite.common.util.ResourceLoader;

/**
 * @author liangyq
 * @version [1.0, 2018/4/17 15:29]
 */
public class MybatisGeneratorRun {

	public static void main(String[] args) {
		String url = ResourceLoader.getClasspathResource("mybatis-generator.xml");
		DBgenerrator.autoDB(url);
	}

}
