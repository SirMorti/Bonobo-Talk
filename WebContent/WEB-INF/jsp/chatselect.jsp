<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
<meta charset="utf-8">
<title>Bonobo-Talk</title>
<script type="text/javascript">
var cp = "<%=request.getContextPath()%>";
</script>
<link rel="stylesheet" href="${cp}/static/Styles/Style.css">
<link rel="stylesheet" href="${cp}/static/Styles/Colors.css">
<link rel="stylesheet" type="text/css" href="${cp}/static/Styles/Chatselect.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="${cp}/static/Scripts/functions.js"></script>
<script src="${cp}/static/Scripts/chatselect.js" type="text/javascript"></script>
</head>
<body>
	<div id="mainContainer">
        <div id="navContainer">
        	<div id="logo"><img src="${cp}/static/Pictures/NewLogo.png" alt="LOGO"/></div>
            <div id="accNlogin">
                <div id="settings">  	
                    <img src="${cp}/static/Pictures/Settings.png" alt="Settings"/>
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
        		<div id="chatOverview">
					<h2>Wähle einen Chat aus:</h2>
					<ul id="treeView">
						<li>
							<c:forEach items="${Categories}" var="category">
                            <div class="subTreeCap" >${category}</div>
							<ul class="subTree">
							    <c:forEach items="${Chatrooms}" var="chatroom">
								    <c:if test="${chatroom.category == category }">
									<li>
									    <form action="joinChatroom" method="post">
					                       <input type="hidden" name="chatroomId" value="${chatroom.id}" >
					                       <input id="sendForm" type="submit" value="${chatroom.chatroomname}"/>
					                       <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />                                
					                    </form>
					                </li>
					                </c:if>
							    </c:forEach>
							</ul>
							</c:forEach>
						</li>
					</ul>
				</div>
            </div>
    	</div>
        <div id="footer">
        </div>
    </div>
</body>
</html>