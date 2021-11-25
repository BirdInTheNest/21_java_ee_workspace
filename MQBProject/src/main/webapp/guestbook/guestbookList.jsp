<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css">
#currentPagingA {
	color: red;
	text-decoration: underline;
}

#pagingA {
	color: black;
	text-decoration: none;
}
</style>

<input type="hidden" id="pg" value="${pg }">

<table id="guestbookListTable" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<td width="100" align="center">작성자</td>
		<td width="100" align="center">이메일</td>
		<td width="300" align="center">제목</td>
		<td width="100" align="center">내용</td>
	</tr>
	
</table>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/MQBProject/js/guestbookList.js"></script>