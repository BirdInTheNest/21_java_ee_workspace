$(function(){
	//회원가입
	$('#writeBtn').click(function(){
		$('#nameDiv').empty();
		$('#writeForm #idDiv').empty();
      	$('#writeForm #pwdDiv').empty();
      	$('#repwdDiv').empty();

		if($('input[name="name"]').val() == '') {
			$('#nameDiv').html('이름 입력');
			$('#name').focus();
		}else if($('#writeForm #id').val()=='') {
			$('#writeForm #idDiv').html('아이디 입력');
			$('#writeForm #id').focus();
		}else if($('#writeForm #pwd').val()=='') {
			$('#writeForm #pwdDiv').html('비밀번호 입력');
			$('#writeForm #pwd').focus();
		}else if($('#writeForm #pwd').val() != $('#writeForm #repwd').val())
			$('#repwdDiv').html('비밀번호 틀림');
			
		else if($('#writeForm #id').val() != $('#check').val())
			$('#writeForm #idDiv').html('중복체크 하세요');
		
		else 
			//$('form[name="writeForm"]').submit();
			
			$.ajax({
				url: '/MQBProject/member/write.do',
				type: 'post',
				data: $('#writeForm').serialize(),
				//리턴값 없으므로 dataType 생략, success의 data 생략
				success: function(){
					alert('회원가입을 축하합니다');
					location.href='/MQBProject/index.jsp';
				},
				error: function(err){
					console.log(err);
				}
			});
	});
	
	//로그인
	$('#loginBtn').click(function(){
		$('#idDiv').empty();
      	$('#pwdDiv').empty();

		if($('input[name="id"]').val()=='')
			$('#idDiv').html('아이디 입력');
		else if($('input[name="pwd"]').val()=='')
			$('#pwdDiv').html('비밀번호 입력');
		else {
			//submit하면 action타고 페이지 이동하는데, ajax 이용하여 페이지 이동 안하도록 한다
			$.ajax({
				url: '/MQBProject/member/login.do',
				type: 'post',
				data: 'id='+$('#id').val()+'&pwd='+$('#pwd').val(), //서버로 보내는 데이터, 파라미터, 변수=값&변수=값
				dataType: 'text',
				success: function(data){
					//alert(data);
					data = data.trim(); //공백 제거
					
					if(data == 'ok'){
						location.href = '/MQBProject/index.jsp';
						
					}else if(data == 'fail'){
						$('#loginResult').text('로그인 실패');
						$('#loginResult').css('color', 'red');
						$('#loginResult').css('font-size', '15pt');
						$('#loginResult').css('font-weight', 'bold');
					}
				},
				error: function(err){
					console.log(err);
				}
			});
			
		}
	});
	
});

//아이디 중복 체크
$('#writeForm #id').focusout(function(){ //change 이벤트로 걸어도 된다
	$('#writeForm #idDiv').empty();
	
	if($('#writeForm #id').val() == ''){
		$('#writeForm #idDiv').html('먼저 아이디를 입력하세요');
		$('#writeForm #idDiv').css('color', 'red');
	}else{
		$.ajax({
			url: '/MQBProject/member/checkId.do',
			type: 'post',
			data: 'id='+$('#writeForm #id').val(), //{'id': $('#writeForm #id').val()}
			dataType: 'text',
			success: function(data){
				//alert(data);
				data = data.trim(); //공백제거
				
				if(data == 'exist'){
					$('#writeForm #idDiv').html('사용 불가능');
					$('#writeForm #idDiv').css('color', 'red');
				}else if(data == 'non_exist'){
					$('#writeForm #idDiv').html('사용 가능');
					$('#writeForm #idDiv').css('color', 'blue');
					
					$('#check').val($('#writeForm #id').val());
				}
				
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});

//우편번호 체크
$('#zipcodeBtn').click(function(){
	window.open("/MQBProject/member/checkPost.do", "checkPost", "width=600 height=600 top=200 left=700");
});

$('#checkPostSearchBtn').click(function(){
	$.ajax({
		url: '/MQBProject/member/checkPostSearch.do',
		type: 'post',
		data: $('#checkPostForm').serialize(), //폼네임.serialize()
		dataType: 'json', //list를 json으로 변환 필요
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#zipcodeTable tr:gt(2)').remove(); //초기화, empty로 지워도 됨, gt >
			
			$.each(data.list, function(index, items){ //$.each 반복문, list 인덱스 번호 값
				var address = items.sido + ' ' 
							+ items.sigungu + ' ' 
							+ items.yubmyundong + ' ' 
							+ items.ri + ' ' 
							+ items.roadname + ' ' 
							+ items.buildingname;
					
				//yubmyundong, ri 값 undefined 뜨는 거 g(정규식 표현법, global,전체)에서 찾아서 ''로 표시
				address = address.replace(/undefined/g, '');
							
				$('<tr/>').append($('<td/>',{ //$('<td/>',{}) td태그 안의 내용
					align: 'center',
					text: items.zipcode
				})).append($('<td/>',{
					colspan: 3,
				}).append($('<a/>',{
					href: '#',
					text: address,
					class: 'addressA'			
				}))).appendTo($('#zipcodeTable'));
			});//each
			
			//주소를 클릭하면 writeForm으로 값 보낸다
			$('.addressA').click(function(){
				//alert($(this).text()); - 주소
				//alert($(this).parent().prev().text()); - 우편번호
				
				$('#zipcode', opener.document).val($(this).parent().prev().text());
				$('#addr1', opener.document).val($(this).text());
				window.close();
				$('#addr2', opener.document).focus();
			});			
		},
		error: function(err){
			console.log(err);
		}
	});
});


