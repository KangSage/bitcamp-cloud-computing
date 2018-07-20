<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="bitcamp.pms.domain.Member"%>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='UTF-8'>
    <title>강의 목록</title>
</head>
<body>
<h1>강의 목록</h1>
<p><a href='form.jsp'>새 강의</a></p>
<table border='1'>
    <tr>
        <th>번호</th><th>강의명</th><th>기간</th><th>강의실</th>
    </tr>
    <c:forEach items="${list}" var="classroom">
    <tr>
        <td>1</td>
        <td><a href='view/${classroom.no}'>${classroom.title}</a></td>
        <td>${classroom.startDate}~${classroom.endDate}</td>
        <td>${classroom.room}</td>
    </tr>
    </c:forEach>
</table>
<div>
    <c:if test="${page > 1}">
        <a href="list?page=${page - 1}&size=${size}">[이전]</a>
    </c:if>
    <c:if test="${page <= 1}">
        [이전]
    </c:if>
    <span>${page}</span>
    <c:if test="${page < totalPage}">
        <a href="list?page=${page + 1}&size="${size}">[다음]</a>
    </c:if>
    <c:if test="${page >= totalPage}">
        [다음]
    </c:if>

</div>
</body>
</html>
