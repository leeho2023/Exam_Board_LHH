<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/mine.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>


	<h1>글 상세보기</h1>
	<a href="/">홈으로</a> &emsp;
	<a href="/boardList">목록으로</a> &emsp;
	<c:if test="${dto.b_writer eq sessionScope.m_id}">
	<a href="/boardUpdate?b_no=${dto.b_no}">수정하기</a> &emsp;
	</c:if>
	<!-- 삭제하기 부분 -->
	<c:if test="${dto.b_writer eq sessionScope.m_id}">
	<a href="/boardDelete?b_no=${dto.b_no}">삭제</a> &emsp;
	</c:if>
	<!-- 삭제하기 부분 끝 -->
	<input type="hidden" id="b_no" value="${dto.b_no}">
	
	<h3>제목 : ${dto.b_title}</h3>
	<h3>작성자 : ${dto.b_writer}</h3>
	<h3>내용 : ${dto.b_content}</h3>
	<h3>작성일 : <fmt:formatDate value="${dto.b_regDate}" pattern="yy년 MM월 dd일 EE요일 hh시 mm분"/></h3>
	<c:if test="${dto.b_modifyRegDate ne null}">
		<h3>수정일 : <fmt:formatDate value="${dto.b_modifyRegDate}" pattern="yy년 MM월 dd일 EE요일 hh시 mm분"/></h3>
	</c:if>
	
	<br><br>
	<h3>댓글 등록</h3>
       <input type="text" id="c_writer" value="${sessionScope.m_id}" readonly="readonly">&emsp;
       <input type="text" id="c_content" name="c_content"> &emsp;
       <input type="button" id="conmentBtn" value="댓글달기"> &emsp;
       <div id="contentCheck"></div>
      
	
	<table class="table table-striped col-6">
    <thead>
      <tr>
        <td>아이디</td>
        <td>내용</td>
        <td>작성일</td>
        <td>삭제</td>
      </tr>
    </thead>
    <tbody id="commentTable">
    	
    	
    
    </tbody>
  </table>
  
	<br>
	<br>
  	<h4>댓글 등록</h4>
  	<input type="hidden" name="r_boardNum" id="r_boardNum" value="${dto.b_no}">
	작성자 : <input type="text" name="r_writer" id="r_writer" value="${sessionScope.m_id}" readonly="readonly"> &emsp;
	글내용 : <input type="text" name="r_content" id="r_content"> &emsp;
	<input type="button" id="replyRegistBtn" value="댓글달기">
	<br>
	<br>
	<h4>댓글 목록</h4>
	<br>
	<div id="replyShowZone">
	
	</div>
	
<script type="text/javascript" src="${path}/resources/js/reply.js"></script>
<script type="text/javascript" src="${path}/resources/js/mine.js"></script>
</body>
</html>