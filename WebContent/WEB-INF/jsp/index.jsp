<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<html>
<head>
<script type="text/javascript">var cp = "<%=request.getContextPath()%>";</script>
<meta charset="utf-8">
<title>Bonobo-Talk</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${cp}/static/Scripts/functions.js"></script>
<link rel="stylesheet" href="${cp}/static/Styles/Home.css">
<link rel="stylesheet" href="${cp}/static/Styles/Style.css">
<link rel="stylesheet" href="${cp}/static/Styles/Navigation.css">
<link rel="stylesheet" href="${cp}/static/Styles/Colors.css">
<link rel="stylesheet" type="text/css" href="${cp}/static/Styles/Popuplogin.css">
</head>
<body>
	<div id="mainContainer">
        <div id="navContainer">
        	<div id="logo"><img src="${cp}/static/Pictures/NewLogo.png" alt="LOGO"/></div>
            <div id="accNlogin">
                <div id="loginButton"><a class="navItem" href="" id="loginLink">LOGIN</a></div>
            </div>
        </div>
        <div id="contentContainer">
        	<div id="content">
			<label id="Welcome">Willkommen bei Bonobo-Talk</label><br/>
			<label id="Welcome">Dem Webchat der so ist wie DU es willst.</label><br/><br/>
			<label id="MoreText">Registriere dich jetzt und chatte mit Leuten</label><br/>
			<label id="MoreText">die sich für genau dasselbe wie du interessieren,</label><br/>
			<label id="MoreText">denn bei Bonobo-Talk steht dir der Weg offen:</label><br/>
			<label id="MoreText">Erstelle <label id="extra">deinen ganz eigenen Chat</label> und triff gleichgesinnte.</label><br/><br/>
			<label id="MoreText">Ist das Affengeil? Nein, das ist <label id="extra">Bonobo-Talk!</label></label><br/><br/><br/>
			<label id="MoreText">Viel Spaß beim chatten wünscht:</label><br/>
			<label id="MoreText">Das Bonobo-Talk Team</label>
            </div>
    	</div>
        <div id="footer">
        </div>
    </div>
    <div id="popupContainer">
    	<div id="popupLogin">
	        <div id="loginInfo"></div>
	        <div id="loginFormContainer">
		        <div id="login">
	                <!--  div class="login-card">
	                    <div class="login-form"-->
	                        <c:url var="loginUrl" value="/login" />
	                        <form action="${loginUrl}" method="post" class="form-horizontal">
                                <h2>Anmelden</h2>
	                            <c:if test="${param.error != null}">
	                                <div class="alert alert-danger">
	                                    <p>Invalid username and password.</p>
	                                </div>
	                            </c:if>
	                            <c:if test="${param.logout != null}">
	                                <div class="alert alert-success">
	                                    <p>You have been logged out successfully.</p>
	                                </div>
	                            </c:if>
	                            <div class="input-group input-sm">
	                                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
	                                <input type="text" class="textInput1" id="username" name="username" placeholder="Enter Username" required>
	                            </div>
	                            <div class="input-group input-sm">
	                                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
	                                <input type="password" class="textInput1" id="password" name="password" placeholder="Enter Password" required>
	                            </div>
	                            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
	                                 
	                            <div class="form-actions">
	                                <input type="submit"
	                                    class="subLogSign" value="Log in">
	                            </div>
	                        </form>
	                    <!--/div>
	                </div-->
	                <fieldset id="registerLinkWrap">
                        <legend id="formularTop" style="font-size: 14px; font-weight: normal;">Noch kein Konto?</legend>
                        <a href="new">Registrierung</a>
                    </fieldset>
                </div>
            </div>
	    </div>
    </div>
</body>
</html>
