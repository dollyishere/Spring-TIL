package com.dolly.spring.ex01;

/** 타깃 클래스 **/
public class Calculator {

	public Calculator() {
	} // 기본 생성자 END
	
	public void add(int x, int y) {
		int result = x + y;
		System.out.println("결과:" + result);
	}
	
	public void subtract(int x, int y) {
		int result = x - y;
		System.out.println("결과:" + result);
	}
	
	public void multiply(int x, int y) {
		int result = x * y;
		System.out.println("결과:" + result);
	}
	
	public void divide(int x, int y) {
		int result = x / y;
		System.out.println("결과:" + result);
	}

}
