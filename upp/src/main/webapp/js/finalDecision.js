$(document).on('click','input[type="button"]',function(){
	alert($(this).attr('id'));
	var answer=0;
	var id = $(this).attr('id');
	if(id == 'reject') {
		answer = 0;
	} else if(id == "accept") {
		answer = 1;
	} else if (id == "sendToRework"){
		answer = 2;
	} else {
		answer = 3;
	}
	var data = new Array();
	data.push({fieldId : "editorDecision", fieldValue : answer});
	$.ajax({
		url:'../task/post/'+$("#task").val()+'/finalDecision',
		type:'POST',
		contentType : 'application/json',
		async: false,
		data: JSON.stringify(data),
		success: function(response) {
			alert("Answer accepted");
		}
	})
});
