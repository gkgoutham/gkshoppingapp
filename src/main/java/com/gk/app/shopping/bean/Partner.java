package com.gk.app.shopping.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Partner generated by hbm2java
 */
@Entity
@Table(name = "partner", catalog = "gkapp", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Partner implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1944211556223782019L;
	private Integer id;
	private Users users;
	private String title;
	private Date createdOn;
	private Byte isActive;
	private Byte isApproved;
	private Set<Users> userses = new HashSet<Users>(0);

	public Partner() {
	}

	public Partner(String title) {
		this.title = title;
	}

	public Partner(Users users, String title, Date createdOn, Byte isActive, Byte isApproved, Set<Users> userses) {
		this.users = users;
		this.title = title;
		this.createdOn = createdOn;
		this.isActive = isActive;
		this.isApproved = isApproved;
		this.userses = userses;
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
	@JoinColumn(name = "created_by")
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}
