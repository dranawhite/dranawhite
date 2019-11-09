package com.dranawhite.common.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author dranawhite
 * @version [1.0, 2018/5/29 17:48]
 */
public class IntValueValidator implements ConstraintValidator<IntValue, Integer> {

	private int val;

	@Override
	public void initialize(IntValue constraintAnnotation) {
		val = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		return val == value;
	}
}
