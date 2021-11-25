$(function(){
	//회원가입
	$('#memberWriteBtn').click(function(){
		//초기화 작업
		$('#idDiv').empty();
      	$('#pwdDiv').empty();
      	$('#repwdDiv').empty();

		if($('#id').val()=='')
			$('#idDiv').html('아이디 입력하세요');
			
		else if($('#pwd').val()=='')
			$('#pwdDiv').html('비밀번호 입력하세요');
			
		else if($('#pwd').val() != $('#repwd').val())
			$('#repwdDiv').html('비밀번호 일치하지 않습니다.');
			
		else 
			$('form[name="memberWriteForm"]').submit();
	});
	
	//로그인
	$('#memberLoginBtn').click(function(){
		$('#idDiv').empty();
      	$('#pwdDiv').empty();

		if($('#id').val()=='')
			$('#idDiv').html('아이디 입력하세요');
			
		else if($('#pwd').val()=='')
			$('#pwdDiv').html('비밀번호 입력하세요');
			
		else 
			$('form[name="memberLoginForm"]').submit();
	});
});


















