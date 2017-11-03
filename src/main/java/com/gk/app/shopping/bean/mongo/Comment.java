package com.gk.app.shopping.bean.mongo;

import com.gk.app.shopping.bean.Users;

public class Comment {

	private String id;
	private String text;
	private Users commentedBy;
	private String commentedOn;
	private String parentCommentId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public Users getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(Users commentedBy) {
		this.commentedBy = commentedBy;
	}

	public String getCommentedOn() {
		return commentedOn;
	}

	public void setCommentedOn(String commentedOn) {
		this.commentedOn = commentedOn;
	}

	public String getParentCommentId() {
		return parentCommentId;
	}

	public void setParentCommentId(String parentCommentId) {
		this.parentCommentId = parentCommentId;
	}

}
