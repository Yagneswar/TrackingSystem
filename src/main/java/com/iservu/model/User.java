package com.iservu.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Table(name="USER4")
@Component
public class User {

	private String id;
	private String username;
	private String password;
	private String contactno;
	private char status;
	private String reason;
	private String OperatorCode;
	
	
	public String getOperatorCode() {
		return OperatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		OperatorCode = operatorCode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	private double amount;
	
	
	
	@Column(name="isonline")
	private char isonline;
	
	public char getIsonline() {
		return isonline;
	}
	public void setIsonline(char isonline) {
		this.isonline = isonline;
	}
	private String role;
	
	@Id
	@Column(name="ID")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Column(name="status")
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
}