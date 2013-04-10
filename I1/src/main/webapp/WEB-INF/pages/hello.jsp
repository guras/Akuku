<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cześć</title>
    </head>
    <body>
        <h1>Cześć ${message}</h1>

		<table>
		<c:forEach var="user" items="${users}">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.enabled}</td>
		</tr>
		</c:forEach>
		</table>


	<a href="<c:url value='j_spring_security_logout' />" > Logout</a>
</body>
</html>
