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
	src="${pageContext.request.contextPath}/js/createPlan.js"> </script>
	
	</head>
	<body>
	<c:import url="_navbar.jsp"></c:import>
	Magazines : <select id="planMagazine">
		<c:forEach items="${magazines}" var="magazine">
			<option value="${magazine.id}">${magazine.title}</option>
		</c:forEach>
	</select>
	Plan description:<input type="text" id="planDescription">
	Plan currency<input type="text" id="planCurrency">
	Plan Frequency<select id="planFrequnecy">
		<option value="Day">Day</option>
		<option value="Week">Week</option>
		<option value="Month">Month</option>
		<option value="Year">Year</option>
	</select>
	Plan return url<input type="text" id="planReturnUrl">
	Plan cancel url<input type="text" id="planCancelUrl">
	<input type="button" value="Create" id = "createPlan">
	
	</body>
</html>