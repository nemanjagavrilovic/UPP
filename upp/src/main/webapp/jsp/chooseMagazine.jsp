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
	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/chooseMagazine.js"> </script>
	
	</head>
	<c:import url="_navbar.jsp"></c:import>
	<c:if test="${empty loggedUser }">
		<c:redirect url="/jsp/login.jsp"/>
	</c:if>
	<body>
	
		<div id="content" class="container">
			<div class="row">
				<div class="panel panel-default col-md-6">
					<div class="panel-heading"><label>Choose magazine:</label></div>
					<div class="panel-body">
						<ul style="list-style-type:none;">
							<c:forEach var="magazine" items="${magazines}" varStatus="loop">
								<li>
									<a href="../magazines/chooseMagazine/${magazine.id}/${task.taskId}" id="magazine">${magazine.title}</a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>