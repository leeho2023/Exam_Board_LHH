<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
</head>
<body>
	<h1>게시판</h1>
	<a href="/">홈으로</a> &emsp;
	<c:if test="${not empty sessionScope.m_id}">
		<a href="/boardInsert">글쓰기</a>
	</c:if>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>등록일</td>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.b_no}</td>
				<td><a href="/boardRead?b_no=${list.b_no}">${list.b_title}</a></td>
				<td>${list.b_writer}</td>
				<td><fmt:formatDate value="${list.b_regDate}" pattern="yy년 MM월 dd일 EE요일 hh시 mm분"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>