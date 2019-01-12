var formFields;

window.onload = function () {
	$.ajax({
		url: '/login/',
		type: 'GET',
		success:function(response) {
			generateForm(response.formFields);
			$("#content").append('<input type="button" value="Login" onclick=login("'+response.taskId+'")>');
			formFields = response.formFields;
		}
	})
}

function generateForm (fields) {

	for(i=0; i<fields.length; i++) {
		if(fields[i].type.name == "string" ) {
			if(fields[i].id == "password")
				$("#content").append(fields[i].label+'<br/><input type="password" id="'+fields[i].id+'"><br/>');
			else
				$("#content").append(fields[i].label+'<br/><input type="text" id="'+fields[i].id+'"><br/>');
			
		}
	}
}
function login(taskId) {
	var data = JSON.stringify(getFormFields(formFields));
	$.ajax({
		url : '/login/post/'+taskId,
		type : 'POST',
		data : data,
		contentType : 'application/json',
		success:function(response) {
			
		}
	})
}
function getFormFields(formFields) {
	var data = new Array();
	formFields.forEach(element => {
		console.log(element);
		data.push({fieldId : element.id, fieldValue : $("#"+element.id).val()});
	});
	
	return data;
	
}