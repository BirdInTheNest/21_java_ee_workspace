<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<input type="hidden" id="pg" value="${pg }">

<table id="productListTable" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<th width="100">번호</th>
		<th width="100">이미지</th>
		<th width="300">상품명</th>
		<th width="100">단가</th>
		<th width="50">개수</th>
		<th width="100">합계</th>
		<th width="50">할인율</th>
		<th width="100">할인액</th>
		<th width="100">가격</th>
	</tr>	
</table>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url: '/MQBProject/product/getProductList.do',
		type: 'post',
		data: 'pg='+$('#pg').val(), //문자열로 보내는 것 {'pg' : $('#pg').val()} 제이슨으로 보내는 것
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq
					
				})).append($('<td/>',{
					align: 'center'
					
				}).append($('<img>',{
					src: '/MQBProject/storage/'+items.img,
					alt: items.img,
					style: 'width: 100px; height: 100px; cursor: pointer;'
					
				}))).append($('<td/>',{
					align: 'center',
					text: items.name
					
				})).append($('<td/>',{
					align: 'center',
					text: items.unit.toLocaleString()
					
				})).append($('<td/>',{
					align: 'center',
					text: items.qty.toLocaleString()
					
				})).append($('<td/>',{
					align: 'center',
					text: items.total.toLocaleString()
					
				})).append($('<td/>',{
					align: 'center',
					text: items.rate+'%'
					
				})).append($('<td/>',{
					align: 'center',
					text: items.discount.toLocaleString()
					
				})).append($('<td/>',{
					align: 'center',
					text: items.price.toLocaleString()
					
				})).appendTo($('#productListTable'));
			});//each
			
		},
		error: function(err){
			console.log(err);
		}
	});
});
</script>