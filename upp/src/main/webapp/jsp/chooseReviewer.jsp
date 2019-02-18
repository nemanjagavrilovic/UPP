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
	<c:if test="${empty loggedUser }">
		<c:redirect url="/jsp/login.jsp"/>
	</c:if>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<select id="byDistance" style="width:200px;">
					<option>/</option>
					<c:forEach items="${byDistance}" var="reviewer">
						<option value="${reviewer.email}">${reviewer.firstName}&nbsp ${reviewer.lastName}</option>
					</c:forEach>
				</select><br>
				<select id="moreLikeThis" style="width:200px;">
					<option>/</option>
					<c:forEach items="${moreLikeThis}" var="reviewer">
						<option value="${reviewer.email}">${reviewer.firstName}&nbsp ${reviewer.lastName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-2">
				<input class="btn btn-primary" type="button" value="Add" id="add"><br>
				<input class="btn btn-danger" type="button" value="Remove" id="remove">
			</div>
			<div class="col-md-5" >
				<select id="chooseReviewer"style="width:200px;"></select>
			</div>
			<input type="hidden" id="task" value="${task.taskId}">
		</div>
		<div class="row" style="margin-top:30px;">
				<input type="button" class="btn btn-primary" value="Complete" id="complete">
		</div>
	</div>
</body>
</html>