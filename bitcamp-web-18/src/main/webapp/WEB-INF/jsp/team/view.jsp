<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='UTF-8'>
    <title>팀 보기</title>
</head>
<body>
<h1>팀 보기</h1>
<form action='../update' method='post'>
    <table border='1'>
        <c:choose>
            <c:when test="${team == null}">
                <p>해당 팀이 존재하지 않습니다.</p>
            </c:when>
            <c:otherwise>
        <tr>
            <th>팀명</th><td><input type="text" name="name" value='${team.name}' readonly></td>
        </tr>
        <tr>
            <th>설명</th><td><textarea name="description"
                                     rows="6" cols="60">${team.description}</textarea></td>
        </tr>
        <tr>
            <th>최대인원</th><td><input type="number" name="maxQuantity" value='${team.maxQuantity}'></td>
        </tr>
        <tr>
            <th>시작일</th><td><input type="date" name="startDate" value='${team.startDate}'></td>
        </tr>
        <tr>
            <th>종료일</th><td><input type="date" name="endDate" value='${team.endDate}'></td>
        </tr>
            </c:otherwise>
        </c:choose>
    </table>
    <p>
        <a href='../list'>목록</a>
        <button>변경</button>
        <a href='../delete?name=${team.name}'>삭제</a>
        <a href='../task/list?teamName=${team.name}'>작업목록</a>
    </p>
</form>
</body>
</html>

