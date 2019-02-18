$(document).on('click',"#magazine", function(e) {
	e.preventDefault();
	
	var task = $("#task").val();
	var href = $(this).attr('href');
	
	$.ajax({
		url : href,
		type : 'GET',
		async: false,
		success:function(response){
			
			window.top.location = response;
		}
		
	})
})