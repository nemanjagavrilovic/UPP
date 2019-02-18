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
	src="${pageContext.request.contextPath}/js/addCoauthor.js"> </script>
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
				<div class="col-md-6 text-center">
					<c:forEach var="field" items="${formFields}" varStatus="loop">
							<c:choose>
							    <c:when test="${field.type.name == 'string'}">
							    	<c:choose>
							    		<c:when test="${field.id == 'password'}">
							    			<div class="form-group">
					 							<label>${field.label}</label>
					 							<input type="password" class="form-control" id="${field.id}"><br/>
					 						</div>
							    		</c:when>
							    		<c:otherwise>
							    			<div class="form-group">
					    						<label>${field.label}</label>
					    						<input class="form-control" type="text" id="${field.id}"><br/>
					    					</div>
							    		</c:otherwise>
							    	</c:choose>
							        <br />
							    </c:when>
							    <c:when test="${field.type.name == 'boolean'}">
							    	<div>
				    					<label>	${field.label}</label>
				    					<input type="checkbox"  id="${field.id}"><br/>
				    				</div>
							    </c:when>    
							    <c:otherwise>
							      <br />
							    </c:otherwise>
							</c:choose>
						</c:forEach>
						<input class="btn btn-primary" type="button" value="Add" id="add">
						<input class="btn btn-primary" type="button" value="Skip" id="skip">
						<input class="btn btn-primary" type="hidden" id="task" value="${task.taskId}">
					</div>
				</div>
		</div>
	</body>
	<script type="text/javascript">

	$(document).on('click','#add',function() {
		var data = JSON.stringify(getFormFields());
		$.ajax({
			url : '/task/post/'+$("#task").val()+'/'+'addCoauthor',
			type : 'POST',
			data : data,
			contentType : 'application/json',
			async : false,
			success:function(response) {
				alert(response);
			}
		});
	})
	</script>
</html>