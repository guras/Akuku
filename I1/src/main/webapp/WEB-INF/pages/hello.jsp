
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
        <title>Cześć</title>
    </head>
    <body>
        <h1>Cześć ${personalities}</h1><br/><a href="<c:url value='j_spring_security_logout' />" > Logout</a>
		<h3>Zaraportuj co robiłeś:</h3>

		<form:form name="weeklyReport" action="" method="POST">
			<form:select path="">
				<c:forEach items="projects" var="project">
					<form:option label="${project}" value="${project}"></form:option>
				</c:forEach>
			</form:select>
		</form:form>
		
		
		
		
		<form action="" method="POST" class="">
			

			<label for="mainAchievements">Main achievements:</label><br/>
			<textarea name="mainAchievements"></textarea><br/>
			<label for="doneLastWeek">Done last week:</label><br/>
			<textarea name="doneLastWeek"></textarea><br/>
			<label for="nextSteps">Next steps:</label><br/>
			<textarea name="nextSteps"></textarea><br/>
		</form>


	</body>
</html>
