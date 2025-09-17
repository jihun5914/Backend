<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f5f5f5;
    }
    .container {
        max-width: 900px;
        margin: 0 auto;
        background-color: white;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    }
    h1 {
        text-align: center;
        color: #333;
        margin-bottom: 30px;
    }
    .post-header {
        background-color: #f8f9fa;
        padding: 20px;
        border-radius: 8px;
        margin-bottom: 20px;
        border-left: 5px solid #4CAF50;
    }
    .post-title {
        font-size: 24px;
        font-weight: bold;
        color: #333;
        margin-bottom: 15px;
    }
    .post-info {
        color: #666;
        font-size: 14px;
    }
    .post-info span {
        margin-right: 20px;
    }
    .post-content {
        background-color: white;
        padding: 30px;
        border: 1px solid #e0e0e0;
        border-radius: 8px;
        margin-bottom: 30px;
        min-height: 200px;
        line-height: 1.6;
        font-size: 16px;
    }
    .btn {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        text-decoration: none;
        border-radius: 5px;
        display: inline-block;
        margin: 5px;
        border: none;
        cursor: pointer;
        font-size: 14px;
    }
    .btn:hover {
        background-color: #45a049;
    }
    .btn-danger {
        background-color: #f44336;
    }
    .btn-danger:hover {
        background-color: #d32f2f;
    }
    .btn-secondary {
        background-color: #6c757d;
    }
    .btn-secondary:hover {
        background-color: #5a6268;
    }
    .button-group {
        text-align: center;
        margin-top: 30px;
    }
    .icon {
        margin-right: 5px;
    }
</style>
</head>
<body>
<div class="container">
    <h1>📖 게시글 상세보기</h1>
    
    <div class="post-header">
        <div class="post-title">${dto.subject}</div>
        <div class="post-info">
            <span><strong>👤 작성자:</strong> ${dto.writer}</span>
            <span><strong>📅 작성일:</strong> ${dto.regdate}</span>
            <span><strong>🔢 번호:</strong> ${dto.bcode}</span>
        </div>
    </div>
    
    <div class="post-content">
        ${dto.content}
    </div>
    
    <div class="button-group">
        <a href="boardUpdateForm.do?bcode=${dto.bcode}" class="btn">
            <span class="icon">✏️</span>수정
        </a>
        <button onclick="deletePost()" class="btn btn-danger">
            <span class="icon">🗑️</span>삭제
        </button>
        <a href="boardList.do" class="btn btn-secondary">
            <span class="icon">📋</span>목록으로
        </a>
    </div>
</div>

<script>
function deletePost() {
    if(confirm("정말 삭제하시겠습니까?")) {
        location.href = "boardDelete.do?bcode=${dto.bcode}";
    }
}
</script>
</body>
</html>