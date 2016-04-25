<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
<link rel="stylesheet" type="text/css" href="${cp}/static/Styles/Settings.css">
</head>
<body>
	<ul id="settingsList">
		<li><a href="">Profil bearbeiten</a></li>
		<li><hr></li>
        <li><a href="logout">Logout</a></li>
	</ul>
</body>
</html>
