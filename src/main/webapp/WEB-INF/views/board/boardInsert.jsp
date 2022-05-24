<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardInsert</title>
</head>
<body>
	<h1>글쓰기</h1>
	<a href="/">홈으로</a> &emsp;
	<a href="/boardList">목록으로</a> &emsp;
	<form action="/boardInsert" method="post">
		제목 : <input type="text" name="b_title"><br>
		작성자 : <input type="text" name="b_writer" value="${sessionScope.m_id}" readonly><br>
		내용 : <textarea name="b_content"></textarea>
		<input type="submit" value="작성하기">
	</form>
</body>
</html>