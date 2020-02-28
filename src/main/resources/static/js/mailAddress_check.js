$(function(){
	$('#mailAddress').on("keyup",function(){
		var hostUrl = 'http://localhost:8080/mailaddress_check_api/mailaddress_check';
		var mailAddress = $("#mailAddress").val();
		
		
		$.ajax({
			url: hostUrl ,
			type: "GET",
			dataType: "json",
			data: {
				mailAddress: mailAddress
			},
			async: true
		}).done(function(data){
			console.log(data);
			console.dir(JSON.stringify(data));
			$("#duplicateMessage").html(data.duplicateMessage);
		}).fail(function(XMLHttpRequest, textStatus, errorThrown){ 
			alert("エラーが発生しました!");
			console.log("XMLHttpRequest : " + XMLHttpRequest.status); 
			console.log("textStatus : " + textStatus); 
			console.log("errorThrown : " + errorThrown.message);
		});
	});
});