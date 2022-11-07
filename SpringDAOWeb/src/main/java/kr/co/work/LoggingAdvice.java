package kr.co.work;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {
	//pointcut - 부가기능이 적용될 메서드의 패턴
	@Around("execution(* kr.co.work.MyMath.*(..))")							
	public Object methodCallLog(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		System.out.println("<<[start]");
		
		//타겟의 메서드(핵심기능) 호출
		Object result = pjp.proceed();
		

		System.out.println((System.currentTimeMillis()-start) +"ms");
		System.out.println("result = " +result);
		System.out.println("<<[end]");
		System.out.println();
		
		return result;
	}
}
