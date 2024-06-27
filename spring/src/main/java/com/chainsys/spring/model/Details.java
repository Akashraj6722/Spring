package com.chainsys.spring.model;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class Details {
	
	int id ;
	String name;
	String mail;
	String phone;
	String password;
	
	
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private Details(String name, String mail, String phone, String password) {
		super();
		this.name = name;
		this.mail = mail;
		this.phone = phone;
		this.password = password;
	}
	public Details() {
	}
	
	
	
	
	

}
