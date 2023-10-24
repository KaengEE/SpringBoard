<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 목록</title>
</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>책id</th>
					<th>제목</th>
					<th>카테고리</th>
					<th>가격</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${book }" var="book">
					<tr>
						<td>${book.book_id }</td>
						<td>${book.title }</td>
						<td>${book.category }</td>
						<td>${book.price }</td>
						<td>${book.insert_date }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>