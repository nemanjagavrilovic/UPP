var fileResult;
var fileName;
function openFile(event){
	  var input = event.target;
	  var reader = new FileReader();
	  reader.onload = function() {
	      fileResult = reader.result;
	    };
	    fileName = input.files[0].name;
	    reader.readAsDataURL(input.files[0]);

}
$(document).on('click',"#btnSubmit",function(e){
	e.preventDefault();
	 var form = $('#fileUploadForm')[0];

	var data = JSON.stringify({
		"file" : fileResult,
		"filename" : fileName,
		"abstracts" : $("#abstract").val()
		
	})
	$.ajax({
		url:'../articles/rework/'+$("#task").val(),
		type:'POST',
		enctype: 'multipart/form-data',
		contentType:"application/json",
		dataType:"json",
		async:false,
		data:data,
		success:function(response){
			window.top.location="../jsp/home.jsp";
		}
	})
})