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
		<div id="content">
		<input type="hidden" value="${task.taskId}">
	
    	<select id="suggestion">
 			<option value="accept">Accept</option>
			<option value="accept_with_rework">Accept with rework</option>
			<option value="accept_with_big_rework">Accept with big rework</option>
			<option value="reject">Reject</option>
	   </select>
	   <textarea rows="" cols="" id="comment_for_editor"></textarea>
	   <textarea rows="" cols="" id="comment_for_author"></textarea>
	   <input type="button" id="complete" value="Complete">
	   <input type="hidden" id="task" value="${task.taskId}">
	</div>
	</body>
</html>