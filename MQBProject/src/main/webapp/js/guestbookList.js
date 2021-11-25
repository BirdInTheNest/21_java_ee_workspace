$(function(){
	$.ajax({
		url: '/MQBProject/guestbook/getGuestbookList.do',
		type: 'post',
		data: 'pg='+$('#pg').val(), //변수=값
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			console.log(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				$('<tr/>')
					.append($('<td/>',{
						align: 'center',
						text: items.name
						
					})).append($('<td/>',{
						align: 'center',
						text: items.email
						
					})).append($('<td/>',{
						align: 'center',
						text: items.subject
						
					})).append($('<td/>',{
						align: 'center',
						text: items.content
						
					})).appendTo($('#guestbookListTable'));
					
			});//each
			
		},
		error: function(err){
			console.log(err);
		}
	});
});