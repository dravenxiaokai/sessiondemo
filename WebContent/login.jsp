<!-- login.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<form action="login" method="post">
		<h1>用户登录</h1>
		账号：<input type="text" name="userName"><br>
		密码：<input type="password" name="userPwd"><br>
		<input type="submit" value="登录">
	</form>
</body>
</html>