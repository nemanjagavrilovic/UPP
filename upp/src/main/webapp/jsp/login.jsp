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
	src="${pageContext.request.contextPath}/js/login.js"> </script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/generateFormFields.js"> </script>
	
	
	</head>
	<body>
	<c:import url="_navbar.jsp"></c:import>
		<div id="content">
			Username:<input type="text" id="username">
			Password:<input type="password" id="password">
			<input id="login" type="button" value="Login">
		</div>
		<a href="../jsp/registration.jsp">Sign in</a>
	</body>
</html>