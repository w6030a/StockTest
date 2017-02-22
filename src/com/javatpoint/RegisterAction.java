package com.javatpoint;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import biz.User;
import dao.DbService;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String userName, password, email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String execute() {
		if(userName == null)
			return NONE;
		
		DbService dbService = new DbService();
		
		if(dbService.hasSameName(userName)) {
			return INPUT;
		}
		
		System.out.println("No user name collision");
		
		try {
			dbService.addUser(new User(userName, password, email));
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}
}
