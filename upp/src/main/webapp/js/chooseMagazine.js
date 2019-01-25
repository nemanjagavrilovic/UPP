$(document).on('click',"#magazine", function(e) {
	e.preventDefault();
	
	var task = $("#task").val();
	var href = $(this).attr('href');
	
	$.ajax({
		url : href,
		type : 'GET',
		success:function(response){
			window.top.location = '../../../jsp/task.jsp';
		}
		
	})
})