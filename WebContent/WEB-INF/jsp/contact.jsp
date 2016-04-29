<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
	<head>
	<meta charset="utf-8">
	<title>Bonobo-Talk</title>
	<script type="text/javascript">var cp = "<%=request.getContextPath()%>";</script>
	<link rel="stylesheet" href="${cp}/static/Styles/Style.css">
	<link rel="stylesheet" href="${cp}/static/Styles/Navigation.css">
	<link rel="stylesheet" href="${cp}/static/Styles/Colors.css">
	<link rel="stylesheet" href="${cp}/static/Styles/Contact.css">
	<script src="${cp}/static/Scripts/jquery-2.2.1.min.js"></script>
	<!--script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script-->
	<script src="${cp}/static/Scripts/functions.js"></script>
	</head>
	<body>
		<div id="mainContainer">
			<div id="navContainer">
				<div id="logo"><img src="${cp}/static/Pictures/NewLogo.png" alt="LOGO"/></div>
				<c:if test="${User != null}">
					<div id="accNlogin">
						<div id="settings">  	
							<img src="${cp}/static/Pictures/Settings.png" alt="Settings"/>
							<div id="drdwSettings"></div>
						</div>
						<div id="accWrapper" style="overflow: hidden; height: 100%;">
							<div id="account">
								<img id="profilePic" src="${cp}/static/Pictures/Default.jpg" alt="ProfilePic"/>
								<span id="helper"></span>
								<a id="accLink" href="">${User.username}</a>     	
							</div>
						</div>
					</div>
					<div id="navigation"></div>
				</c:if>
			</div>
			<div id="contentContainer">
				<div id="content">
					<form id="contactFormular" method="post" action="contact">
						<fieldset id="formularField">
						<legend id="formularTop" style="font-weight: normal;">Kontakt</legend>
							<label id="letter">Ihre Daten</label><br/>
							
							<label>Anrede:</label>      <input type="radio" name="salutation" value="Herr" color="white" style="margin-right:5px"/>Herr<input type="radio" name="salutation" value="Frau" style="margin:0 5px 0 20px;"/>Frau<br/>
							<label>Name:</label>        <input type="text" name="name" value="" class="textInput2"><br/>
							<label>Vorname:</label>     <input type="text" name="firstName" value="" class="textInput2"><br/>
							<label>E-Mail:</label>      <input type="text" name="email" value="" class="textInput2"><br/><br/><br/>
							
							<label id="letter">Ihre Nachricht</label><br/>
							
							<label>Betreff:</label>     <input type="text" name="subject" value="" class="textInput2"><br/><br/>
							<label>Nachricht:</label>   <textarea name="message" cols="25" rows="5"></textarea><br/>
							<input id="sendForm" type="submit" value="Senden"/>
							<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
						</fieldset>
					</form>
				</div>
			</div>
			<div id="footer">
			</div>
		</div>
	</body>
</html>
