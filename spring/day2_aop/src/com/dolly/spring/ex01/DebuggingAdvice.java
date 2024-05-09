package com.dolly.spring.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class DebuggingAdvice implements MethodInterceptor {

	public DebuggingAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 2. 메서드 호출 전에 수행하는 구문
		System.out.println("[디버그 메서드 호출 전: DebuggingAdvice");
		// 어떤 메서드인지 알아두는 부분
		System.out.println(invocation.getMethod() + "디버그 메서드 호출 전");
		// 실제로 타깃 클래스에 적용되는 부분? => 실제 메서드 실행
		Object object = invocation.proceed(); // 3. invocation을 이용해 메서드 호출
		
		// 4. 메서드 호출 후에 수행하는 구문
		System.out.println("[디버그 메서드 호출 후: DebuggingAdvice");
		System.out.println(invocation.getMethod() + "디버그 메서드 호출 후");
		return object;
	}

}
