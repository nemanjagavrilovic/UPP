<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/finalDecision.js"> </script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/generateFormFields.js"> </script>
	</head>
	<body>
	<c:import url="_navbar.jsp"></c:import>
	<c:if test="${empty loggedUser }">
		<c:redirect url="/jsp/login.jsp"/>
	</c:if>
		<div id="content" class="container">
			<div class="row">
				<div class="col-md-6">
					<label>Title : ${article.title}</label><br>
					<label>Abstract : ${article.abstracts}</label><br>
					<label>Keywords : ${article.keywordsToString()}</label><br>
					<a class="btn btn-info" href='http://localhost:8081/data/${article.filename}' target='_blank' id='download'>Download</a>
		
					<div class="form-group">
						<label>Comment:</label>
						<textarea rows="10" cols="20" class="form-control" id="comment"></textarea> 
					</div>
			    </div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label>Comment for authors:</label><br>
					<c:forEach items="${article.commentsForAuthors}" var="comment">
						<label>${comment}</label>
					</c:forEach>
				</div>
				<div class="col-md-4">
					<label>Comment for editor:</label><br>
					<c:forEach items="${article.commentsForEditors}" var="comment">
						<label>${comment}</label>
					</c:forEach>
				</div>
				<div class="col-md-4">
					<label>Suggestion:</label><br>
					<c:forEach items="${article.suggestion}" var="suggestion">
						<label>${suggestion}</label>
					</c:forEach>
				</div>
				<div style="margin-top:50px">
					<input type="button" class="btn btn-danger" value="Reject" id="reject">
					<input type="button" class="btn btn-success" value="Accept" id="accept">
					<input type="button" class="btn btn-primary" value="Send to rework" id="sendToRework">
					<input type="button" class="btn btn-primary" value="Send to review" id="sendToReview">
					<input type="hidden" value="${task.taskId}" id="task">
				</div>
			</div>
		</div>
	</body>
</html>