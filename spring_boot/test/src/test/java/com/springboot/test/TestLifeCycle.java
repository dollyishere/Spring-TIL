package com.springboot.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestLifeCycle {

	@BeforeAll
	static void beforeAll() {
		System.out.println("## BeforeAll Annotation 호출 ##");
		System.out.println();
	}
	
	@AfterAll
	static void afterALL() {
		System.out.println("## afterALL Annotation 호출 ##");
		System.out.println();
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("## beforeEach 호출 ##");
		System.out.println();
	}

	@AfterEach
	void afterEach() {
		System.out.println("## afterEach 호출 ##");
		System.out.println();
	}
	
	@Test
	void test1() {
		System.out.println("## 테스트 1 시작 ##");
		System.out.println();
	}
	
	@Test
	@DisplayName("Test Case 2!!!")
	void test2() {
		System.out.println("## 테스트 2 시작 ##");
		System.out.println();
	}
	
	@Test
	@Disabled
	void test3() {
		System.out.println("## 테스트 3 시작 ##");
		System.out.println();
	}
}
