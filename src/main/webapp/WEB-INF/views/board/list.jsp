<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록</title>
</head>
	<body>
	<div id="nav">
 		<%@ include file="../include/nav.jsp" %>
	</div>
	
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>작성자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list }" var="board">
					<tr>
						<td>${board.bno }</td>
						<td>
							<a href="/board/view?bno=${board.bno }">${board.title }</a>
						</td>
						<td>
							<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd(E)" />
						</td>
						<td>${board.writer }</td>
						<td>${board.viewCnt }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>