var formFields;

window.onload = function () {
	$.ajax({
		url: '/registration/',
		type: 'GET',
		success:function(response) {
			generateForm(response.formFields,"content");
			$("#content").append('<input id="registrate" type="button" value="Sign in" onclick=registrate("'+response.taskId+'")>');
			formFields = response.formFields;
		}
	})
}


function registrate(taskId) {
	var data = JSON.stringify(getFormFields(formFields));
	$.ajax({
		url : '/task/post/'+taskId+'/'+'signIn',
		type : 'POST',
		data : data,
		contentType : 'application/json',
		async : false,
		success:function(response) {
			if(response != "")
				$("#registrate").attr("onclick",'registrate("'+response.taskId+'")');
		}
	});
}

function getUser(data) {
	var user;
	user = { username : data[0].fieldValue, password : data[1].fieldValue};
	return user;
}