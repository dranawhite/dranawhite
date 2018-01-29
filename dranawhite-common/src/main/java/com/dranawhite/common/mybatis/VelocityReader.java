package com.dranawhite.common.mybatis;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 解析VM文件
 *
 * @author dranawhite 2018/1/26
 */
public class VelocityReader {

    private VelocityEngine vmEngine;

    private String vmPath;

    VelocityReader() {
        vmEngine = new VelocityEngine();
    }

    void init() throws IOException {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        InputStream propIns = resourceLoader.getResourceStream("velocity/velocity.properties");
        Properties props = new Properties();
        props.load(propIns);
        vmEngine.init(props);
    }

    void setVmPath(String vmPath) {
        this.vmPath = vmPath;
    }

    Writer putVariables(Map<String, String> variableMap) {
        Template tpl = vmEngine.getTemplate(vmPath);
        VelocityContext ctx = new VelocityContext();
        for(Map.Entry<String, String> entry : variableMap.entrySet()) {
            ctx.put(entry.getKey(), entry.getValue());
        }
        StringWriter writer = new StringWriter();
        tpl.merge(ctx, writer);
        return writer;
    }

}
