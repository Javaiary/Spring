package kr.co.work;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator2 implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
//		return User.class.equals(clazz);	// 검증하려는 객체가 user 타입인지 확인
		return User.class.isAssignableFrom(clazz); // clazz가 User 또는 그 자손인지 확인
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("UserValidator.validate() is called");

		User user = (User) target;
		String pwd = user.getPwd();

		// 위 3 줄을 api를 이용하여 한줄로 작성
		ValidationUtils.rejectIfEmpty(errors, "id", "required");
		ValidationUtils.rejectIfEmpty(errors, "pwd", "required");

		if (pwd == null || pwd.length() < 8) {
			errors.rejectValue("pwd", "invalidLength", new String[] {"8"}, null);

		}

	}
}
