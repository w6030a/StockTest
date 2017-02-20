package com.javatpoint;

import com.opensymphony.xwork2.ActionSupport;

import dao.DbConnection;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 2L;

	private String email, password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute() {
		// test
		if(DbConnection.getConnection() != null) {
			System.out.print("Success");
			return SUCCESS;
		}
		
		// via email, query password from DB
		// check whether hashed password entered matches the one queried
		// if match save user info into session?
		// redirect to stock price view page
		return ERROR;
	}
}
