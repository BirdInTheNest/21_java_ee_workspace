<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
#boardListTable th {
	font-size: 16px;
}

#boardListTable td {
	font-size: 13px;
}

.subjectA:link { color: black; text-decoration: none; }
.subjectA:visited { color: black; text-decoration: none; }
.subjectA:hover { color: darkgreen; text-decoration: underline; }
.subjectA:active { color: black; text-decoration: none; }

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

<input type="hidden" id="pg" value="${requestScope.pg }">

<table id="boardListTable" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="100">작성자</th>
		<th width="100">조회수</th>
		<th width="100">작성일</th>
	</tr>	
</table>
<div style="width: 750px; text-align: center;" id="boardPagingDiv"></div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/MQBProject/js/boardList.js"></script>
<script type="text/javascript">
function boardPaging(param_pg){
	location.href="/MQBProject/board/boardList.do?pg="+param_pg;
}
</script>

