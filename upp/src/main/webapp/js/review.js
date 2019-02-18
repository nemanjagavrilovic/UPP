$(document).on('click','#complete',function(){
	var data = new Array();
	data.push({fieldId : "suggestion", fieldValue : $("#suggestion option:selected").val()});
	if($("#comment_for_editor").val() != "") {
		data.push({fieldId : "comment_for_editor", fieldValue : $("#comment_for_editor").text()});
	}
	if($("#comment_for_author").val() != "") {
		data.push({fieldId : "comment_for_author", fieldValue : $("#comment_for_author").text()});
	}
	$.ajax({
		url:'../task/post/'+$("#task").val()+'/review',
		type:'POST',
		contentType : 'application/json',
		data: JSON.stringify(data),
		async : false,
		success: function(response) {
			alert("Answer accepted");
		}
	})
})