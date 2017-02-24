package action;

import java.sql.SQLException;

import org.apache.commons.validator.routines.EmailValidator;

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

	public void validate() {
		if("".equals(userName)) {
			addFieldError("userName", getText("username.required"));
		}
		if("".equals(password)) {
			addFieldError("password", getText("password.required"));
		}
		if("".equals(email)) {
			addFieldError("email", getText("email.required"));
		}
		if(email != null && !EmailValidator.getInstance().isValid(email)) {
			addFieldError("email", getText("email.invalid"));;
		}
	}
	
	public String register() {
		if(userName == null || password == null || email == null) {
			return NONE;
		}
		
		DbService dbService = new DbService();
		
		if(dbService.hasSameName(userName)) {
			return INPUT;
		}
		
		try {
			dbService.addUser(new User(userName, password, email));
		} catch (SQLException e) {
			e.printStackTrace();
			return ERROR;
		}
		
		return SUCCESS;
	}
}
