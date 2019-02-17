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
$(document).on('click','#login',function(){
	data = JSON.stringify({
		username: $("#username").val(),
		password: $("#password").val()
	})
	$.ajax({
		url:'/login/login',
		type:'POST',
		data:data,
		contentType:'application/json',
		success:function(response){
			if(response != "") {
				window.top.location = '../task/tasks';
			}
		}
	})
})
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
						window.top.location = '../magazines/';
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