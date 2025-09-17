<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f5f5f5;
    }
    .container {
        max-width: 1000px;
        margin: 0 auto;
        background-color: white;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }
    h1 {
        text-align: center;
        color: #333;
        margin-bottom: 30px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }
    th, td {
        border: 1px solid #ddd;
        padding: 12px;
        text-align: left;
    }
    th {
        background-color: #4CAF50;
        color: white;
        font-weight: bold;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #e8f5e8;
    }
    .btn {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        text-decoration: none;
        border-radius: 5px;
        display: inline-block;
        margin: 5px;
    }
    .btn:hover {
        background-color: #45a049;
    }
    .pagination {
        text-align: center;
        margin-top: 20px;
    }
    .pagination a {
        color: #4CAF50;
        padding: 8px 16px;
        text-decoration: none;
        border: 1px solid #ddd;
        margin: 0 2px;
        border-radius: 3px;
    }
    .pagination a:hover {
        background-color: #4CAF50;
        color: white;
    }
    .pagination .current {
        background-color: #4CAF50;
        color: white;
        padding: 8px 16px;
        border: 1px solid #4CAF50;
        margin: 0 2px;
        border-radius: 3px;
    }
    .button-container {
        text-align: right;
        margin-bottom: 20px;
    }
    .subject-link {
        color: #333;
        text-decoration: none;
    }
    .subject-link:hover {
        color: #4CAF50;
        text-decoration: underline;
    }
</style>
</head>
<body>
<div class="container">
    <h1>📋 게시판</h1>
    
    <div class="button-container">
        <a href="boardInsertForm.do" class="btn">✏️ 글쓰기</a>
        <a href="list.do" class="btn">👥 회원목록</a>
    </div>
    
    <table>
        <thead>
            <tr>
                <th width="10%">번호</th>
                <th width="50%">제목</th>
                <th width="15%">작성자</th>
                <th width="25%">작성일</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="dto" items="${dtos}">
                <tr>
                    <td>${dto.bcode}</td>
                    <td>
                        <a href="boardView.do?bcode=${dto.bcode}" class="subject-link">
                            ${dto.subject}
                        </a>
                    </td>
                    <td>${dto.writer}</td>
                    <td>${dto.regdate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    <!-- 페이지네이션 -->
    <div class="pagination">
        <!-- 이전 페이지 그룹 -->
        <c:if test="${startNum > 1}">
            <a href="boardList.do?p=${startNum-1}">◀ 이전</a>
        </c:if>
        
        <!-- 페이지 번호들 -->
        <c:forEach var="i" begin="${startNum}" 
                   end="${startNum + numOfPages - 1 > lastNum ? lastNum : startNum + numOfPages - 1}">
            <c:choose>
                <c:when test="${i == p}">
                    <span class="current">${i}</span>
                </c:when>
                <c:otherwise>
                    <a href="boardList.do?p=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        
        <!-- 다음 페이지 그룹 -->
        <c:if test="${startNum + numOfPages <= lastNum}">
            <a href="boardList.do?p=${startNum + numOfPages}">다음 ▶</a>
        </c:if>
    </div>
</div>
</body>
</html>