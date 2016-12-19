package com.taufik.customvalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.RetentionPolicy;


@Documented
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint( validatedBy = NotZeroValueValidator.class )
public @interface NotZeroValue {
	String message() default "is not valid number";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}

