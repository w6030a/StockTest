<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<hr />
	<div align="right">
		<a href="login">register</a>|
		<a href="logout">logout</a>|
		<a href="profile">profile</a>
	</div>

	<div align="center">
		<s:form action="register">
			<s:textfield name="userName" label="Name"></s:textfield>
			<s:password name="password" label="Password"></s:password>
			<s:textfield name="email" label="Email"></s:textfield>
			<s:submit value="Register"></s:submit>
		</s:form>
	</div>
</body>
</html>