<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hallo</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of accounts</h2>  
    <table>
        <tr>
            <td>NAME</td><td>Password</td><td>E-Mail</td><td>SSN</td><td></td>
        </tr>
        <c:forEach items="${Users}" var="user">
            <tr>
            
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            </tr>
        </c:forEach>
        <tr>
        <td>
        <a href="<c:url value='/login' />">login</a>
        </td>
        </tr>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Add New Account</a>
</body>
</html>