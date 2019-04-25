package com.dranawhite.common.resource;

import com.dranawhite.common.exception.ResultCodeEnum;
import com.dranawhite.common.exception.file.DranaFileException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @author dranawhite
 * @version [1.0, 2018/4/17 14:43]
 */
public final class ResourceLoader {

	private static final ResourcePatternResolver resolver;

	static {
		resolver = new PathMatchingResourcePatternResolver();
	}

	public static String getClasspathResource(String file) {
		try {
			Resource resource = resolver.getResource(file);
			return resource.getURL().getPath();
		} catch (IOException ioe) {
			throw new DranaFileException("加载资源文件失败!", ResultCodeEnum.SERVICE_UNAVAILABLE, ioe);
		}
	}

}
