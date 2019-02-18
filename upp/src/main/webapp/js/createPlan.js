$(document).on('click','#createPlan',function(){
	var magazine;
	
	var data = JSON.stringify({
		"planDescription" : $("#planDescription").val(),
		"planCurrency" : $("#planCurrency").val(),
		"planFrequency" : $("#planFrequnecy option:selected").val(),
		"planReturnUrl" : $("#planReturnUrl").val(),
		"planCancelUrl" : $("#planCancelUrl").val()
	
	})
	$.ajax({
		url:'/magazines/makePlan/'+$("#planMagazine option:selected").val(),
		type:'POST',
		data: data,
		contentType:'application/json',
		crossDomain: true,
        xhrFields: {
            withCredentials: false
        },
        async:false,
        headers: {'Access-Control-Allow-Origin': '*'},
		success:function(response) {
					alert("Saved plan");
					window.location.href = "../../magazines/all/";
				}
			})
		
	})
