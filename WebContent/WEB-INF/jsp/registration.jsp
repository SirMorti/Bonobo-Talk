<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
<meta charset="utf-8">
<title>Bonobo-Talk</title>
<link rel="stylesheet" href="${cp}/static/Styles/Style.css">
<link rel="stylesheet" href="${cp}/static/Styles/Registration.css">
<link rel="stylesheet" href="${cp}/static/Styles/Colors.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
	<div id="mainContainer">
        <div id="navContainer">
        	<div id="logo"><img src="${cp}/static/Pictures/NewLogo.png" alt="LOGO"/></div>
        </div>
        <div id="contentContainer">
        	<div id="content">
				<fieldset id="registration">
					<legend>Registrierung</legend>
					<form:form method="POST" modelAttribute="User" ng-submit="ctrl.submit()" name="myForm" commandName="User">
						<form:input type="hidden" path="id" id="id"/>
						<p><form:input class="textInput1" path="username" id="username" placeholder="Username"/></p>
						<p><form:errors path="username" cssClass="error"/></p>
						<p><form:input class="textInput1" type="password" path="password" id="password" placeholder="Passwort"/></p>
						<p><form:errors class="textInput1" path="password" cssClass="error"/></p>
						<p><form:input class="textInput1" path="email" id="email" placeholder="E-Mail"/></p>
						<p><form:errors path="email" cssClass="error"/></p>
						<p><form:input class="textInput1" path="firstname" id="firstname" placeholder="Vorname"/></p>
						<p><form:errors path="firstname" cssClass="error" /></p>
						<p><form:input class="textInput1" path="lastname" id="lastname" placeholder="Nachname"/></p>
						<p><form:errors path="lastname" cssClass="error"/></p>
						<p><form:input class="textInput1" path="gender" id="gender" placeholder="Geschlecht"/></p>
						<p><form:input class="textInput1" path="dateOfBirth" id="dateOfBirth" placeholder="Geburtsdatum"/></p>
						<p><form:errors path="dateOfBirth" cssClass="error"/></p>
						<p><form:input class="textInput1" path="userpicture" id="userpicture"/></p>
						<p><form:errors path="userpicture" cssClass="error"/></p>
						<p style="font-size: 11px;">Mit der Registrierung stimmen Sie den Datenschutzbestimmungen<br>
                            und Nutzungsbedingungen zu.</p>
						<p>
							<c:choose>
								<c:when test="${edit}">
									<input id="regSubmit" type="submit" value="Update"/>
								</c:when>
								<c:otherwise>
									<input id="regSubmit" type="submit" value="Register" ng-disabled="myForm.$invalid"/>
								</c:otherwise>
							</c:choose>
						</p>
                        <p><a id="regBack" href="index">Zurück</a></p>
					</form:form>
				</fieldset>
            </div>
    	</div>
        <div id="footer">
        </div>
    </div>
</body>
</html>