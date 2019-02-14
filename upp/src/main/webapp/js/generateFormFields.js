//function getFormFields(formFields) {
//	var data = new Array();
//	formFields.forEach(element => {
//		data.push({fieldId : element.id, fieldValue : $("#"+element.id).val()});
//	});
//	
//	return data;
//	
//}
function generateForm (fields,div) {

	for(i=0; i<fields.length; i++) {
		if(fields[i].type.name == "string" ) {
			if(fields[i].id == "password")
				$("#"+div).append(fields[i].label+'<br/><input type="password" id="'+fields[i].id+'"><br/>');
			else
				$("#"+div).append(fields[i].label+'<br/><input type="text" id="'+fields[i].id+'"><br/>');
			
		}
	}
}