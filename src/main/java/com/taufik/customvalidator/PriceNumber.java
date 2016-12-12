package com.taufik.customvalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;

import java.lang.annotation.RetentionPolicy;


@Documented
@Constraint( validatedBy = PriceNumberValidator.class )
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface PriceNumber {
	String message() default "is not valid number";
}
