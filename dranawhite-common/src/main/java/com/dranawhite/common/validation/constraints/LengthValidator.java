package com.dranawhite.common.validation.constraints;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author dranawhite
 * @version [1.0, 2018/5/29 17:56]
 */
public class LengthValidator implements ConstraintValidator<Length, String> {

	private int length;

	@Override
	public void initialize(Length constraintAnnotation) {
		length = constraintAnnotation.length();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isBlank(value) || value.length() != length) {
			return false;
		}
		return true;
	}
}
