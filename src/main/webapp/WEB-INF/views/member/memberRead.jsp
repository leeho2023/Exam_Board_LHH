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
	<a href="/">홈으로</a> &emsp;
	<a href="/memberList">목록으로</a> &emsp;
	<a href="/memberUpdate?m_no=${dto.m_no}">수정하기</a>
	<h3>아이디 : ${dto.m_id}</h3>
	<h3>주소 : ${dto.m_address}</h3>
	<h3>가입일 : ${dto.m_regDate}</h3>
	
</body>
</html>