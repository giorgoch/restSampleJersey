 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
</head>
<body>
	<sf:form action="${pageContext.request.contextPath}/doCreate" method="Post" commandName="user">
	<table id="formtable" >
	<tr><td>Name:</td><td><sf:input   path="name" /><br><sf:errors cssClass="error" path="name" /></td></tr>
	<tr><td>Last Name:</td><td><sf:input path="lname"/><br><sf:errors cssClass="error" path="lname" /></td></tr>	
	<tr><td>Address:</td><td><sf:input path="address"/><br><sf:errors cssClass="error" path="address" /></td></tr>
	<tr><td>Post Code:</td><td><sf:input path="postcode"/><br><sf:errors cssClass="error" path="postcode" /></td></tr>
	<tr><td>Tel:</td><td><sf:input path="tel"/><br><sf:errors cssClass="error" path="tel" /></td></tr>	
	<tr><td>City:</td><td><sf:input path="city"/><br><sf:errors cssClass="error" path="city" /></td></tr>
	<tr><td><input value="Register" type="submit" /></td></tr>	
	</table>
	</sf:form>
	

	
	</form>
</body>
</html> 