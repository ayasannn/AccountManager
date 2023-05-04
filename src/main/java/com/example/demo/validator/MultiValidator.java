package com.example.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.form.InsertForm;

@Component
public class MultiValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return InsertForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		InsertForm form = (InsertForm) target;
		//何も入力されていない時
		if(form.getMail() == null && form.getPass() == null) {
			errors.reject("demo.MultiValidator.bothBlank");
		}
	}
}
