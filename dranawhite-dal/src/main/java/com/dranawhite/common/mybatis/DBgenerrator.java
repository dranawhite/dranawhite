package com.dranawhite.common.mybatis;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DBgenerrator {

	public static String getURL() {
		File f = new File(DBgenerrator.getURL());
		System.out.println(f);
		return null;
	}

	public static void autoDB(String configFilePath) {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File(configFilePath);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config;
		try {
			config = cp.parseConfiguration(configFile);

			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator;
			try {
				myBatisGenerator = new MyBatisGenerator(config, callback,
						warnings);
				myBatisGenerator.generate(null);
			} catch (Exception e) {

				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (XMLParserException e) {
			e.printStackTrace();
		}
	}

}