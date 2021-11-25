<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
#imageboardListTable th {
	font-size: 16px;
}

#imageboardListTable td {
	font-size: 13px;
}

#currentPaging {
	color: red;
	text-decoration: underline;
	cursor: pointer;
	/* border: 1px solid; */
}
#paging {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>

<form id="imageboardDeleteForm" method="post" action="/MQBProject/imageboard/imageboardDelete.do">

<input type="hidden" id="pg" value="${pg }">

<table id="imageboardListTable" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<th width="100"><input type="checkbox" id="all">글번호</th>
		<th width="100">이미지</th>
		<th width="300">상품명</th>
		<th width="150">단가</th>
		<th width="50">개수</th>
		<th width="150">합계</th>
	</tr>	
</table>

<!-- input style="float: left;" 하거나 div style="display: inline-block; 하거나 같은 결과 -->
<input type="button" id="choiceDeleteBtn" value="선택삭제" style="margin-top: 5px;">

<div id="imageboardPagingDiv" style="display: inline-block; width: 850px; text-align: center;"></div>

</form>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/MQBProject/js/imageboardList.js"></script>
<script type="text/javascript">
function imageboardPaging(param_pg){ //사용자함수
	location.href="/MQBProject/imageboard/imageboardList.do?pg="+param_pg;
}

//전체 선택 / 전체 해제
$('#all').click(function(){
	if($('#all').prop('checked'))
		$('.check').prop('checked', true);
	else
		$('.check').prop('checked', false);
});

//선택 삭제
$('#choiceDeleteBtn').click(function(){
	var count = $('.check:checked').length;
	alert(count);
	
	if(count==0)
		alert('삭제 할 항목을 선택하세요.');
	else{
		if(confirm('정말 삭제하시겠습니까?'))
			$('#imageboardDeleteForm').submit();
	}
	
});

</script>







