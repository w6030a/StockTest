package com.javatpoint;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import biz.User;
import dao.DbConnection;
import dao.DbService;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 2L;

	private String userName, password, email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}
	
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
	
	public String login() {
		DbService dbService = new DbService();
		User user = dbService.getUser(userName, password);
		
		if(user == null) {
			this.addFieldError(userName, "Invalid user name or password o...");
			return INPUT;
		}
		
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		session.put("userName", user.getUserName());
		return SUCCESS;
	}
	
	public String logout() {
		// test
		if(DbConnection.getConnection() != null) {
			System.out.print("Log out Success");
			return SUCCESS;
		}
		
		return ERROR;
	}
}
