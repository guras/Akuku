<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Report By Employee</title>
	</head>
	<body>
		<h1 class="title">Weekly report by <br/>Week ${report.week}/${report.year}</h1>
		
		<h3 class="lowlights">Lowlights</h3>
		
		${report.highlightsLowlights}
				
		<br/>
		
		<h3 class="highlights">Highlights</h3>
		
		${report.highlightsLowlights}
				
		<br/><br/>
		
		<h3 class="projects">Projects:</h3>
		
		<c:forEach var="projects" items="${report.projectReports}" >
			<h4 class="projectName" style="background-color: ${projectSummary.color};">${projectSummary.projectName}</h4>
			
			<ul>
				<li>
					<c:forEach var="projectReport" varStatus="status" items="${projectSummary.projectReports}">
						${projectReport.employee.fullName}<c:if test="${not status.last}">, </c:if>
					</c:forEach> 
				</li>
				
				<li>
					Main achievements:<br/>
					<c:forEach var="projectReport" items="${projectSummary.projectReports}">
						${projectReport.mainAchievements}<br/>
					</c:forEach> 
				</li>
				
				<li>
					Done last week:<br/>
					<c:forEach var="projectReport" items="${projectSummary.projectReports}">
						${projectReport.doneLastWeek}<br/> 
					</c:forEach> 
				</li>
				
				<li>
					Next steps:<br/>
					<c:forEach var="projectReport" items="${projectSummary.projectReports}">
						${projectReport.nextSteps}<br/> 
					</c:forEach> 
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
	</body>
</html>