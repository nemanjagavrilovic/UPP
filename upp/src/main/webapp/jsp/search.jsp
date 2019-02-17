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
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/search.js"></script>
	</head>
	<body>
	<c:import url="_navbar.jsp"></c:import>
		Search repository:
		<table id="simpleSearch" style="display:block;">
			<tr>
				<td>
					<select id="field">
						<option value="Title">Title</option>
						<option value="Text">Text</option>
						<option value="Abstracts">Abstracts</option>
						<option value="ScientificField">Scientific field</option>
						<option value="Keywords">Keywords</option>
						<option value="MagazineName">Magazine name</option>
						<option value="Author">Author</option>
					</select>
				</td>
				<td> 
			 		<select id="searchType">
						<option value="REGULAR">Regular</option>
						<option value="PHRASE">Phrase</option>
					</select>
				<td>
				<td>
					<div id="fields" style="display:block;">
						<input type="text" id="search">
					</div>
					<div id="authorSearch" style="display:none;">
						Name:<input type="text" id="authorName">
						Surname:<input type="text" id="authorSurname">
					</div>
				</td>
			</tr>
		</table>
		<div id="advancedSearchDiv" style="display:none;">
			<table id="advancedTable">
				<tr>
					<td>
						<select id="searchOption">
							<option value="AND">And</option>
							<option value="OR">Or</option>
						</select>
					</td>
					<td>
						<select id="fieldAdvaced">
							<option value="title">Title</option>
							<option value="text">Text</option>
							<option value="abstracts">Abstracts</option>
							<option value="scientificField">Scientific field</option>
							<option value="keywords">Keywords</option>
							<option value="magazineName">Magazine name</option>
							<option value="author">Author</option>
					  </select> 
					</td>
					<td>
						<select id="searchTypeAdvanced">
							<option value="REGULAR">Regular</option>
							<option value="PHRASE">Phrase</option>
						</select>
					</td>
					<td>
						<div id="fields" style="display:block;">
							<input type="text" id="searchAdvanced">
						</div>
						<div id="authorSearch" style="display:none;">
							Name:<input type="text" id="authorName">
							Surname:<input type="text" id="authorSurname">
						</div>
					</td>
					
				</tr>
				<tfoot>
					<tr align="right">
						<td></td>
						<td></td>
						<td></td>
						<td rowspan="5">
							<input type="button" value="Add" id="addField">
						</td>
					</tr>
				</tfoot>
				</table>
		</div>	
		<div id="result">
			
		</div>
		<input type="button" value="Search" id="searchButton" style="display:block;">
		<input type="button" value="Advanced search" id="advancedSearchButton" style="display:block;">
		<input type="button" value="Simple search" id="simpleSearchButton" style="display:none;">
		<input type="button" value="Search" id="boolSearchButton" style="display:none;">
		<input type="button" value="Search" id="searchButtonName" style="display:none;">
	</body>
</html>