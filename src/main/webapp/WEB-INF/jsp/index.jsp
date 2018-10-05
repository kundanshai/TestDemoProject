<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="login" action="registration.jsp" method="POST">
<table>
<tr>
<td>User Name</td>
<td><input type="text" name="userName" placeholder="User Name"></td></tr>
<tr>
<td>Password</td>
<td><input type="text" name="pwd" placeholder="Password"></td></tr>
<tr>
<td colspan="2" ><input type="submit" value="Submit"/></td>
</tr>

</table>
</form>
</body>
</html>