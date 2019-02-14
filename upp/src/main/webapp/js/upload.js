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
		"scientificField" : "Medicina",
		"abstracts" : $("#abstract").val(),
		"magazineName" : "Lepota i zdravlje",
		"authors" : [
		         	{
		 				"id" : "5",
		 				"firstName" : "Lazar",
		 				"lastName"  : "Lazarević",
		 				"email" : "laza@gmail.com",
		 				"age" : 55,
		 				"lat" : 16.03,
		 				"lon" : 75.32
		 			},         
			],
		"reviewers" : [
			 			
			 			{
			 				"id" : "3",
			 				"firstName" : "Dragan",
			 				"lastName"  : "Ivanović",
			 				"email" : "dragan.ivanovic@gmail.com",
			 				"age" : 35,
			 				"lat" : 46.03,
			 				"lon" : 130.32
			 			},
			 			{
			 				"id" : "1",
			 						"firstName" : "Nemanja",
			 						"lastName"  : "Gavrilović",
			 						"email" : "nemanja.gavrilovic1995@gmail.com",
			 						"age" : 23,
			 						"lat" : 43.03,
			 						"lon" : 134.32
			 				},
			 				{
			 					"id" : "4",
			 					"firstName" : "Nikola",
			 					"lastName"  : "Nikolić",
			 					"email" : "nikola@gmail.com",
			 					"age" : 19,
			 					"lat" : 33.03,
			 					"lon" : 124.32
			 				}
			 			]
	})
	$.ajax({
		url:'../articles/save/'+$("#task").val(),
		type:'POST',
		enctype: 'multipart/form-data',
		contentType:"application/json",
		dataType:"json",
		data:data,
		success:function(response){
			window.top.location="../jsp/addCoauthor.jsp";
		}
	})
})