function subscribe(){
	
	$.ajax({
		url:'http://localhost:9001/lb/acceptPlan/'+$("#magazineId").val(),
		type:'GET',
		crossDomain: true,
        xhrFields: {
            withCredentials: false
        },
        headers: {'Access-Control-Allow-Origin': '*'},
		success:function(response) {
			top.location.href = response.redirectURL;
		}
	})
}

function buy(){
	var data = JSON.stringify({
		'magazineIssn' : $("#issn").val(),
		'email' : "nemanja.gavrilovic@gmail.com",
		'articleTitle':""
	})
	$.ajax({
		url:'../magazines/createOrder/',
		type:'POST',
		data:data,
		contentType:'application/json',
		crossDomain: true,
        xhrFields: {
            withCredentials: false
        },
        headers: {'Access-Control-Allow-Origin': '*'},
		success:function(response) {
			console.log(response);
			window.location.href = response;
		}
	})
}