<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
	<head>
		<title>Bonobo-Talk</title>
		<script>
		var cp = "<%=request.getContextPath()%>";
		var username = "${User.username}"
		</script>
		<link rel="stylesheet" href="${cp}/static/Styles/Style.css">
		<link rel="stylesheet" href="${cp}/static/Styles/Navigation.css">
		<link rel="stylesheet" href="${cp}/static/Styles/Colors.css">
		<link rel="stylesheet" href="${cp}/static/Styles/Imprint.css">
		<script src="${cp}/static/Scripts/jquery-2.2.1.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="${cp}/static/Scripts/functions.js"></script>
	</head>
	<body>
	<div id="mainContainer">
        <div id="navContainer">
        	<div id="logo"><img src="${cp}/static/Pictures/NewLogo.png" alt="LOGO"/></div>
        	<c:if test="${User != null }">
            <div id="accNlogin">
                <div id="settings">     
                    <img src="${cp}/static/Pictures/Settings.png" alt="Settings"/>
                    <div id="drdwSettings"></div>
                </div>
                <div id="accWrapper" style="overflow: hidden; height: 100%;">
                    <div id="account">
                        <img id="profilePic" src="${cp}/static/Pictures/Default.jpg" alt="ProfilePic"/>
                        <span id="helper"></span>
                        <a id="accLink" href="">Username</a>        
                    </div>
                </div>
            </div>
            <div id="navigation"></div>            
            </c:if>
        </div>
        <div id="contentContainer">
        	<div id="content">
				<label id="ImprintHead">Impressum</label><br/><br/>
				
				<label>Mittelstufenprojekt</label><br/>
				<label>Bonobo-Talk</label><br/><br/>
				
				<label>Musterfirma GmbH &amp; Co KG</label><br/>
				<label>Musterstr. 1</label><br/>
				<label>D-28217 Bremen, Germany</label><br/><br/>
				
				<label>Inhaltlich Verantwortlicher gemäß § 10</label><br/>
				<label>Absatz 3 MDStV: Max Mustermann(Anschrift wie oben)</label><br/><br/>
				
				<label>Haftungshinweis: Wir übernehmen keine Haftung</label><br/>
            	<label>für die Inhalte externer Links. Für den Inhalt</label><br/>
            	<label>der externen Seiten sind ausschließlich deren</label><br/>
            	<label>Betreiber verantwortlich.</label>
            </div>
    	</div>
        <div id="footer">
        </div>
    </div>
</body>
</html>