function buy(){
	var data = JSON.stringify({
		'magazineIssn' : $("#issn").val(),
		'userEmail' : "nemanja.gavrilovic@gmail.com",
		'articleTitle': $("#title").val(),
	})
	$.ajax({
		url:'../articles/createOrder/',
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