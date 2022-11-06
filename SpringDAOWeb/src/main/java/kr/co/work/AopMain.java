package kr.co.work;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.transaction.annotation.Transactional;

public class AopMain {
	public static void main(String[] args) throws Exception {
		MyAdvice myAdvice = new MyAdvice();
		
		Class myClass = Class.forName("kr.co.work.MyClass");
		Object obj = myClass.newInstance();
		
		for(Method m : myClass.getDeclaredMethods()) {
			myAdvice.invoke(m, obj, null);
		}
	}

}

class MyClass {
	@Transactional
	void ezen1() {
		System.out.println("ezen1() is called");
	}

	void ezen2() {
		System.out.println("ezen2() is called");
	}

	void itezen1() {
		System.out.println("itezen1() is called");
	}
}
// 보조기능

class MyAdvice {
	Pattern p = Pattern.compile("e.*");
	
	boolean matches(Method m) {
		Matcher matcher = p.matcher(m.getName());
		return matcher.matches();	// e로 시작하는 메서드만 호출
	}
	
	void invoke(Method m, Object obj, Object... args) throws Exception {
		
//		if(matches(m))	System.out.println("[이전 before] {");	//e로시작하는 메서드에만 호출됨
		//핵심 기능에 Transactional 어노테이션이 설정되어 있는 경우에만 before/after를 출력
		if(m.getAnnotation(Transactional.class) != null)								//조건식 == 포인트컷
			System.out.println("[이전 before] {");
		
		m.invoke(obj,args);						// ezen1(), ezen2(), itezen1() 호출 가능
		
//		if(matches(m))	System.out.println("} [이후 after]");
		if(m.getAnnotation(Transactional.class) != null)
			System.out.println("} [이후 after]");


	}
}
