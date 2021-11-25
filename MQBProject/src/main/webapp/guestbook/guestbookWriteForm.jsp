<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
#guestbookWriteForm div {
	color: red;
	font-size: 8pt;
	font-weight: bold;
}

#guestbookWriteForm table {
	border-collapse: collapse;
}
</style>

<form name="guestbookWriteForm" id="guestbookWriteForm">
	<table border="1" cellspacing="0" cellpadding="5">
		<tr>
			<td width="100" align="center">작성자</td>
			<td>
				<input type="text" name="name" id="name" size="15">
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">이메일</td>
			<td>
				<input type="email" name="email" id="email">
			</td>
		</tr>
		
		<!-- <tr>
			<td width="100" align="center">홈페이지</td>
			<td>
				<input type="text" name="homepage" id="homepage" value="http://" size="35">
			</td>
		</tr> -->
		
		<tr>
			<td width="100" align="center">제목</td>
			<td>
				<input type="text" name="subject" id="subject" size="50">
				<div id= "subjectDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">내용</td>
			<td>
				<textarea name="content" id="content" cols="50" rows="15"></textarea>
				<div id= "contentDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" id="guestbookWriteBtn" value="글작성">
				<input type="reset" value="다시작성">
				<input type="button" value="글목록" 
				onclick="location.href='/MQBProject/guestbook/guestbookList.do?pg=1'">
			</td>
		</tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/MQBProject/js/guestbook.js"></script>


<!-- 
http://localhost:8080/Context명
http://localhost:8080/guestbookJSP/guestbook/guestbookWriteForm.jsp 요청

http://localhost:8080/guestbookJSP/guestbook/guestbookWrite.jsp (절대주소)
					 /guestbookJSP/guestbook/guestbookWrite.jsp
											 guestbookWrite.jsp (상대주소)

---------------------------------------

JSP 에서 page 는 
JAVA 에서 this 와 같다. 

onclick="location.href='guestbookList.jsp?변수=값'"
onclick="location.href='guestbookList.jsp?pg=1'"

 -->













