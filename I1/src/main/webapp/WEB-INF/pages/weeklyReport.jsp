<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<jsp:include page="reportCSS.jsp"/>
	</head>
	
	<body>
		<h1 class="title">GSE/SDG Gdansk Team weekly report<br/>Week ${report.week}/${report.year}</h1>
		
		<h3 class="lowlights">Lowlights</h3>
		
		<c:forEach var="hl" items="${report.highlightsLowlights}">
			<p>- ${hl.lowlights}</p>
		</c:forEach>
		
		<br/>
		
		<h3 class="highlights">Highlights</h3>
		
		<c:forEach var="hl" items="${report.highlightsLowlights}">
			<p>- ${hl.highlights}</p>
		</c:forEach>
		
		<br/><br/>
		
		<h3 class="projects">Projects:</h3>
		
		<c:forEach var="projectSummary" items="${report.projectSummaries}" >
			<br/>
			<span class="projectName" style="background-color: ${projectSummary.color};">${projectSummary.projectName}:</span>
			
			<ul>
				<li>
					<c:forEach var="projectReport" varStatus="status" items="${projectSummary.projectReports}">
						${projectReport.employee.fullName}<c:if test="${not status.last}">, </c:if>
					</c:forEach> 
				</li>
				
				<li>
					Main achievements:
					<ul>
						<c:forEach var="projectReport" items="${projectSummary.projectReports}">
							<li>${projectReport.mainAchievements}</li>
						</c:forEach> 
					</ul>
				</li>
				
				<li>
					Done last week:
					<ul>
						<c:forEach var="projectReport" items="${projectSummary.projectReports}">
							<li>${projectReport.doneLastWeek}</li> 
						</c:forEach>
					</ul> 
				</li>
				
				<li>
					Next steps:
					<ul>
						<c:forEach var="projectReport" items="${projectSummary.projectReports}">
							<li>${projectReport.nextSteps}</li> 
						</c:forEach> 
					</ul>
				</li>
				
				<li>
					EDC:<br/>
					<c:forEach var="projectReport" varStatus="status" items="${projectSummary.projectReports}">
						${projectReport.edc}<c:if test="${not status.last}">, </c:if> 
					</c:forEach> 
				</li>
				
				<li>
					ETC:<br/>
					<c:forEach var="projectReport" varStatus="status" items="${projectSummary.projectReports}">
						${projectReport.etc}<c:if test="${not status.last}">, </c:if> 
					</c:forEach> 
				</li>
			</ul>
		</c:forEach>
		
		<h3 class="team">Team:</h3>
		
		<c:if test="${not empty report.availableEngineers}">
			<p>
				Available Engineers:
				
				<c:forEach var="engineer" varStatus="status" items="${report.availableEngineers}">
					${engineer.fullName}<c:if test="${not status.last}">, </c:if> 
				</c:forEach> 
			</p>
		</c:if>
		
		<img class="image" src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/images/report_colors.png"/>		
	</body>
</html>