$(document).on('click','#createPlan',function(){
	var magazine;
	$.ajax({
		url:'/magazines/'+$("#planMagazine option:selected").val(),
		type:'GET',
		contentType:'application/json',
		dataType:'json',
		async:false,
		success:function(data) {
			magazine = data;
		}
	})
	var data = JSON.stringify({
		"planDescription" : $("#planDescription").val(),
		"planCurrency" : $("#planCurrency").val(),
		"planFrequency" : $("#planFrequnecy option:selected").val(),
		"planReturnUrl" : $("#planReturnUrl").val(),
		"planCancelUrl" : $("#planCancelUrl").val(),
		"magazineId" : magazine.id,
		"planName" : magazine.title
	
	})
	$.ajax({
		url:'http://localhost:5555/makePlan',
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
			$.ajax({
				url:'/paypalPlan/savePlan',
				type:'POST',
				data:JSON.stringify(response.plan),
				contentType:'application/json',
				dataType:'json',
				success:function(response){
					alert("Saved plan");
					window.location.href = "../../magazines/all/";
				}
			})
		}
	})
})