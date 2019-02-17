<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/home.js"> </script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
	</head>
	<body>
	<c:import url="_navbar.jsp"></c:import>
		<a href="../paypalPlan/">Create subscription plan</a>
		<a href="../jsp/search.jsp">Search</a>
		
		<div id="content">
			<ul>
				<c:forEach var="task" items="${tasks}" varStatus="loop">
					<li>
						<a href="../../task/${task.taskId}">${task.name}</a>
					</li>
				</c:forEach>
			</ul>
			<ul>
				<c:forEach var="task" items="${candidate}" varStatus="loop">
					<li>
						<a href="../../task/${task.taskId}">${task.name}</a>
						<a href="../../task/claim/${task.taskId}">Claim</a>
						
					</li>
				</c:forEach>
			</ul>
		</div>
		<a href="../task/startProcess/">Add article</a>
	</body>
</html>