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
<link rel="stylesheet" href="${cp}/static/Styles/Home.css">
<link rel="stylesheet" href="${cp}/static/Styles/Style.css">
<link rel="stylesheet" href="${cp}/static/Styles/Navigation.css">
<link rel="stylesheet" href="${cp}/static/Styles/Colors.css">
<link rel="stylesheet" type="text/css" href="${cp}/static/Styles/Popuplogin.css">
<script src="${cp}/static/Scripts/jquery-2.2.1.min.js"></script>
<!--script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script-->
<script src="${cp}/static/Scripts/functions.js"></script>
</head>
<body>
	<div id="mainContainer">
        <div id="navContainer">
        	<div id="logo"><img src="${cp}/static/Pictures/NewLogo.png" alt="LOGO"/></div>
            <div id="accNlogin">
                <div id="settings">  	
                    <img src="${cp}/static/Pictures/Settings.png" alt="Settings"/>
                   	<div id="drdwSettings"></div>
                </div>
                <div id="accWrapper" style="overflow: hidden; height: 100%;">
                    <div id="account">
                        <img id="profilePic" src="${cp}/static/Pictures/Default.jpg" alt="ProfilePic"/>
                        <span id="helper"></span>
                        <a id="accLink" href="profile">${User.username}</a>     	
                    </div>
                </div>
            </div>
            <div id="navigation"></div>
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
</body>
</html>
