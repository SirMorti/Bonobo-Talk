<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />

<html>
<head>
<script>
var cp = "<%=request.getContextPath()%>";
var chatroomId = "${Chatroom.id}";
var username = "${User.username}"
</script>
<link rel="stylesheet" href="${cp}/static/Styles/Chat.css">
<link rel="stylesheet" href="${cp}/static/Styles/Style.css">
<link rel="stylesheet" href="${cp}/static/Styles/Navigation.css">
<link rel="stylesheet" href="${cp}/static/Styles/Colors.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${cp}/static/Scripts/functions.js"></script>
</head>
<body ng-app="chatApp">
	<div id="mainContainer">
	   <div id="navContainer">
	       <div id="logo"><img src="${cp}/static/Pictures/NewLogo.png" alt="LOGO"/></div>
	       <div id="accNlogin">
	           <div id="settings">     
	               <img src="${cp}/static/Pictures/Settings.png" alt="Settings"/>
	                   <!--div id="drdwSettings"></div-->
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
	   </div>
	       <div id="contentContainer">
	           <div id="content">
	               <div ng-controller="ChatCtrl" class="container" id="chatContainer">
                    <h2>${Chatroom.chatroomname }</h2>
                    <div id="output">
                        <p ng-repeat="message in messages | orderBy:'time':false" class="message">
                            <time class="time">{{message.time | date:'HH:mm'}}</time>
                            <span class="author">{{message.author}}</span>                                
                            <span ng-class="{self: message.self}">{{message.message}}</span>
                        </p>    
                    </div>
                    <div id="formWrapp">
                        <form ng-submit="addMessage()" name="messageForm">
                            <input type="text" placeholder="Write a message..." ng-model="message" />
                            <div class="info">
                                <span class="count" ng-bind="max - message.length" ng-class="{danger: message.length > max}">140</span>
                                <button id="sendButton" ng-disabled="message.length > max || message.length === 0">Send</button>
                            </div>
                        </form>
                    </div>
                </div>
	           </div>
	       </div>
	   <div id="footer"></div>
	</div>
	<script src="${cp}/static/Scripts/stomp.js"></script>
	<script src="${cp}/static/Scripts/sockjs-0.3.js"></script>
	<script src="${cp}/static/Scripts/angular.min.js"></script>
	<script src="${cp}/static/Scripts/lodash.min.js"></script>          
	<script src="${cp}/static/Scripts/app.js" type="text/javascript"></script>
	<script src="${cp}/static/Scripts/controllers.js" type="text/javascript"></script>
	<script src="${cp}/static/Scripts/services.js" type="text/javascript"></script>
</body>
</html>