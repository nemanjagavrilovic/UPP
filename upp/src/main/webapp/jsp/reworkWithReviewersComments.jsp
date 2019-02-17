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
	src="${pageContext.request.contextPath}/js/reworkWithComments.js"> </script>
	</head>
<title>Insert title here</title>
</head>
<body>
<c:import url="_navbar.jsp"></c:import>
	<c:forEach items="${article.commentsForAuthors}" var="comment">
		<p>comment</p><br/>
	</c:forEach>
	<input type='file'  onchange='openFile(event)'><br>
	<textarea id="whatIdid"></textarea>
	<input type="button" value="Submit" id="btnSubmit" />
	<input type="hidden" id="task" value="${task.taskId}">
</body>
</html>