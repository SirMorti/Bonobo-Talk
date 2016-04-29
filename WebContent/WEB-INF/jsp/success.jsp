<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Confirmation Page</title>
</head>
<body>
    Nachricht : ${success}
    <br/>
    <br/>
    Gehe zurück zu <a href="<c:url value='index' />">Startseite</a>
    <span id="rdTimer"></span>
    <script type="text/javascript">
    	var timeout = 3;
    	setInterval(function(){
    		document.getElementById("rdTimer").innerHTML=timeout;
    		if(timeout == 0){
    			window.location.href = "index";
    		}else timeout--;
    	}, 1000)
    </script> 
</body>
 
</html>