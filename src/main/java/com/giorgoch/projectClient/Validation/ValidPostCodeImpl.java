package com.giorgoch.projectClient.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPostCodeImpl implements ConstraintValidator<ValidPostCode, String>{

	private int min;
	private int max;
	
	@Override
	public void initialize(ValidPostCode constraintAnnotation) {
	
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return false;
	}

}