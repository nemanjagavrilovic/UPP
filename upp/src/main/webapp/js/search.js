$(document).on('change','#field',function(){
	
	if($(this).val() == 'Author') {
		$("#authorSearch").css('display','block');
		$("#fields").css('display','none');
		$("#searchButtonName").css('display','block');
		$("#searchButton").css('display','none');
	} else {
		$("#authorSearch").css('display','none');
		$("#fields").css('display','block');
		$("#searchButtonName").css('display','none');
		$("#searchButton").css('display','block');
	}
});

$(document).on('click','#searchButton',function(){
	
	var data = JSON.stringify({
		"text" : $("#search").val(),
		"searchType" : $("#searchType option:selected").val(),
		"field" : $("#field option:selected").val()
	})
	
	$.ajax({
		url:"../searchController/",
		type:'POST',
		contentType:'application/json',
		data:data,
		dataType:'json',
		success:function(response){
			drawResult(response);
		}
	})
})

$(document).on('click','#searchButtonName',function(){
	
	
	$.ajax({
		url:"../searchController/findByNameAndSurname/"+$("#authorName").val()+"/"+$("#authorSurname").val()+"/"+$("#searchType option:selected").val(),
		type:'POST',
		contentType:'application/json',
		dataType:'json',
		success:function(response){
			drawResult(response);
		}
	})
})

$(document).on('click','#advancedSearchButton',function(){
	if($("#advancedSearchDiv").css('display') == 'block') {
		$("#advancedSearchDiv").css('display','none');
		$("#simpleSearch").css('display','block');
		$("#searchButton").css('display','block');
		$("#advancedSearch").css('display','none');
		$("#simpleSearchButton").css('display','none');
		$("#advancedSearchButton").css('display','block');
		$("#boolSearchButton").css('display','none');

	} else {
		$("#advancedSearchButton").css('display','none');
		$("#advancedSearchDiv").css('display','block');
		$("#advancedSearch").css('display','block');
		$("#simpleSearch").css('display','none');
		$("#searchButton").css('display','none');
		$("#boolSearchButton").css('display','block');
		$("#simpleSearchButton").css('display','block');
	
	
		
	}
})
$(document).on('click','#addField',function(){
	$("#advancedTable").append("<tr>"+
					"<td>"+
						"<select id='searchOption'>"+
							"<option value='AND'>And</option>"+
							"<option value='OR'>Or</option>"+
						"</select>"+
					"</td>"+
					"<td>"+
						"<select id='fieldAdvaced'>"+
							"<option value='title'>Title</option>"+
							"<option value='text'>Text</option>"+
							"<option value='abstracts'>Abstracts</option>"+
							"<option value='scientificField'>Scientific field</option>"+
							"<option value='keywords'>Keywords</option>"+
							"<option value='magazineName'>Magazine name</option>"+
							"<option value='author'>Author</option>"+
					  "</select> "+
					"</td>"+
					"<td>"+
						"<select id='searchTypeAdvanced'>"+
							"<option value='REGULAR'>Regular</option>"+
							"<option value='PHRASE'>Phrase</option>"+
						"</select>"+
					"</td>"+
					"<td>"+
						"<div id='fields' style='display:block;'>"+
							"<input type='text' id='searchAdvanced'>"+
						"</div>"+
						"<div id='authorSearch' style='display:none;'>"+
							"Name:<input type='text' id='authorName'>"+
							"Surname:<input type='text' id='authorSurname'>"+
						"</div>"+
					"</td>"+
					"<td>"+
						"<input type='button' value='Delete' id='deleteField'>"+
					"</td>"+
				"</tr>");
})
$(document).on('click','#deleteField',function(){
	$(this).parent().parent().remove();
})
$(document).on('click',"#simpleSearchButton",function(){
	if($("#simpleSearchButton").css('display') == 'block') {
		$("#advancedSearchDiv").css('display','none');
		$("#simpleSearch").css('display','block');
		$("#searchButton").css('display','block');
		$("#advancedSearch").css('display','none');
		$("#boolSearchButton").css('display','block');
		$("#simpleSearchButton").css('display','none');
		$("#advancedSearchButton").css('display','block');
		$("#boolSearchButton").css('display','none');
	} else {
		$("#advancedSearchDiv").css('display','block');
		$("#advancedSearch").css('display','block');
		$("#simpleSearch").css('display','none');
		$("#searchButton").css('display','none');
		$("#simpleSearchButton").css('display','block');
		$("#advancedSearchButton").css('display','none');
		$("#boolSearchButton").css('display','block');

	}
})
$(document).on('click','#boolSearchButton',function(){
	var data = [];
	$("#advancedTable > tbody > tr").each(function(){
		if($(this).find("#fieldAdvaced option:selected").val() === "keywords") {
			var input = $(this).find("#searchAdvanced").val().split(",");
			for(i=0; i<input.length; i++) {
				var query = {
						"field" : $(this).find("#fieldAdvaced option:selected").val(),
						"value" : input[i],
						"operation" : $(this).find("#searchOption option:selected").val(),
						"searchType" : $(this).find("#searchTypeAdvanced option:selected").val()
					}
				data.push(query);
			}
		} 
		else if($(this).find("#fieldAdvaced option:selected").val() === "author") {
			var input = $(this).find("#searchAdvanced").val().split(" ");
			var query = {
					"field" : "authors.firstName",
					"value" : input[0],
					"operation" : $(this).find("#searchOption option:selected").val(),
					"searchType" : $(this).find("#searchTypeAdvanced option:selected").val()
				}
			data.push(query);
			var querySurname = {
					"field" : "authors.lastName",
					"value" : input[1],
					"operation" : $(this).find("#searchOption option:selected").val(),
					"searchType" : $(this).find("#searchTypeAdvanced option:selected").val()
				}
			data.push(querySurname);
			
		}
		else {
			var query = {
				"field" : $(this).find("#fieldAdvaced option:selected").val(),
				"value" : $(this).find("#searchAdvanced").val(),
				"operation" : $(this).find("#searchOption option:selected").val(),
				"searchType" : $(this).find("#searchTypeAdvanced option:selected").val()
			}
			data.push(query);
		}
	});
	
	$.ajax({
		url:"../searchController/booleanQuery/AND/REGULAR/",
		type:'POST',
		contentType:'application/json',
		data:JSON.stringify(data),
		dataType:'json',
		success:function(response){
			drawResult(response);
		}
	})
})

function drawResult(articles){
	$("#result").empty();
	$.each(articles,function(i,element){
		$("#result").append("<div class='panel-group'>"+
								"<div class='panel panel-default'>"+
									"<div class='panel-heading'>"+element.title+"</div>"+
									"<div class='panel-body'>"+checkHighlighter(element.highlight)+"</div>"+
									"<div class='panel-body'><a href='http://localhost:8082/files/"+element.filename+"' target='_blank' id='download'>Download</a></div>"+
								"</div>"+  
							"</div>"
						);
	});
}
function checkHighlighter(highlight){
	if(highlight != undefined || highlight != null) {
		return highlight;
	} else {
		return "";
	}
}
