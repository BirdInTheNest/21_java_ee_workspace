<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>이미지 등록</h3>
<form id="imageboardWriteForm" enctype="multipart/form-data" method="post" action="/MQBProject/imageboard/imageboardWrite.do">
<table border="1" cellpadding="5" cellspacing="0">
	<tr>
		<td width="100" align="center">상품코드</td>
		<td>
			<input type="text" id="imageId" name="imageId" size="50" value="img_"><!-- value를 날짜시간으로 할 수도 있다 -->
		</td>
	</tr>
	
	<tr>
		<td width="100" align="center">상품명</td>
		<td>
			<input type="text" id="imageName" name="imageName" size="50" placeholder="상품명 입력">
		</td>
	</tr>
	
	<tr>
		<td width="100" align="center">단가</td>
		<td>
			<input type="text" id="imagePrice" name="imagePrice" size="50" placeholder="단가 입력">
		</td>
	</tr>
	
	<tr>
		<td width="100" align="center">개수</td>
		<td>
			<input type="text" id="imageQty" name="imageQty" size="50" placeholder="개수 입력">
		</td>
	</tr>
	
	<tr>
		<td width="100" align="center">내용</td>
		<td>
			<textarea cols="50" rows="15" id="imageContent" name="imageContent"></textarea>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="file" name="image1">
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="file" name="image2">
		</td>
	</tr>
	
	<tr>
		<td colspan="2" align="center">
			<input type="button" id="imageboardWriteBtn" value="이미지등록">
			<input type="reset" value="다시작성">
		</td>
	</tr>
</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$('#imageboardWriteBtn').click(function(){
		$('#imageboardWriteForm').submit();
	});
</script>

<!-- 
파일 업로드 / 다운로드
: cos-2020.4.jar 
: 반드시 POST 방식이어야 한다
: enctype="multipart/form-data"를 기입
: <input type="file" >으로 설정해야한다
: Eclipse에서는 가상폴더, 실제폴더가 따로 있다
: <form name="" method="post" enctype="multipart/form-data" action="">으로 설정해야한다

 -->