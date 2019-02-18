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
	src="${pageContext.request.contextPath}/js/rework.js"> </script>
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
			<div class="col-md-6">
				<c:forEach items="${article.commentsForAuthors}" var="comment">
					<label>${comment}</label><br/>
				</c:forEach>
				<input type='file'  onchange='openFile(event)'><br>
				<input type="button" class="btn btn-primary" value="Submit" id="btnSubmit" />
				<input type="hidden" id="task" value="${task.taskId}">
							
			
			</div>
		
		</div>
	</div>

</body>
</html>