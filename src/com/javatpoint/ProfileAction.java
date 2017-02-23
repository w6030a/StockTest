package com.javatpoint;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ProfileAction extends ActionSupport {

	private static final long serialVersionUID = 4L;
	
	private Map<String, Object> session;
	
	public String execute() {
		session = ActionContext.getContext().getSession();
		
		if(session.containsKey("userName")) {
			System.out.println(session.get("userName"));
			System.out.println(session.get("password"));
			System.out.println(session.get("email"));
		}
		
		return session.containsKey("userName")? SUCCESS : ERROR;
	}
}
