<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회</title>
</head>
<body>
	<div id="nav">
 		<%@ include file="../include/nav.jsp" %>
	</div>

	<h2>${view.title}</h2>
	
	<hr />
	<div class="writer">
		<span>작성자 : </span>${view.writer}
	</div>
	
	<hr />
	
	<div class="content">
		${view.content}
	</div>
	
	<hr />
	<div>
		<a href="/board/modify?bno=${view.bno }">게시물 수정</a>
		<a href="/board/delete?bno=${view.bno }">게시물 삭제</a>
		<a href="javascript:window.history.back()">되돌아가기</a>
	</div>
</body>
</html>