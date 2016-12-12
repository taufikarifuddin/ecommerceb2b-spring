package com.taufik.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriceNumberValidator implements ConstraintValidator<PriceNumber, String>{

	@Override
	public void initialize(PriceNumber arg0) {		
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		try{
			Integer.parseInt(arg0);
			return true;
		}catch(Exception e){
			
		}
		return false;
	}
	
}

