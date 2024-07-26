package jp.co.sss.shop.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LoginValidator implements ConstraintValidator<Login, Object>{
	private String userId;
	private String userPassword;
	
	@Override
	public void initialize(Login annotation) {
		this.userId = annotation.fieldUserId();
		this.userPassword = annotation.fieldUserPassword();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		BeanWrapper beanWrapper = new BeanWrapperImpl(value);
		Integer userId = (Integer) beanWrapper.getPropertyValue(this.userId);
		String userPassword = (String) beanWrapper.getPropertyValue(this.userPassword);
		
		if(userId != null && userId == 123 && "test123".equals(userPassword)) {
			return true;
		} else {
			return false;
		}
		
	}
	
}
