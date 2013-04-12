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
        <h1>Cześć ${personalities}</h1>
		<h3>Zaraportuj co robiłeś</h3>


	<a href="<c:url value='j_spring_security_logout' />" > Logout</a>
</body>
</html>
