<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form id="boardViewForm">
<input type="hidden" id="seq" name="seq" value="${requestScope.seq }">
<input type="hidden" id="pg" name="pg" value="${pg }">

<table id="boardViewTable" width="450px" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<td colspan="3"><h3><span id="subjectSpan"></span></h3></td>
	</tr>
	
	<tr>
		<td width="150">글번호 : <span id="seqSpan"></span></td>
		<td width="150">작성자 : <span id="idSpan"></span></td>
		<td width="150">조회수 : <span id="hitSpan"></span></td>
	</tr>
	
	<!-- 엔터를 안치고 글을 옆으로 길게 쓴 경우, 엔터를 계속 쳐서 글이 밑으로 길게 쓴 경우 -->
	<tr>
		<td colspan="3" height="200" valign="top">
			<pre style="white-space: pre-line; word-break: break-all;">
				<span id="contentSpan"></span>
			</pre>
		</td>
	</tr>
</table>

<input type="button" id="boardListBtn" value="목록" 
		onclick="location.href='/MQBProject/board/boardList.do?pg=${pg }'">

<span id="boardViewSpan">
	<input type="button" id="" value="글수정" onclick="mode(1)"><!-- 사용자 함수 -->
	<input type="button" id="" value="글삭제" onclick="mode(2)">
</span>
<input type="button" id="boardReplyBtn" value="답글" 
		onclick="location.href='/MQBProject/board/boardReplyForm.do?seq=${seq }&pg=${pg}'">
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		url: '/MQBProject/board/getBoardView.do',
		type: 'post',
		data: {'seq' : $('#seq').val()}, //변수=값 'seq='+$('#seq').val()
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			
			$('#subjectSpan').text(data.subject);
			$('#seqSpan').text(data.seq);
			$('#idSpan').text(data.id);
			$('#hitSpan').text(data.hit);
			$('#contentSpan').text(data.content);
			
			//작성한 사람만이 글수정, 글삭제 보이게 한다
			if(data.memId == data.id)
				$('#boardViewSpan').show();
			else
				$('#boardViewSpan').hide();
		},
		error: function(err){
			console.log(err);
		}
	});
});
</script>

<script type="text/javascript">
function mode(num){
	if(num == 1){
		document.getElementById('boardViewForm').method = 'post';
		document.getElementById('boardViewForm').action = '/MQBProject/board/boardModifyForm.do';
		document.getElementById('boardViewForm').submit();
		
	}else if(num == 2){ //웹에서는 딜리트폼에서 비번 확인 후 삭제해야 함, 삭제할 때는 무조건 1페이지로 가고, seq만 필요
		document.getElementById('boardViewForm').method = 'post';
		//document.getElementById('boardViewForm').action = '/MQBProject/board/boardDeleteForm.do';
		document.getElementById('boardViewForm').action = '/MQBProject/board/boardDelete.do';
		document.getElementById('boardViewForm').submit();
		
	}
}
</script>
