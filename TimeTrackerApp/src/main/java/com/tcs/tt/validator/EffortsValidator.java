package com.tcs.tt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tcs.tt.domain.TimeEffortForm;

@Component
public class EffortsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TimeEffortForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TimeEffortForm form = (TimeEffortForm) target;
		/*
		 * if (form.getEfforts() 9) { errors.rejectValue("efforts",
		 * "user.error.effort.not.greater"); }
		 */
		/*
		 * if (form.getDate() == null) { errors.rejectValue("date",
		 * "user.error.date.not.null"); }
		 */
	}
}
