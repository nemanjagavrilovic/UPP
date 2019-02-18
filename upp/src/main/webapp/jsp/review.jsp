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
	src="${pageContext.request.contextPath}/js/review.js"> </script>
	
	</head>
	<body>
	<c:import url="_navbar.jsp"></c:import>
	<c:if test="${empty loggedUser }">
		<c:redirect url="/jsp/login.jsp"/>
	</c:if>
		<div id="content" class="container">
			<div class="row">
				<div class="col-md-6">
					<input type="hidden" value="${task.taskId}">
					<a class="btn btn-info" href='http://localhost:8081/data/${article.filename}' target='_blank' id='download'>Download</a>
					<div class="form-group">
						<label>Suggestion:</label>
						<select id="suggestion" class="form-control">
				 			<option value="accept">Accept</option>
							<option value="accept_with_rework">Accept with rework</option>
							<option value="accept_with_big_rework">Accept with big rework</option>
							<option value="reject">Reject</option>
					   </select>
				   </div>
				   <div class="form-group">
				   		<label>Comment for editor:</label>
				   		<textarea rows="10" cols="20" class="form-control" id="comment_for_editor"></textarea>
				   </div>
				   <div class="form-group">
				   		<label>Comment for author:</label>
					   	<textarea class="form-control" rows="10" cols="20" id="comment_for_author"></textarea>
				   </div>
				   <input type="button" class="btn btn-primary" id="complete" value="Complete">
				   <input type="hidden" id="task" value="${task.taskId}">
			   </div>
	   </div>
	</div>
	</body>
</html>