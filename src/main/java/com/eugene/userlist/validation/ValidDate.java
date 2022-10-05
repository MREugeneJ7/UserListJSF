package com.eugene.userlist.validation;

import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target({ElementType.FIELD}) 
@Retention(RetentionPolicy.RUNTIME) 
@Constraint(validatedBy=DateValidator.class) 
public @interface ValidDate {
    String message() default "{message.id}";
    int minAge();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}