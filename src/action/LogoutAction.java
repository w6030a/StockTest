package action;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	private static final long serialVersionUID = 3L;
	private SessionMap<String, Object> session;
	
	public String execute() {
		session = (SessionMap<String, Object>) ActionContext.getContext().getSession();
		session.invalidate();
		return SUCCESS;
	}
}
