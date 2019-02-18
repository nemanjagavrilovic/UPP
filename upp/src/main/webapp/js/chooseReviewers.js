$(document).on('click','#add',function(){
	var user = $("#byDistance option:selected").val();
	var user2 = $("#moreLikeThis option:selected").val();
	if(user != "/" && checkAddedUser(user) == false) {
		$("#chooseReviewer").append('<option value="'+user+'">'+$("#byDistance option:selected").text()+'</option>')
	}
	var d = checkAddedUser(user2);
	if(user2 != "/" && d == false) {
		$("#chooseReviewer").append('<option value="'+user2+'">'+$("#moreLikeThis option:selected").text()+'</option>')
	}
})

$(document).on('click','#remove',function(){
	$("#chooseReviewer option:selected").remove();
})
function checkAddedUser(userEmail) {
	var exsits = false;
	$.each($("#chooseReviewer option"),function(index,element){
		if(element.value === userEmail) {
			exsits = true;
		}
	})
	return exsits;
}
$(document).on('click','#complete',function(){
	var data = new Array();
	$.each($("#chooseReviewer option"),function(index,element){
		data.push({fieldId : index , fieldValue : element.value});

	})
	$.ajax({
		url:'../task/post/'+$("#task").val()+'/chooseReviewers',
		type:'POST',
		contentType:'application/json',
		async:false,
		data:JSON.stringify(data),
		success:function(response){
		}
	})
})