<%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<body>
		<h1>GSE/SDG Gdansk Team weekly report<br/>Week ${report.week}/${report.year}</h1>
		
		<br/><br/>
		
		<h3>Lowlights</h3>
		
		<c:forEach var="hl" items="${report.highlightsLowlights}">
			<p>${hl.lowlights}</p>
		</c:forEach>
		
		<h3>Highlights</h3>
		
		<c:forEach var="hl" items="${report.highlightsLowlights}">
			<p>${hl.highlights}</p>
		</c:forEach>
		
		<br/><br/>
		
		<h3>Projects:</h3>
		
		<c:forEach var="projectSummary" items="${report.projectSummaries}">
			<h3>${projectSummary.projectName}</h3>
			<ul>
				<li>
					<c:forEach var="projectReport" items="${projectSummary.projectReports}">
						${projectReport.employee.fullName}, 
					</c:forEach> 
				</li>
				<li>
					<p>Main achievements:</p>
					<c:forEach var="projectReport" items="${projectSummary.projectReports}">
						${projectReport.mainAchievements}<br/>
					</c:forEach> 
				</li>
				<li>
					<p>Done last week:</p>
					<c:forEach var="projectReport" items="${projectSummary.projectReports}">
						${projectReport.doneLastWeek}<br/> 
					</c:forEach> 
				</li>
				<li>
					<p>Next steps:</p>
					<c:forEach var="projectReport" items="${projectSummary.projectReports}">
						${projectReport.nextSteps}<br/> 
					</c:forEach> 
				</li>
				<li>
					<p>EDC:</p>
					<c:forEach var="projectReport" items="${projectSummary.projectReports}">
						${projectReport.edc}, 
					</c:forEach> 
				</li>
				<li>
					<p>ETC:</p>
					<c:forEach var="projectReport" items="${projectSummary.projectReports}">
						${projectReport.etc}, 
					</c:forEach> 
				</li>
			</ul>
		</c:forEach>
		
		<br/><br/>
		
		<h3>Team:</h3>
		
		<p>
			Available Engineers:
			
			<c:forEach var="engineer" items="${report.availableEngineers}">
				${engineer.fullName}, 
			</c:forEach> 
		</p>		
		
		<br/><br/><br/>
		
		<img src="<c:url value="/images/report_colors.png"/>"/>
	</body>
</html>