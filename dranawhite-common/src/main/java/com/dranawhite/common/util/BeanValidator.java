package com.dranawhite.common.util;

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
public final class BeanValidator {

	private static Validator validator;

	static {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	public static <T, G> boolean validate(T obj, Class<G> clz) {
		return validator.validate(obj, clz).size() == 0;
	}

	public static <T> boolean validate(T obj) {
		return validate(obj, Default.class);
	}

}
