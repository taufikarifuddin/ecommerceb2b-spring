package com.taufik.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotZeroValueValidator implements ConstraintValidator<NotZeroValue, Integer>{
		
	
	@Override
	public void initialize(NotZeroValue arg0) {
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean isValid(Integer arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		System.out.println("called : "+arg0);
		return arg0 > 0;
	}
	
}
