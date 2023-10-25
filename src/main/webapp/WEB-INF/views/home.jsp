<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	헬로우 월드
</h1>

<P>  The time on the server is ${serverTime}. </P>

<p><a href="/board/list">게시물 목록</a></p>
<p><a href="/board/write">게시물 작성</a></p>
<p><a href="/board/listPage?num=1">게시물 페이징</a></p>
<p><a href="/board/listPageSearch?num=1&searchType=no">게시물 페이징(+검색)</a></p>
<!-- <p><a href="/book/list">책 목록</a></p> -->
</body>
</html>
