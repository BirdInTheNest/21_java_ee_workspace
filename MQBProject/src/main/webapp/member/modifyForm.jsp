<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}
</style>
</head>
<body>
<form name="modifyForm" method="post" action="/mvcmember/member/modify.do">
	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td width="100" align="center">이름</td>
			<td>
				<input type="text" name="name" id="name" value="${sessionScope.memName }">
				<div id= "nameDiv"></div>
			</td>	
		</tr>
		
		<tr>
			<td width="100" align="center">아이디</td>
			<td>
				<input type="text" name="id" id="id" value="${sessionScope.memId }" readonly>
				<div id= "idDiv"></div>
			</td>	
		</tr>
		
		<tr>
			<td width="100" align="center">비밀번호</td>
			<td>
				<input type="password" name="pwd" id="pwd" size="30" placeholder="비밀번호 입력">
				<div id= "pwdDiv"></div>
			</td>	
		</tr>
		
		<tr>
			<td width="100" align="center">재확인</td>
			<td>
				<input type="password" name="repwd" id="repwd" size="30" placeholder="비밀번호 입력">
				<div id= "repwdDiv"></div>
			</td>	
		</tr>
		
		<tr>
			<td width="100" align="center">성별</td>
			<td>
				<input type="radio" name="gender" value="0">남
				<input type="radio" name="gender" value="1">여
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">이메일</td>
			<td>
				<input type="text" name="email1" value="${sessionScope.memEmail1 }">
				@
				<input type="text" name="email2" list="email2" value="${sessionScope.memEmail2 }">
				<datalist id="email2">
					<option value="naver.com">naver.com
					<option value="daum.net">daum.net
					<option value="gmail.com">gmail.com
				</datalist>
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">핸드폰</td>
			<td>
				<select name="tel1" style="width: 70px;">
					<option value="010" >010</option>
					<option value="011" >011</option>
					<option value="019" >019</option>
				</select>
				-
				<input type="text" name="tel2" size="6" maxlength="4" value="${sessionScope.memTel2 }">
				-
				<input type="text" name="tel3" size="6" maxlength="4" value="${sessionScope.memTel3 }">
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">주소</td>
			<td>
				<input type="text" name="zipcode" id="zipcode" value="${sessionScope.memZipcode }" readonly>
				<input type="button" value="우편번호 검색" id="zipcodeBtn"><br>
				<input type="text" name="addr1" id="addr1" size="60" value="${sessionScope.memAddr1 }" readonly><br>
				<input type="text" name="addr2" id="addr2" size="60"value="${sessionScope.memAddr2 }" >
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" id="updateBtn" value="회원정보수정">
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#updateBtn').click(function(){
		$('#nameDiv').empty();
		$('#idDiv').empty();
      	$('#pwdDiv').empty();
      	$('#repwdDiv').empty();

		if($('input[name="name"]').val() == '') {
			$('#nameDiv').html('이름 입력');
			$('#name').focus();
		}else if($('input[name="id"]').val()=='') {
			$('#idDiv').html('아이디 입력');
			$('#id').focus();
		}else if($('input[name="pwd"]').val()=='') {
			$('#pwdDiv').html('비밀번호 입력');
			$('#pwd').focus();
		}else if($('input[name="pwd"]').val() != $('input[name="repwd"]').val())
			$('#repwdDiv').html('비밀번호 틀림');

		else 
			$('form[name="modifyForm"]').submit();
	});
	
	//우편번호
	$('#zipcodeBtn').click(function(){
		window.open("/mvcmember/member/checkPost.do", "checkPost", "width=500 height=500 top=200 left=700");
	});

	$('.addressA').click(function(){
		//alert($(this).text()); - 주소
		//alert($(this).parent().prev().text()); - 우편번호
		
		$('#zipcode', opener.document).val($(this).parent().prev().text());
		$('#addr1', opener.document).val($(this).text());
		window.close();
		$('#addr2', opener.document).focus();
	});
	
	//회원정보 성별 체크박스
	$('input[name="gender"]').ready(function(){
		var index = ${sessionScope.memGender };
		
		if(index == 0){
			$('input[value="0"]').prop('checked', true);
			$('input[value="1"]').prop('checked', false);
		}else {
			$('input[value="1"]').prop('checked', true);
			$('input[value="0"]').prop('checked', false);
		}
	});
	
	//회원정보 휴대폰 셀렉트
	$('select[name=tel1]').ready(function(){
		var index = ${sessionScope.memTel1 };
		
		if(index == 0){
			$('select option[value=010]').prop('selected', true);
		}else if(index == 1){
			$('select option[value=011]').prop('selected', true);
		}else{
			$('select option[value=019]').prop('selected', true);
		}
	});

	
});	
</script>
</body>
</html>
