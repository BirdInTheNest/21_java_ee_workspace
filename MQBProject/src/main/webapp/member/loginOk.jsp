<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
img {
	width: 70px;
	height: 70px;
	cursor: pointer;
}
</style>

<img src="/MQBProject/image/img2.gif" onclick="location.href='../index.jsp'">
${sessionScope.memName }님 로그인
<br><br>

<input type="button" value="로그아웃" id="logoutBtn">
<input type="button" value="회원정보수정" onclick="location.href='/MQBProject/member/modifyForm.do'">

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$('#logoutBtn').click(function(){
	$.ajax({
		url: '/MQBProject/member/logout.do',
		type: 'post',
		success: function(){
			alert('로그아웃');
			location.href="/MQBProject/index.jsp";
		},
		error: function(err){
			console.log(err)
		}
	});
});
</script>
