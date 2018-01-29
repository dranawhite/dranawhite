package com.dranawhite.common.mybatis;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 *
 * @author liangyuquan
 * @version [V1.0, 2018/1/29]
 */
public class VelocityReaderTest {

    @Test
    public void testSetter() throws IOException {
        VelocityReader reader = new VelocityReader();
        reader.init();
        reader.setVmPath("mybatis_velocity/setter.vm");
        Map<String, String> map = new HashMap<>(1);
        map.put("param", "param");
        Writer writer = reader.putVariables(map, VelocityConstants.DEFAULT_SETTER_PATH);
        Assert.assertNotNull(writer.toString());
    }

    @Test
    public void testCopyright() throws IOException {
        VelocityReader reader = new VelocityReader();
        reader.init();
        reader.setVmPath("mybatis_velocity/copyright.vm");
        Map<String, String> map = new HashMap<>(1);
        map.put("company", "上海米么");
        Writer writer = reader.putVariables(map, VelocityConstants.DEFAULT_COPYRIGHT_PATH);
        Assert.assertNotNull(writer.toString());
    }

}
