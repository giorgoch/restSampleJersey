package com.giorgoch.projectClient.Validation;



import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy =com.giorgoch.projectClient.Validation.ValidPostCodeImpl.class)
public @interface ValidPostCode {
	String message() default  "This does not appear to be a valid Post Code";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	int min() default 10;
	
	int max() default 20;
}