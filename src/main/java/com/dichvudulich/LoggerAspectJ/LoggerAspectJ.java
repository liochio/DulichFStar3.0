package com.dichvudulich.LoggerAspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerAspectJ {
	@Before("execution(* com.dichvudulich.hello..*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("before method: " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.dichvudulich.hello..*(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("before method: " + joinPoint.getSignature().getName());
	}

//	// chỉ thực hiện log với method2 của Hello.java
//	@AfterReturning(pointcut = "execution(* com.dichvudulich.hello.method2(..))", returning = "result")
//	public void logAfterReturning(JoinPoint joinPoint, Object result) {
//		System.out.println("after return method : " + joinPoint.getSignature().getName());
//		System.out.println("Method returned value is : " + result);
//	}
//
//	@AfterThrowing(pointcut = "execution(* com.dichvudulich.hello..*(..))", throwing = "error")
//	public void logThrow(JoinPoint joinPoint, Throwable error) {
//		System.out.println("exception in method: " + joinPoint.getSignature().getName());
//		System.out.println("Exception is: " + error);
//	}
}
