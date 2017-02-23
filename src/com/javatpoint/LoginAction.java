package com.javatpoint;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import biz.User;
import dao.DbService;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 2L;

	private String userName, password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		if(userName == null || password == null) {
			return NONE;
		}
		
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
}
