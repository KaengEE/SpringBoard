<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록 + 페이징 + 검색</title>
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
		
		<div>
	 <%--<c:forEach begin="1" end="${pageNum}" var="num">
		    <span>
		     <a href="/board/listPage?num=${num}">${num}</a>
		  </span>
		 </c:forEach> --%>
		 
			<c:if test="${page.prev}">
				<span>[ <a href="/board/listPageSearch?num=${page.startPageNum - 1}&searchType=${searchType}&keyword=${keyword}">이전</a> ]</span>
			</c:if>
			
			<c:forEach begin="${page.startPageNum}" end="${page.endPageNum}" var="num">
				<span>
					<c:if test="${select != num }">
			 			<a href="/board/listPageSearch?num=${num}&searchType=${searchType}&keyword=${keyword}">${num}</a> 
					</c:if>
					<c:if test="${select == num }">
						<b>${num }</b>
					</c:if>
				</span>
			</c:forEach>
			
			<c:if test="${page.next}">
				<span>[ <a href="/board/listPageSearch?num=${page.endPageNum + 1}&searchType=${searchType}&keyword=${keyword}">다음</a> ]</span>
			</c:if>
		</div>
		
		
		<!-- 검색창 -->
		<form method="get">
		 <select name="searchType">
		     <option value="title" <c:if test="${searchType eq 'title'}">selected</c:if>>제목</option>
		     <option value="content" <c:if test="${searchType eq 'content'}">selected</c:if>>내용</option>
		     <option value="title_content" <c:if test="${searchType eq 'title_content'}">selected</c:if>>제목+내용</option>
		     <option value="writer" <c:if test="${searchType eq 'writer'}">selected</c:if>>작성자</option>
		 </select>
		 
			<input type="text" name="keyword" value="${keyword }" />
			<button type="submit">검색</button>
		</form>
		
		
		<!-- 페이지숫자가 넘어가면? -->
		<c:if test="${select > page.endPageNum }">
			<% out.println("<script>");
			   out.println("alert('존재하지 않는 페이지 입니다!')");
			   out.println("history.back()");
			   out.println("</script>");%>
		</c:if>

	</body>
</html>