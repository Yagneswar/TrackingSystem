package com.iservu.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Blog")
public class Blog implements Serializable {

	// Blog with 4 instance variables

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String mobile;
	private String UserTrackId;
	

	public Blog()
	{
		id="BL"+UUID.randomUUID().toString();
	}

	// Blog with one parameterized constructor
	public Blog(String id, String mobile, String UserTrackId) {
		super();
		this.id = id;
		this.mobile = mobile;
		this.UserTrackId = UserTrackId;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserTrackId() {
		return UserTrackId;
	}

	public void setUserTrackId(String userTrackId) {
		UserTrackId = userTrackId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", mobile=" + mobile + ", UserTrackId=" + UserTrackId + "]";
	}

	/**
	 * @return the id
	 */
	

}
