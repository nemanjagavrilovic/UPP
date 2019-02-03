function subscribe(){
	
	$.ajax({
		url:'http://localhost:5555/acceptPlan/'+$("#magazineId").val(),
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