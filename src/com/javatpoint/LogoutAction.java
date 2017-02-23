package com.javatpoint;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	private static final long serialVersionUID = 3L;

	public String execute() {
		// need to clear session? or it will expire itself
		return SUCCESS;
	}
}
