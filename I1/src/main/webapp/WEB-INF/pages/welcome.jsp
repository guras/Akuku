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

		<h1>${aaa}</h1><br/>
        <h1>Cześć ${personalities}</h1><br/><a href="<c:url value='j_spring_security_logout' />" > Logout</a>
		<h3>Zaraportuj co robiłeś w ${weeklyReport.week} tygodniu ${weeklyReport.year} roku:</h3>

		<form:form name="weeklyReport" modelAttribute="weeklyReport" action="save" method="POST">

			<form:label path="highlights">Highlights</form:label><br/>
			<form:textarea path="highlights"/><br/>
			<form:label path="lowlights">Lowlights</form:label><br/>
			<form:textarea path="lowlights" /><br/>

			<h2>Projekt:</h2>
			<c:forEach var="projectReport" items="projectReports" varStatus="loopNo" begin="0">

				<form:select path="projectReports[${loopNo.index}].project" items="${projects}" itemLabel="name" itemValue="id" />

				<form:select path="projectReports[${loopNo.index}].color">
					<form:options items="${colors}"></form:options>
				</form:select><br/>

				<form:label path="projectReports[${loopNo.index}].mainAchievements">mainAchievements</form:label><br/>
				<form:input path="projectReports[${loopNo.index}].mainAchievements"/><br/>
				<form:label path="projectReports[${loopNo.index}].doneLastWeek">doneLastWeek</form:label><br/>
				<form:input path="projectReports[${loopNo.index}].doneLastWeek"/><br/>
				<form:label path="projectReports[${loopNo.index}].nextSteps">nextSteps</form:label><br/>
				<form:input path="projectReports[${loopNo.index}].nextSteps"/><br/>
				<form:label path="projectReports[${loopNo.index}].edc">edc</form:label><br/>
				<form:input path="projectReports[${loopNo.index}].edc"/><br/>
				<form:label path="projectReports[${loopNo.index}].etc">etc</form:label><br/>
				<form:input path="projectReports[${loopNo.index}].etc"/><br/>
			</c:forEach>

			<input type="submit" value="Wyślij"/>
		</form:form>

	</body>
</html>