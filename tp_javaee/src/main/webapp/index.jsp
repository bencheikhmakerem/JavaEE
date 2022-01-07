<%@page import="org.makerem.model.Commune" %>>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>commune</title>
</head>
<body>
<h1> Hello Commune </h1>
	<%Commune commune =  (Commune) request.getAttribute("commune");%>
	<p> ID : <%=commune.getId() %>
	<p> ID : <%=commune.getName() %>
</body>
</html>