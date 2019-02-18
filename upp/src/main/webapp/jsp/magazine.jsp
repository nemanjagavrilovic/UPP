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
	src="${pageContext.request.contextPath}/js/magazine.js"> </script>
	
	</head>
	<body>
	<c:import url="_navbar.jsp"></c:import>
	<div class="container">
		<div class="row">
			<input type="hidden" id="magazineId" value="${paypalPlan.payPalId}">
			<a class="btn btn-danger" onclick="subscribe()">Subscribe</a>
			<a class="btn btn-info" onclick="buy()">Buy magazine</a>
			<div class="col-md-6">
				<input type="hidden" id="issn" value="${magazine.issn}">
				<label>Magazine articles:</label>
				<ul style="list-style-type:none;">
				<c:forEach items="${magazine.articles}" var="article">
					<c:if test="${article.saved == true}">
						<li>
							<a href='../articles/${article.id}'>${article.title }</a>
						</li>
					</c:if>
				</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	</body>
</html>