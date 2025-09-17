<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f5f5f5;
    }
    .container {
        max-width: 800px;
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
    .form-group {
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
        color: #333;
    }
    input[type="text"], textarea {
        width: 100%;
        padding: 12px;
        border: 2px solid #ddd;
        border-radius: 5px;
        font-size: 16px;
        box-sizing: border-box;
    }
    input[type="text"]:focus, textarea:focus {
        border-color: #4CAF50;
        outline: none;
    }
    textarea {
        height: 200px;
        resize: vertical;
    }
    .btn {
        background-color: #4CAF50;
        color: white;
        padding: 12px 24px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        margin-right: 10px;
    }
    .btn:hover {
        background-color: #45a049;
    }
    .btn-cancel {
        background-color: #f44336;
    }
    .btn-cancel:hover {
        background-color: #d32f2f;
    }
    .button-group {
        text-align: center;
        margin-top: 30px;
    }
</style>
</head>
<body>
<div class="container">
    <h1>✏️ 새 글 작성</h1>
    
    <form action="boardInsert.do" method="post">
        <div class="form-group">
            <label for="subject">📋 제목</label>
            <input type="text" id="subject" name="subject" required 
                   placeholder="제목을 입력하세요">
        </div>
        
        <div class="form-group">
            <label for="writer">👤 작성자</label>
            <input type="text" id="writer" name="writer" required 
                   placeholder="작성자명을 입력하세요">
        </div>
        
        <div class="form-group">
            <label for="content">📝 내용</label>
            <textarea id="content" name="content" required 
                      placeholder="내용을 입력하세요"></textarea>
        </div>
        
        <div class="button-group">
            <button type="submit" class="btn">💾 저장</button>
            <button type="button" class="btn btn-cancel" 
                    onclick="location.href='boardList.do'">❌ 취소</button>
        </div>
    </form>
</div>
</body>
</html>