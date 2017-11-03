package com.gk.app.shopping.bean.mongo;

import com.gk.app.shopping.bean.Users;

public class Rating {

	private String id;
	private Integer rate;
	private Users ratedBy;
	private String ratedOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Users getRatedBy() {
		return ratedBy;
	}

	public void setRatedBy(Users ratedBy) {
		this.ratedBy = ratedBy;
	}

	public String getRatedOn() {
		return ratedOn;
	}

	public void setRatedOn(String ratedOn) {
		this.ratedOn = ratedOn;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}
}
