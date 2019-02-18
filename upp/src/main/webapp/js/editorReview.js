$(document).on('click','input[type="button"]',function(){
	var answer=0;
	var id = $(this).attr('id');
	if(id == 'reject') {
		answer = 0;
	} else if(id == "sendToRework") {
		answer = 1;
	} else {
		answer = 2;
	}
	var data = new Array();
	data.push({fieldId : "comment", fieldValue : $("#comment").val()});
	data.push({fieldId : "action", fieldValue : answer});
	
	$.ajax({
		url:'../task/post/'+$("#task").val()+'/editorReview',
		type:'POST',
		contentType : 'application/json',
		data: JSON.stringify(data),
		async:false,
		success: function(response) {
			alert("Answer accepted");
		}
	})
});
