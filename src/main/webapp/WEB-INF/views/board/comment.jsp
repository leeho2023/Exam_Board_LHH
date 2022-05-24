<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:forEach var="list" items="${list}">
<tr>
    <td>${list.c_writer}</td>
    <td>${list.c_content}</td>
    <td><fmt:formatDate value="${list.c_regDate}" pattern="yy년 MM월 dd일 EE요일 hh시 mm분"/></td>
    <c:if test="${sessionScope.m_id eq list.c_writer}">
    	<td> <input type="button" onclick="testfunc(${list.c_no})" value="삭제하기"> </td>
    </c:if>
</tr>
</c:forEach>