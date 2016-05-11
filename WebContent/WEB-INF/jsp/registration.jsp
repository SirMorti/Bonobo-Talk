<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
<script type="text/javascript">var cp = "<%=request.getContextPath()%>";</script>
<meta charset="utf-8">
<title>Bonobo-Talk</title>
<link rel="stylesheet" href="${cp}/static/Styles/Style.css">
<link rel="stylesheet" href="${cp}/static/Styles/Registration.css">
<link rel="stylesheet" href="${cp}/static/Styles/Colors.css">
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.1.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/bootstrap/3.3.6/bootstrap.js"></script>
<script src="${cp}/static/Scripts/jquery-validate.bootstrap-tooltip.js"></script>
<script src="${cp}/static/Scripts/functions.js"></script>
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
					<form:form method="POST" modelAttribute="User" name="myForm" commandName="User">
						<form:input type="hidden" path="id" id="id"/>
						<p><form:input class="textInput1" path="username" id="username" placeholder="Username, min 3-15 characters" name="username" required="required"/></p>
						<p><form:errors path="username" cssClass="error"/></p>
						<p><form:input class="textInput1" type="password" path="password" id="password" name="password" placeholder="Password, min 5 characters" required="required"/></p>
						<p><form:errors class="textInput1" path="password" cssClass="error"/></p>
						<p><form:input class="textInput1" path="email" id="email" name="email" placeholder="Valid E-Mail required" required="required"/></p>
						<p><form:errors path="email" cssClass="error"/></p>
						<p><form:input class="textInput1" path="firstname" id="firstname" name="firstname" placeholder="Vorname" required="required"/></p>
						<p><form:errors path="firstname" cssClass="error" /></p>
						<p><form:input class="textInput1" path="lastname" id="lastname" name="lastname" placeholder="Nachname" required="required"/></p>
						<p><form:errors path="lastname" cssClass="error"/></p>
						<p><form:input class="textInput1" path="gender" id="gender" placeholder="Geschlecht"/></p>
						<p><form:input class="textInput1" path="dateOfBirth" id="dateOfBirth" name="dob" placeholder="dd/mm/yyyy" required="required"/></p>
						<p><form:errors path="dateOfBirth" cssClass="error"/></p>
						<p><form:input class="textInput1" path="userpicture" id="userpicture"/></p>
						<p><form:errors path="userpicture" cssClass="error"/></p>
						<p style="font-size: 11px;">Mit der Registrierung stimmen Sie den Datenschutzbestimmungen<br>
                            und Nutzungsbedingungen zu.</p>
						<p>
							<c:choose>
								<c:when test="${edit}">
									<input id="regSubmit" type="submit" value="Update" />
								</c:when>
								<c:otherwise>
									<input id="regSubmit" type="submit" value="Register"  />
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
