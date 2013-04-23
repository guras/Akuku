<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>Statusy raportów</title>	
	</head>
	<body>
		<h1>Statusy raportów wszystkich pracowników na obecny tydzień:</h1>
		<ol>
			<c:forEach var="reportStatus" items="${reportStatuses}">
				<li>${reportStatus.employee.fullName} - RAPORT<c:if test="${not reportStatus.reportDone}"> NIE</c:if> ZROBIONY</li>
			</c:forEach>
		</ol>
	</body>
</html>