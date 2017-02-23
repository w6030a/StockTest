package com.javatpoint;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileAction extends ActionSupport {

	private static final long serialVersionUID = 4L;
	private Map<String, Object> session;
	
	public String execute() {
		System.out.println(String.format("User Name in session: %s", session.get("userName")));
		System.out.println(String.format("Password in session: %s", session.get("password")));
		System.out.println(String.format("Email in session: %s", session.get("email")));

		session = ActionContext.getContext().getSession();
		return session.containsKey("userName")? SUCCESS : ERROR;
	}
}
