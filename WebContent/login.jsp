<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<jsp:include page="index.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Login Page</title>
</head>
<body>
	<hr />
	<s:form action="login">
		<s:textfield name="username" label="Name"></s:textfield>
		<s:password name="userpass" label="Password"></s:password>
		<s:submit value="login"></s:submit>
	</s:form>
</body>
</html>