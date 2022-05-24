<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
</head>
<body>

	<h1>회원 정보</h1>
	<form action="/memberUpdate" method="post">
	<a href="/">홈으로</a> &emsp;
	<a href="/memberList">목록으로</a> &emsp;
	<a href="/memberRead?m_no=${dto.m_no}">돌아가기</a> &emsp;
	<input type="hidden" name="m_no" value="${dto.m_no}">
	<h3>아이디 : <input type="text" name="m_id" value="${dto.m_id}"></h3> 
	<h3>주소 : <input type="text" name="m_address" value="${dto.m_address}"></h3>
	<h3>가입일 : <fmt:formatDate value="${dto.m_regDate}" pattern="yy년 MM월 dd일  aHH:ss"/></h3> 
	<input type="submit" value="수정하기">
	</form>
	
</body>
</html>