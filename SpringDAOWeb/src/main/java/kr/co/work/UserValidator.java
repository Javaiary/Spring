package kr.co.work;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
//		return User.class.equals(clazz);	// 검증하려는 객체가 user 타입인지 확인
		return User.class.isAssignableFrom(clazz); // clazz가 User 또는 그 자손인지 확인
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("UserValidator.validate() is called");
		
		User user = (User)target;
		String id = user.getId();
		
//		if (id == null || "".equals(id.trim())){
//			errors.rejectValue("id", "required");
//		}
		
		// 위 3 줄을 api를 이용하여 한줄로 작성
		ValidationUtils.rejectIfEmpty(errors, "id", "required");
		ValidationUtils.rejectIfEmpty(errors, "pwd", "required");
		
		if(id == null || id.length() <5d || id.length() >12 ) {
			errors.rejectValue("id", "invalidLength", new String[] {"5", "12"}, null);
		}
	}
	
}
