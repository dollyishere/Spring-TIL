package com.dolly.spring.enums;

public enum TodoImportanceType {
	GOOD("good"),
	AVERAGE("average"),
	POOR("poor");
	
	private final String value;
	
	TodoImportanceType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
