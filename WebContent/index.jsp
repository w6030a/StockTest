<%@ page language="java" contentType="text/html; charset=BIG5"
	pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
	<hr />
	<div align="right">
		<a href="logout">logout</a>|
		<a href="register">register</a>|
		<a href="profile">profile</a>
	</div>
	
	<div align="center">
		<s:form action="loginAction">
			<s:textfield name="userName" label="Name"></s:textfield>
			<s:password name="password" label="Password"></s:password>
			<s:textfield name="email" label="Email"></s:textfield>
			<s:submit value="Login"></s:submit>
		</s:form>
	</div>
</body>
</html>