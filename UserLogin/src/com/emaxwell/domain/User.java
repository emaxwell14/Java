package com.emaxwell.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rid")
	private int id;
	
	@Column(name="user_name")
	private String userName;

	@Column(name="password")
	private String password;
	
	public User(){};

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
