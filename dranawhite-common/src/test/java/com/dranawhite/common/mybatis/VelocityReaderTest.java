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
    public void test() throws IOException {
        VelocityReader reader = new VelocityReader();
        reader.init();
        reader.setVmPath("velocity/setter.vm");
        Map<String, String> map = new HashMap<>(1);
        map.put("param", "param");
        Writer writer = reader.putVariables(map);
        Assert.assertNotNull(writer.toString());
    }

}
