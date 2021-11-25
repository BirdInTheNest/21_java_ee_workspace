$(function(){
	$.ajax({
		url: '/MQBProject/imageboard/getImageboardList.do',
		type: 'post',
		data: 'pg='+$('#pg').val(), //문자열로 보내는 것 {'pg' : $('#pg').val()} 제이슨으로 보내는 것
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			
			$.each(data.list, function(index, items){ //for(ImageboardDTO items : data.list)
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq,
					
				}).prepend($('<input/>',{
					type: 'checkbox',
					class: 'check', //아이디속성은 첫번째만 이벤트가 적용되므로 클래스 속성 부여
					name: 'check', //폼에서 submit하면 선택한 항목만 네임 속성으로 넘어감
					value: items.seq //같은 항목일 때는 고유키를 넘겨야 함
					
				}))).append($('<td/>',{
					align: 'center',
					
				}).append($('<img/>',{
					src: '/MQBProject/storage/'+items.image1,
					alt: items.image1,
					style: 'width: 100px; height: 100px; cursor: pointer;'
					
				}))).append($('<td/>',{
					align: 'center',
					text: items.imageName
					
				})).append($('<td/>',{
					align: 'center',
					text: items.imagePrice.toLocaleString() //세자리마다 , 표시
					//JSTL 태그 taglib prefix="fmt"는 JSP에서만 사용가능, 스크립트 구역에서 사용 불가
					
				})).append($('<td/>',{
					align: 'center',
					text: items.imageQty.toLocaleString()
					
				})).append($('<td/>',{
					align: 'center',
					text: (items.imagePrice * items.imageQty).toLocaleString()
					
				})).appendTo($('#imageboardListTable'));
		
			});//each
			
			//페이징 처리
			$('#imageboardPagingDiv').html(data.imageboardPaging);
			
		},
		error: function(err){
			console.log(err);
		}
	});
});