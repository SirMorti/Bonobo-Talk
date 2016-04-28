<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
	<title>Bonobo-Talk</title>
	<link rel="stylesheet" href="${cp}/static/Styles/Style.css">
	<link rel="stylesheet" href="${cp}/static/Styles/Navigation.css">
	<link rel="stylesheet" href="${cp}/static/Styles/Colors.css">
	<link rel="stylesheet" href="${cp}/static/Styles/FAQ.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="${cp}/static/Scripts/faq.js"></script>
	<script src="${cp}/static/Scripts/jquery-2.2.1.min.js"></script>
	<!--script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script-->
	<script src="${cp}/static/Scripts/functions.js"></script>
</head>
<body>
	<div id="mainContainer">    
	    <div id="navContainer">
	        <c:if test="${User != null }">
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
	                        <a id="accLink" href="">Username</a>     	
	                    </div>
	                </div>
	            </div>
	            <div id="navigation"></div>
            </c:if>
	    </div>
        <div id="contentContainer">
        	<div id="content">
        		<div id="mainblock">
					<div class="faqWrapper">
						<div class="header">Was ist Bonobo-Talk?</div>
						<ul class="drpdwnArticle">
							<li class="article-list">Was ist Bonobo-Talk?</li>
							<!--Eventuell sich öffnende Textfelder, die Begriffserklärungen beinhalten(Textform)-->
							<li class="article-list">Was kann Bonobo-Talk?</li>
							<li class="article-list">Wie kann ich ein Profil erstellen?</li>
						</ul>
					</div>
					<div class="faqWrapper">
						<div class="header">Startschwierigkeiten</div>
						<ul class="drpdwnArticle">
							<li class="article-list">Wie fange ich an?</li>
							<li class="article-list">Mit wem kann ich chatten?</li>
							<li class="article-list">Ich finde keine Leute. Was nun?</li>
						</ul>
					</div>
					<div class="faqWrapper">
						<div class="header">Chats</div>
						<ul class="drpdwnArticle">
							<li class="article-list">Wie erstelle ich einen Chat?</li>
							<li class="article-list">Wie kann ich mich mit meinen Freunden verbinden?</li>
							<li class="article-list">Wie kann ich mit Unbekannten chatten?</li>
						</ul>
					</div>
					<div class="faqWrapper">
						<div class="header">Einstellungen</div>
						<ul class="drpdwnArticle">
							<li class="article-list">Was für Einstellungen kann ich vornehmen?</li>
							<li class="article-list">Kann ich bevorzugte Chatthemen einstellen?</li>
							<li class="article-list">Wie kann ich einen Chat verwalten?</li>
						</ul>
					</div>
					<div class="faqWrapper">
						<div class="header">Profil</div>
						<ul class="drpdwnArticle">
							<li class="article-list">Was kann ich mit meinem Profil machen?</li>
							<li class="article-list">Wie kann ich mein Profil einrichten?</li>
							<li class="article-list">Wie kann ich die Profile meiner Freunde finden?</li>
						</ul>
					</div>
				</div>
				<div id="rightContent">
				    <div>
			           <form id="search" method="post" action="showTicket">
			               <label>Suche</label>        <input type="text" name=betreff value="" class="textInput2">
			               <input id="sendForm" type="submit" value="Senden"/>
			               <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
			           </form>
			        </div>  
				    <table>
		                 <c:forEach items="${faqItems}" var="faqItem">
		                    <tr>
		                        <td>Betreff:</td><td>${faqItem.betreff }</td>
		                    </tr>
		                    <tr>
		                        <td>Inhalt:</td><td>${faqItem.inhalt }</td>
		                    </tr>
		                    <tr>
		                        <td>Kontakt:</td><td>${faqItem.getKontakt().e_mail }</td>
		                    </tr>
		                </c:forEach>
		           </table>		           
                   <div><a href = "contact">Neuen FAQ-Eintrag erstellen</a></div>
				</div>
            </div>
    	</div>
		<div id="footer">
        </div>
	</div>
</body>
</html>