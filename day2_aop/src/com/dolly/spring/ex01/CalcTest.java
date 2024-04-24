package com.dolly.spring.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 6번 과정 **/
public class CalcTest {

	public static void main(String[] args) {
		// 1. AOPTest.xml을 읽어 빈을 생성
		// 같은 클래스 내부에 있기에 ClassPath를 사용
		// 따라서 xml 로딩하는 방법은 총 3가지임
		ApplicationContext context = new ClassPathXmlApplicationContext("AOPTest.xml");
		// 2. id가 proxyCal인 빈에 접근
		// 정확히는, proxyFactoryBean이라는 객체를 꺼낸거임
		// but 이 친구의 타겟은 Calculator임
		// 따라서 실제로 리턴되는 건 target class
		Calculator cal = (Calculator) context.getBean("proxyCal");
		
		// 3. 메서드 호출 전 후에 어드바이스 빈이 적용
		cal.add(100, 20);
		System.out.println();
		cal.subtract(100, 20);
		System.out.println();
		cal.multiply(100, 20);
		System.out.println();
		cal.divide(100, 20);

	}

}
