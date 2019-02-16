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
		<div id="content">
		Title : ${article.title}
		Abstract : ${article.abstracts}
		Keywords : ${article.keywordsToString()}
		<textarea rows="5" cols="20" id="comment"></textarea> 
		<c:forEach items="${article.comments}" val="comment">
			<p>${comment}</p>
		</c:forEach>
		<c:forEach items="${article.suggestion}" val="suggestion">
			<p>${suggestion}</p>
		</c:forEach>
		<input type="button" value="Reject" id="reject">
		<input type="button" value="Accept" id="accept">
		<input type="button" value="Send to rework" id="sendToRework">
		<input type="button" value="Send to review" id="sendToReview">
		<input type="hidden" value="${task.taskId}" id="task">
		</div>
	</body>
</html>