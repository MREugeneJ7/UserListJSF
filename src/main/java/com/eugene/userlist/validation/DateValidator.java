package com.eugene.userlist.validation;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidDate, LocalDate> {

	private LocalDate max;

    @Override
    public void initialize(ValidDate annotation) {

        this.max = LocalDate.now().minusYears(annotation.minAge());
    }
	
	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		return Objects.nonNull(value) && value.isBefore(max);
	}

}
