<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
	<head>
		<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/chooseReviewers.js"> </script>
	</head>
<title>Insert title here</title>
</head>
<body>
<c:import url="_navbar.jsp"></c:import>
	<select id="byDistance">
		<c:forEach items="${byDistance}" var="reviewer">
			<option value="${reviewer.email}">${reviewer.firstName}&nbsp ${reviewer.lastName}</option>
		</c:forEach>
	</select>
	<select id="moreLikeThis">
		<c:forEach items="${moreLikeThis}" var="reviewer">
			<option value="${reviewer.email}">${reviewer.firstName}&nbsp ${reviewer.lastName}</option>
		</c:forEach>
	</select>
	<input type="button" value="Add" id="add">
	<input type="button" value="Remove" id="remove">
	<select id="chooseReviewer"></select>
	<input type="button" value="Complete" id="complete">
	<input type="hidden" id="task" value="${task.taskId}">
</body>
</html>