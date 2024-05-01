package com.dolly.spring.enums;

public enum TodoResultType {
	COMPLETE("complete"),
	FAILURE("failure"),
	PEND("pend");
	
	private final String value;
	
	TodoResultType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
