package com.gk.app.shopping.bean;

public enum Status {

	NEW("new"),OUT_OF_STOCK("out_of_stock"),AVAILABLE("available"),REMOVED("removed");

	private String value;

	Status(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
