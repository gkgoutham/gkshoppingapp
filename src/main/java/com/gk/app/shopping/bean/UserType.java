package com.gk.app.shopping.bean;

public enum UserType {
	PARTNER("partner"), CUSTOMER("customer"), ADMIN("admin");

	private String value;

	UserType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
