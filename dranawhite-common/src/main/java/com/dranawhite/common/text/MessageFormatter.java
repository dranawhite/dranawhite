package com.dranawhite.common.text;

import com.dranawhite.common.constants.Separator;
import com.dranawhite.common.validate.ArgumentValidator;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

/**
 * 消息格式器
 *
 * @author dranawhite
 * @version $Id: MessageFormatter.java, v 0.1 2018-11-09 10:59 dranawhite Exp $$
 */
public final class MessageFormatter {

    /**
     * 格式化字符串
     * <pre>
     *     将{}占位符替换为文本描述
     * </pre>
     *
     * @param msg  文本信息
     * @param args 参数
     * @return string
     */
    public static String format(String msg, Object... args) {
        if (StringUtils.isBlank(msg)) {
            return StringUtils.EMPTY;
        }
        if (ArgumentValidator.assertNull(args)) {
            return msg;
        }

        int num = 0;
        char[] charArr = msg.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : charArr) {
            sb.append(ch);
            if (ch == Separator.CH_LEFT_BRACE) {
                sb.append(num++);
            }
        }
        return MessageFormat.format(sb.toString(), args);
    }
}
