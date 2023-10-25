<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
	
	<!-- 댓글 시작 -->
	<hr />

	<ul>
   <!-- <li>
	        <div>
	            <p>첫번째 댓글 작성자</p>
	            <p>첫번째 댓글</p>
	        </div>
	    </li> -->
	    
	    <c:forEach items="${reply }" var="reply">
	    	<li>
	    		<div>
	    			<p>${reply.writer } / <fmt:formatDate value="${reply.regDate }" pattern="yyyy-MM-dd" /></p>
	    			<p>${reply.content }</p>
	    			
	    			<p>
	    				<a href="/reply/modify?bno=${view.bno }&rno=${reply.rno }">수정</a>
	    				 / 
	    				<a onclick="confirmDelete(${view.bno },${reply.rno })" style="cursor:pointer; text-decoration: underline;">삭제</a>
	    			</p>
	    			
	    			
	    			<hr/>
	    		</div>
	    	</li>
	    </c:forEach>
	</ul>
	

	<form action="/reply/write" method="post">
	    <p>
	        <label>댓글 작성자</label> <input type="text" name="writer">
	    </p>
	    <p>
	        <textarea rows="5" cols="50" name="content"></textarea>
	    </p>
	    <p>
	    	<input type="hidden" name="bno" value="${view.bno }">
	        <button type="submit">댓글 작성</button>
	    </p>
    </form>

	<!-- 댓글 끝 -->
	
	<script>
	function confirmDelete(bno, rno){
	    const check = confirm("정말 삭제하시겠습니까?");
	    if (check) {
	        window.location.href = "/reply/delete?bno="+bno+ "&rno="+rno;
	    } else{
	    	alert("삭제를 취소하였습니다.");
	    }
	}
	</script>
	
</body>
</html>