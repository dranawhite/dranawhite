package com.dranawhite.common.text;

import com.dranawhite.common.exception.DranaSystemException;
import com.dranawhite.common.exception.GenericResultCode;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * 字符串工具
 *
 * @author dranawhite
 * @version $Id: StringEncoder.java, v 0.1 2018-10-16 14:31 dranawhite Exp $$
 */
public final class StringEncoder {

    /**
     * 字符串解码器
     *
     * @param str URL串
     * @return string
     */
    public static String decode(String str) {
        try {
            return URLDecoder.decode(str, StandardCharsets.UTF_8.name());
        } catch (Exception ex) {
            throw new DranaSystemException("字符串解码失败!", GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

}
