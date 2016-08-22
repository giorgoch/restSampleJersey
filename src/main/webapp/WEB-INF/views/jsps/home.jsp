<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" /> --%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index Page</title>
</head>
<body>
	<p>Hi there this is a demo version of jersey WebServices.
	<ul style="list-style-type: none">
		<li>I have implement 2 functions for retriving a user and a list
			of users.</li>
		<li>you can retrieve all users by adding on the url as Json</li><br>
		<a href="http://localhost:8080/projectClient/webservice/user/Json">
			<Strong>http://localhost:8080/projectClient/webservice/user/Json</Strong> 
		</a>in Json format.
		</br>
		<li>you can retrieve all users by adding on the url as Xml <br></li>
		<a href="http://localhost:8080/projectClient/webservice/user/Xml">
			<Strong>http://localhost:8080/projectClient/webservice/user/Xml</Strong>  
		</a>in XML format.
		</br>
		<li>and you can retrieve one user with user id where {userid}=
		the number of the user 1.2.3...
		</li>
		<a
			href="http://localhost:8080/projectClient/webservice/user/Json/{userid}">
			<strong>http://localhost:8080/projectClient/webservice/user/Json/{userid}</strong>
		</a> in json format
		</br>
		<a href="http://localhost:8080/projectClient/webservice/user/Json/{userid}">
			<strong>http://localhost:8080/projectClient/webservice/user/Json/{userid}</strong>
		</a> in Xml format
	</ul>

	<p>
		The users listed are
		<ol type="1">
		<li>Alladin, The Thief, Persia 3, 12345, Persia 123456789 </li> <br>
		<li> Lucky, Luke, Texas, 74185, El paso, 000000000 </li><br>
		<li>Marty, Martian, Mars 8, 00000, Mars, 7777777777</li> <br> 
		<li>Zeus, The Olympian, Mount Olympos, 56789, Olympos, 99999999 </li>
		</ol>
		 <br>
</body>
</html>