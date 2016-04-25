<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
<link rel="stylesheet" type="text/css" href="${cp}/static/Styles/Navigation.css">
</head>
<body>
	<div id="navItems">
		<div><a class="navItem dynContentLink" href="startseite">HOME</a></div>
		<div><a class="navItem dynContentLink" href="chatselect">CHAT</a></div>
	</div>
</body>
</html>
