package com.dranawhite.common.encrypt;

import org.apache.commons.codec.binary.Base64;

/**
 * @author dranawhite
 * @version $Id: Base64Utils.java, v 0.1 2019-01-07 15:58 dranawhite Exp $$
 */
public final class Base64Utils {

    public static String encode(String content) {
        return Base64.encodeBase64String(content.getBytes());
    }

    public static String decode(String content) {
        return new String(Base64.decodeBase64(content));
    }
}
