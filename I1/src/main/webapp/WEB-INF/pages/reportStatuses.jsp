<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<title>Statusy raportów</title>	
	</head>
	
	<body>
		<h1>Statusy raportów wszystkich pracowników na obecny tydzień:</h1>
		
		<ol>
			<c:forEach var="reportStatus" items="${reportStatuses}">
				<li>
					${reportStatus.employee.fullName} -
					<c:choose>
						<c:when test="${reportStatus.reportDone}">
							RAPORT ZROBIONY <a href="<c:url value="/reportByEmployee?employeeId=${reportStatus.employee.id}"/>">Podgląd</a>
						</c:when>
						<c:otherwise>RAPORT NIE ZROBIONY</c:otherwise>
					</c:choose> 
				</li>
			</c:forEach>
		</ol>
		
		<br/>
		
		<a href="<c:url value="/downloadReport"/>">Generuj raport tygodniowy</a>
	</body>
</html>