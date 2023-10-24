<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
<body>
	<div id="nav">
 		<%@ include file="../include/nav.jsp" %>
	</div>

	<form method="post">
		<label>제목</label>
		<input type="text" name="title" value="${view.title}" /><br />
		
		<label>작성자</label>
		<input type="text" name="writer" value="${view.writer}"/><br />
		
		<label>내용</label>
		<!-- textarea는 안에 값을 바로 넣어줘야함 -->
		<textarea cols="50" rows="5" name="content" >${view.content}</textarea><br />
		<button type="submit">수정완료</button>
	</form>
</body>
</html>