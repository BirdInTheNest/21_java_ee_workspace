//방명록 작성
$('#guestbookWriteBtn').click(function(){
	$('#guestbookWriteForm #subjectDiv').empty();
	$('#guestbookWriteForm #contentDiv').empty();
	
	if($('#guestbookWriteForm #subject').val() == ''){
		$('#guestbookWriteForm #subjectDiv').html('제목을 입력해주세요');
		$('#guestbookWriteForm #subject').focus();
	}else if($('#guestbookWriteForm #content').val() == ''){
		$('#guestbookWriteForm #contentDiv').html('내용을 입력해주세요');
		$('#guestbookWriteForm #content').focus();
	}else
		$.ajax({
			url: '/MQBProject/guestbook/guestbookWrite.do',
			type: 'post',
			data: $('#guestbookWriteForm').serialize(),
			//리턴값 없으므로 dataType 생략, success의 data 생략
			success: function(){
				alert('방명록이 작성되었습니다.');
				location.href='/MQBProject/index.jsp';
			},
			error: function(err){
				console.log(err);
			}
		});
});
