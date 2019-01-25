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
	src="${pageContext.request.contextPath}/js/task.js"> </script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"> </script>
	</head>
	<body>
		<div id="content">
		
		<c:forEach var="field" items="${formFields}" varStatus="loop">
				<c:choose>
				    <c:when test="${field.type.name == 'string'}">
				    	<c:choose>
				    		<c:when test="${field.id == 'password'}">
		 						${field.label}<input type="password" id="${field.id}"><br/>
				    		</c:when>
				    		<c:otherwise>
		    					${field.label}<input type="text" id="${field.id}"><br/>
				    		</c:otherwise>
				    	</c:choose>
				        <br />
				    </c:when>    
				    <c:otherwise>
				      <br />
				    </c:otherwise>
				</c:choose>
			</c:forEach>
		</div>
	</body>
</html>