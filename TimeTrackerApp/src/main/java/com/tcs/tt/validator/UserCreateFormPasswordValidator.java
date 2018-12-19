package com.tcs.tt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tcs.tt.domain.CreateEmployeeForm;

@Component
public class UserCreateFormPasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return CreateEmployeeForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		CreateEmployeeForm form = (CreateEmployeeForm) target;
		if (!form.getPassword1().equals(form.getPassword2())) {
			errors.rejectValue("password2", "user.error.password.no_match");
		}
	}
}
