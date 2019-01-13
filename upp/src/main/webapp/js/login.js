var formFields;

window.onload = function () {
	$.ajax({
		url: '/login/',
		type: 'GET',
		success:function(response) {
			generateForm(response.formFields,"content");
			$("#content").append('<input id="login" type="button" value="Login" onclick=login("'+response.taskId+'")>');
			formFields = response.formFields;
		}
	})
}

function generateForm (fields,div) {

	for(i=0; i<fields.length; i++) {
		if(fields[i].type.name == "string" ) {
			if(fields[i].id == "password")
				$("#"+div).append(fields[i].label+'<br/><input type="password" id="'+fields[i].id+'"><br/>');
			else
				$("#"+div).append(fields[i].label+'<br/><input type="text" id="'+fields[i].id+'"><br/>');
			
		}
	}
}
function login(taskId) {
	var data = JSON.stringify(getFormFields(formFields));
	$.ajax({
		url : '/task/post/'+taskId+'/'+'login',
		type : 'POST',
		data : data,
		contentType : 'application/json',
		async : false,
		success:function(response) {
			$.ajax({
				url : '/login/login',
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(getUsername(getFormFields(formFields))),
				success : function(response) {
					if( response != "") {
						window.top.location = '../task/tasks';
					}
				}
			})
			$("#login").attr("onclick",'login("'+response.taskId+'")');
		}
	});
}

function getUsername(data) {
	var user;
	user = { username : data[0].fieldValue, password : data[1].fieldValue};
	return user;
}