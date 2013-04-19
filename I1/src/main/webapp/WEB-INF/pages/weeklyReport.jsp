<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<style type="text/css">
			body {
				font-family: Calibri;
				font-size: 11pt;
			}
			
			p, li {
				margin: 5pt;
			}
			
			.title, .lowlights, .highlights, .projects, .team {
				font-weight: bold;
				font-size: 14pt;
			}
			
			.lowlights, .highlights, .projects, .projectName, .team {
				margin: 10pt, 0pt;
			}
			
			.title {
				font-family: Tahoma;
				text-align: center;
				color: #993366;
				padding-bottom: 30pt;
				line-height: 30pt;
			}
			
			.lowlights {
				color: #FF0000;
			}
			
			.highlights {
				color: #32CD32;
			}
			
			.team {
				color: #48D1CC;
			}
			
			.projectName {
				font-weight: bold;
				text-decoration: underline;
				margin-top: 15pt;
			}
			
			.image {
				margin-top: 50pt;
			}
		</style>
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
		
		<br/>
		
		<h3 class="team">Team:</h3>
		
		<p>
			Available Engineers:
			
			<c:forEach var="engineer" varStatus="status" items="${report.availableEngineers}">
				${engineer.fullName}<c:if test="${not status.last}">, </c:if> 
			</c:forEach> 
		</p>
		
		<img class="image" src="<c:url value="/images/report_colors.png"/>"/>		
	</body>
</html>