<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<jsp:include page="reportCSS.jsp"/>
		<title>Report By Employee</title>
	</head>
	<body>
		<a href="#" onclick="window.history.back();">Powrót</a>
			
		<h1 class="title">Weekly report by ${report.user.firstname} ${report.user.lastname}<br/>Week ${report.week}/${report.year}</h1>
		
		<h3 class="lowlights">Lowlights</h3>
		
		${report.lowlights}
				
		<br/>
		
		<h3 class="highlights">Highlights</h3>
		
		${report.highlights}
				
		<br/><br/>
		
		<h3 class="projects">Projects:</h3>
		
		<c:forEach var="projectReport" items="${report.projectReports}">
			<br/>
			<span class="projectName" style="background-color: ${projectReport.color};">${projectReport.project.name}</span>
						
			<ul>
				<li>
					Main achievements:<br/>${projectReport.mainAchievements}<br/>
				</li>
				
				<li>
					Done last week:<br/>${projectReport.doneLastWeek}<br/> 
				</li>
				
				<li>
					Next steps:<br/>${projectReport.nextSteps}<br/> 
				</li>
				
				<li>
					EDC:<br/>${projectReport.edc} 
				</li>
				
				<li>
					ETC:<br/>${projectReport.etc} 
				</li>
			</ul>
		</c:forEach>
	</body>
</html>