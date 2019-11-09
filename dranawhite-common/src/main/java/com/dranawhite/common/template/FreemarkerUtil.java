package com.dranawhite.common.template;

import com.dranawhite.common.exception.DranaSystemException;
import com.dranawhite.common.exception.GenericResultCode;

import freemarker.template.Configuration;
import freemarker.template.Template;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.ui.freemarker.SpringTemplateLoader;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;

/**
 * Freemarker模板工具
 *
 * @author dranawhite
 * @version $Id: FreemarkerUtil.java, v 0.1 2018-12-19 11:22 dranawhite Exp $$
 */
public final class FreemarkerUtil {

    private static volatile Configuration configuration;

    /**
     * 解析Freemarker模板
     *
     * @param tplPath  模板路径
     * @param modelMap 变量值
     * @return 模板内容
     */
    public static String parseTemplate(String tplPath, Map<String, Object> modelMap) {
        try {
            init();
            Template tpl = configuration.getTemplate(tplPath, Locale.CHINESE, StandardCharsets.UTF_8.name());
            return FreeMarkerTemplateUtils.processTemplateIntoString(tpl, modelMap);
        } catch (Exception ex) {
            throw new DranaSystemException("解析Freemarker模板失败!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    private static void init() {
        try {
            if (configuration != null) {
                return;
            }
            synchronized (FreemarkerUtil.class) {
                if (configuration != null) {
                    return;
                }
                configuration = new Configuration(Configuration.VERSION_2_3_28);
                ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
                configuration.setTemplateLoader(new SpringTemplateLoader(resolver, "/"));
            }
        } catch (Exception ex) {
            throw new DranaSystemException("初始化Freemarker模板失败!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }
}
