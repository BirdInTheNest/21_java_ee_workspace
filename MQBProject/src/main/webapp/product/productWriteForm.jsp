<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
#productWriteForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>

<h3> 상품 등록 </h3> 
<form id="productWriteForm" enctype="multipart/form-data" method="post" 
action="/MQBProject/product/productWrite.do"> 
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<td width="100" align="center">상품</td>
		<td>
			<input type="file" name="img">
		</td>
	</tr>

	<tr>
		<td width="100" align="center">상품명</td>
		<td>
			<input type="text" id="name" name="name" size="50" placeholder="상품명 입력">
			<div id="nameDiv"></div>
		</td>
	</tr>
	
	<tr>
		<td width="100" align="center">단가</td>
		<td>
			<input type="text" id="unit" name="unit" size="50" placeholder="단가 입력">
			<div id="unitDiv"></div>
		</td>
	</tr>
	
	<tr>
		<td width="100" align="center">개수</td>
		<td>
			<input type="text" id="qty" name="qty" size="50" placeholder="개수 입력">
			<div id="qtyDiv"></div>
		</td>
	</tr>

	<tr>
		<td width="100" align="center">할인율</td>
		<td>
			<input type="text" id="rate" name="rate" size="50" placeholder="할인율 입력">&nbsp; %
			<div id="rateDiv"></div>
		</td>
	</tr>

	<tr>
		<td colspan="2" align="center">
			<input type="button" id="productWriteBtn" value="계산">
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$('#productWriteBtn').click(function(){
	//초기화 과정
	$('#nameDiv').empty();
	$('#unitDiv').empty();
	$('#qtyDiv').empty();
	$('#rateDiv').empty();
	
	if($('#name').val() == '') {
		$('#nameDiv').html('상품명 입력'); 
		$('#name').focus();
	}
	else if($('#unit').val() == ''){
		$('#unitDiv').html('단가 입력');
		$('#unit').focus();
	}
	else if($('#qty').val() == ''){
		$('#qtyDiv').html('개수 입력');
		$('#qty').focus();
	}
	else if($('#rate').val() == ''){
		$('#rateDiv').html('할인율 입력');
		$('#rate').focus();
	}
	else 
		$('#productWriteForm').submit();
		/* $.ajax({
			url: '/MQBProject/product/productWrite.do',
			type: 'post',
			data: $('#productWriteForm').serialize(), //폼의 네임 속성 값이 넘어간다
			//리턴값 없으므로 dataType 생략, success의 data 생략
			success: function(){
				alert("상품등록 성공");
				location.href="/MQBProject/product/productList.do?pg=1";
			},
			error: function(err){
				console.log(err);
			}
		}); */
});
</script>












