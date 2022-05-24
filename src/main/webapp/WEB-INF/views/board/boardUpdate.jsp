<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>글 수정하기</h1>
	<a href="/">홈으로</a> &emsp;
	<a href="/boardList">목록으로</a> &emsp;
	<a href="/boardRead?b_no=${dto.b_no}">돌아가기</a> &emsp;
	
	<form action="/boardUpdate" method="post">
	
	<input type="hidden" name="b_no" value="${dto.b_no}">
	<h3>제목 : <input type="text" name="b_title" value="${dto.b_title}"></h3>
	<h3>작성자 : <input type="text" name="b_writer" value="${dto.b_writer}" readonly="readonly"></h3>
	<h3>내용 : <textarea name="b_content">${dto.b_content}</textarea></h3>
	
	<input type="submit" value="수정하기">
	
	</form>
	
	

</body>
</html>