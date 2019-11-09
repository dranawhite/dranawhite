package com.dranawhite.common.validation;

import com.google.common.base.Preconditions;

import com.dranawhite.common.exception.DranaSystemException;
import com.dranawhite.common.exception.GenericResultCode;
import com.dranawhite.common.text.MessageFormatter;
import com.dranawhite.common.text.StringUtil;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Objects;

/**
 * 参数校验
 *
 * @author dranawhite
 * @version $Id: ArgumentValidator.java, v 0.1 2018-10-09 14:58 dranawhite Exp $$
 */
public final class ArgumentValidator {

    /**
     * 校验参数不能为空
     *
     * @param objs 参数
     */
    public static void checkNotNull(Object... objs) {
        if (objs == null) {
            return;
        }
        try {
            for (int i = 0, len = objs.length; i < len; i++) {
                Object obj = objs[i];
                String msg = MessageFormatter.format("第{}个参数不能为空!", (i + 1));
                if (obj instanceof String) {
                    Preconditions.checkArgument(StringUtils.isNotBlank((String) obj), msg);
                } else if (obj instanceof Collection) {
                    Preconditions.checkArgument(CollectionUtils.isNotEmpty((Collection) obj), msg);
                } else {
                    Preconditions.checkArgument(!Objects.isNull(objs[i]), msg);
                }
            }
        } catch (Exception ex) {
            throw new DranaSystemException(ex.getMessage(), GenericResultCode.SYSTEM_ERROR, ex);
        }
    }

    public static boolean assertNotNull(Object... args) {
        return !assertNull(args);
    }

    public static boolean assertNull(Object... args) {
        boolean isNullValue = args.length == 1 && StringUtil.NULL.equals(args[0]);
        return args.length == 0 || isNullValue;
    }

    /**
     * 校验参数是否是数字格式
     *
     * @param args 入参
     */
    public static void checkNumeric(Object... args) {
        if (assertNull(args)) {
            return;
        }
        for (Object arg : args) {
            if (StringUtil.EMPTY.equals(arg.toString())) {
                continue;
            }
            if (!(arg instanceof Number)) {
                throw new DranaSystemException(arg.toString() + "必须是数字类型", GenericResultCode.SYSTEM_ERROR);
            }
        }
    }
}
