<%@page import="com.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table</title>
</head>
<body>
<h1>This shows the Database Table.</h1>
<hr>
<p>Welcome : ${activeUser}</p>
<hr>
<a href="logout">Click here to Logout</a>
<%List<User>uList=(List<User>)request.getAttribute("userList"); %>

<table align="center" width="100%" border="1">
<tr bgcolor="yellow">
<td>ID</td>
<td>FirstName</td>
<td>LastName</td>
<td>Username</td>
<td>Edit A Row</td>
<td> Delete A Row </td>
</tr>
<%for(User u:uList
		){%>
<tr bgcolor="skyblue">	
	<td><%=u.getId()%></td>
	<td><%=u.getFname()%></td>
	<td><%=u.getLname()%></td>
	<td><%=u.getUsername()%></td>
	<td>
	<form action="edit" method="post">
	<input type='hidden' name='id' value='<%=u.getId()%>'>
	<input type='submit' value="Edit">
	
	</form>
	
	</td>
	
	<td>
	<form action="delete" method='post'>
	<input type='hidden' name='id' value='<%=u.getId()%>'>
	<input type='submit' value='Delete'>
	</form>
</tr>
<%}%>
</table>
</body>
</html>