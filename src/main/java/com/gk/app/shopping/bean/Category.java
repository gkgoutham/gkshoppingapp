package com.gk.app.shopping.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "gkapp", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Category implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5236222241091426609L;
	private Integer id;
	private Users usersByApprovedBy;
	private Users usersByCreatedBy;
	private String title;
	private Date createdOn;
	private Date approvedOn;
	private Byte isActive;
	private Byte isApproved;

	public Category() {
	}

	public Category(String title) {
		this.title = title;
	}

	public Category(Users usersByApprovedBy, Users usersByCreatedBy, String title, Date createdOn, Date approvedOn,
			Byte isActive, Byte isApproved) {
		this.usersByApprovedBy = usersByApprovedBy;
		this.usersByCreatedBy = usersByCreatedBy;
		this.title = title;
		this.createdOn = createdOn;
		this.approvedOn = approvedOn;
		this.isActive = isActive;
		this.isApproved = isApproved;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "approved_by")
	public Users getUsersByApprovedBy() {
		return this.usersByApprovedBy;
	}

	public void setUsersByApprovedBy(Users usersByApprovedBy) {
		this.usersByApprovedBy = usersByApprovedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by")
	public Users getUsersByCreatedBy() {
		return this.usersByCreatedBy;
	}

	public void setUsersByCreatedBy(Users usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	@Column(name = "title", unique = true, nullable = false, length = 45)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", length = 19)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "approved_on", length = 19)
	public Date getApprovedOn() {
		return this.approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	@Column(name = "is_active")
	public Byte getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Byte isActive) {
		this.isActive = isActive;
	}

	@Column(name = "is_approved")
	public Byte getIsApproved() {
		return this.isApproved;
	}

	public void setIsApproved(Byte isApproved) {
		this.isApproved = isApproved;
	}

}
