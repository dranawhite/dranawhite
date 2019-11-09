package com.dranawhite.common.resource;


import com.dranawhite.common.exception.DranaFileException;
import com.dranawhite.common.exception.GenericResultCode;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.Properties;


/**
 * Property工具类
 *
 * @author dranawhite
 * @version [1.0, 2018/4/27 16:06]
 */
public final class PropertyLoader {

    private static Properties prop;

    public static void load(String url) {
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource resource = resolver.getResource(url);
            prop = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException ioe) {
            throw new DranaFileException("加载资源文件失败!", GenericResultCode.SYSTEM_ERROR, ioe);
        }
    }

    public static String getProp(String key) {
        if (prop == null) {
            throw new DranaFileException("未指定Properties文件!", GenericResultCode.SYSTEM_ERROR);
        }
        return prop.getProperty(key);
    }
}
