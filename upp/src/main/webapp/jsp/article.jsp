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
	src="${pageContext.request.contextPath}/js/article.js"> </script>
	</head>
	<body>
		
		<div id="content">
		<table>
			<tr>
				<td>
					<h1>${article.title}</h1>
				</td>
				<td>
					<a onclick="buy()">Buy article</a>
				</td>
			</tr>
		</table>
		</div>
	</body>
	<input type="hidden" id="issn" value="${article.magazine.issn }">
	<input type="hidden" id="title" value="${article.title }">
	
</html>