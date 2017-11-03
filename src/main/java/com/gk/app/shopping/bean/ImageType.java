package com.gk.app.shopping.bean;

public enum ImageType {

	LOGO("logo"), PROFILE_PHOTO("profile_photo"), LOCATION("location"), OTHERS("others");

	private String value;

	private ImageType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
