<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
</head>
<body>
	<ul>
		<li><a class="dynContentLink" href="imprint">Impressum</a></li>
		<li><a class="dynContentLink" href="contact">Kontakt</a></li>
		<li><a class="dynContentLink" href="faq">FAQ</a></li>
	</ul>
</body>
</html>