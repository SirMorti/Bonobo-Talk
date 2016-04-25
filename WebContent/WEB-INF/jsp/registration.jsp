<!doctype html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "spring" uri = "http://www.springframework.org/tags" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request" />
<html>
<head>
<meta charset="utf-8">
<title>Bonobo-Talk</title>
<link rel="stylesheet" href="${cp}/static/Styles/Style.css">
<link rel="stylesheet" href="${cp}/static/Styles/Registration.css">
<link rel="stylesheet" href="${cp}/static/Styles/Colors.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</head>
<body>
	<div id="mainContainer">
        <div id="navContainer">
        	<div id="logo"><img src="${cp}/static/Pictures/NewLogo.png" alt="LOGO"/></div>
        </div>
        <div id="contentContainer">
        	<div id="content">
                 <div id="signup">
                    <div id="signupFormWrapp">
                       <form:form method="POST" modelAttribute="User" ng-submit="ctrl.submit()" name="myForm">
					        <form:input type="hidden" path="id" id="id"/>
					        <table>
					            <tr>
					                <td><label for="username">Username: </label> </td>
					                <td><form:input path="username" id="username"/></td>
					                <td><form:errors path="username" cssClass="error"/></td>
					            </tr>
					         
					            <tr>
					                <td><label for="password">Password: </label> </td>
					                <td><form:input type="password" path="password" id="password"/></td>
					                <td><form:errors path="password" cssClass="error"/></td>
					            </tr>
					     
					            <tr>
					                <td><label for="email">E-Mail: </label> </td>
					                <td><form:input path="email" id="email"/></td>
					                <td><form:errors path="email" cssClass="error"/></td>
					            </tr>
					            					            <tr>
					                <td><label for="firstname">Firstname: </label> </td>
					                <td><form:input path="firstname" id="firstname"/></td>
					                <td><form:errors path="firstname" cssClass="error"/></td>
					            </tr>
					            					            <tr>
					                <td><label for="lastname">Lastname: </label> </td>
					                <td><form:input path="lastname" id="lastname"/></td>
					                <td><form:errors path="lastname" cssClass="error"/></td>
					            </tr>
					            					            <tr>
					                <td><label for="gender">Gender: </label> </td>
					                <td><form:input path="gender" id="gender"/></td>
					                <td><form:errors path="gender" cssClass="error"/></td>
					            </tr>
					            					            					            <tr>
					                <td><label for="dateOfBirth">Date of birth: </label> </td>
					                <td><form:input path="dateOfBirth" id="dateOfBirth"/></td>
					                <td><form:errors path="dateOfBirth" cssClass="error"/></td>
					            </tr>
					            					            					            <tr>
					                <td><label for="userpicture">Picture: </label> </td>
					                <td><form:input path="userpicture" id="userpicture"/></td>
					                <td><form:errors path="userpicture" cssClass="error"/></td>
					            </tr>
					     
					            <tr>             
					            </tr>
					     
					            <tr>
					                <td colspan="3">
					                    <c:choose>
					                        <c:when test="${edit}">
					                            <input type="submit" value="Update"/>
					                        </c:when>
					                        <c:otherwise>
					                            <input type="submit" value="Register" ng-disabled="myForm.$invalid"/>
					                        </c:otherwise>
					                    </c:choose>
					                </td>
					            </tr>
					        </table>
					   </form:form>
                    </div>
                </div>
            </div>
    	</div>
        <div id="footer">
        </div>
    </div>
    <div id="popupContainer">
    </div>
</body>
</html>
