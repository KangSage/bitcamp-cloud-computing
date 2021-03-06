<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
     contentType="text/html; charset=UTF-8"
     pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='UTF-8'>
    <title>팀 목록</title>
</head>
<body>
<h1>팀 목록입니다.</h1>
<p><a href='form.jsp'>새 팀</a></p>
<table border='1'>
    <tr>
        <th>팀명</th>
        <th>최대인원</th>
        <th>기간</th>
    </tr>
    <c:forEach items="${list}" var="team">
    <tr>
        <td><a href='view/${team.name}'>${team.name}</a></td>
        <td>${team.maxQuantity}</td>
        <td>${team.startDate}~${team.endDate}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
