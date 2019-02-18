function getFormFields() {
	var data = new Array();
	data.push({fieldId : "firstName", fieldValue : $("#firstName").val()});
	data.push({fieldId : "lastName", fieldValue : $("#lastName").val()});
	data.push({fieldId : "email", fieldValue : $("#email").val()});
	data.push({fieldId : "country", fieldValue : $("#country").val()});
	data.push({fieldId : "city", fieldValue : $("#city").val()});
	data.push({fieldId : "addMore", fieldValue : $("#addMore").is(':checked')});
	
	return data;
	
}

$(document).on('click','#skip',function(){
	$.ajax({
		url:'../task/complete/'+$("#task").val(),
		type:'POST',
		async:false,
		success:function(response){
			window.top.location = '../../task/tasks';
		}
	})
})