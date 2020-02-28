$(function(){
	$('#confirmPassword').on("keyup",function(){
		var hostUrl = 'http://localhost:8080/password_check_api/password_check';
		var password = $("#password").val();
		var confirmPassword = $("#confirmPassword").val();
		
		console.log(password);
		console.log(confirmPassword);
		
		$.ajax({
			url: hostUrl ,
			type: "GET",
			dataType: "json",
			data: {
				password: password,
				confirmPassword: confirmPassword
			},
			async: true
		}).done(function(data){
			console.log(data);
			console.dir(JSON.stringify(data));
			$("#confirmMessage").html(data.confirmMessage);
		}).fail(function(XMLHttpRequest, textStatus, errorThrown){ 
			alert("エラーが発生しました!");
			console.log("XMLHttpRequest : " + XMLHttpRequest.status); 
			console.log("textStatus : " + textStatus); 
			console.log("errorThrown : " + errorThrown.message);
		});
	});
});