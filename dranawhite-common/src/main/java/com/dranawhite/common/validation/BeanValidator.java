package com.dranawhite.common.validation;

import com.dranawhite.common.constants.Separator;
import com.dranawhite.common.exception.DranaArgumentException;
import com.dranawhite.common.exception.GenericResultCode;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

/**
 * Hibernate Bean验证器
 *
 * @author dranawhite
 * @version [1.0, 2018/4/23 17:22]
 */
@SuppressWarnings("unchecked")
public final class BeanValidator {

    private static Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    /**
     * 校验Bean参数
     *
     * @param obj Bean实体
     * @param clz 校验分组
     * @param <T> Bean类型
     * @param <G> 分组类型
     */
    public static <T, G> void validate(T obj, Class<G>... clz) {
        if (Objects.isNull(obj) || ArgumentValidator.assertNull(clz)) {
            throw new DranaArgumentException("入参不能为空!", GenericResultCode.ARGUMENT_ERROR);
        }

        Set<ConstraintViolation<T>> resultSet = validator.validate(obj, clz);
        if (CollectionUtils.isEmpty(resultSet)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (ConstraintViolation<T> violation : resultSet) {
            sb.append(violation.getMessage()).append(Separator.StringSeparator.VERTICAL);
        }
        String result = sb.substring(0, sb.length() - 1);
        if (StringUtils.isNotBlank(result)) {
            throw new DranaArgumentException(result, GenericResultCode.ARGUMENT_ERROR);
        }
    }

    /**
     * 校验Bean参数
     *
     * @param obj Bean实体
     * @param <T> Bean类型
     */
    public static <T> void validate(T obj) {
        if (Objects.isNull(obj)) {
            throw new DranaArgumentException("入参不能为空!", GenericResultCode.ARGUMENT_ERROR);
        }
        validate(obj, Default.class);
    }

}
