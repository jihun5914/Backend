<%@page import="cs.dit.member.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cs.dit.member.MemberDAO"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix ="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  

<!DOCTYPE html>
<html>
<head>
  <title>사용자 목록</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container"><br>	
	<h1 class="text-center font-weight-bold">사용자 정보</h1>
	<br>
	<table class="table table-hover">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>비밀번호</th>
		</tr>
	
	<c:forEach var="dto" items="${dtos}">
		<tr>
			<td><a href="updateForm.do?id=${dto.id }">${dto.id }</a></td>
			<td>${dto.name }</td>
			<td>${dto.pwd }</td>
		</tr>

	</c:forEach>
	</table>
	</div>	
	
	<div class="d-flex justify-content-center">
	  <ul class="pagination">
	  	<!-- Prev -->
	  	<c:if test="${startNum<=1}">
	    	<li class="page-item"><a class="page-link" style="color:gray" href="#" onclick="alert('이전 페이지 없습니다.')">Prev</a></li>
			</c:if>
			<c:if test="${startNum>1}">
	    	<li class="page-item"><a class="page-link" href="list.do?p=${startNum-1}" >Prev</a></li>
			</c:if>
			
			<!-- 페이지 링크 -->
			<c:forEach var="i" begin="0" end="${numOfPages-1}" step="1">
				<c:if test="${startNum+i <= lastNum}">
					<c:if test="${startNum+i ==p }">
	    			<li class="page-item active"><a class="page-link" href="list.do?p=${startNum+i}">${startNum+i}</a></li>
	    		</c:if>
	    		<c:if test="${startNum+i !=p }">
	    			<li class="page-item"><a class="page-link" href="list.do?p=${startNum+i}">${startNum+i}</a></li>
	    		</c:if>
	    	</c:if>
			</c:forEach>
			
			
			<!-- Next -->
			<c:if test="${startNum+numOfPages>lastNum}">
	    	<li class="page-item"><a class="page-link" style="color:gray" href="#" onclick="alert('다음 페이지 없습니다.')">Next</a></li>
	    </c:if>
	    <c:if test="${startNum+numOfPages<=lastNum}">
	    	<li class="page-item"><a class="page-link" href="list.do?p=${startNum+numOfPages}">Next</a></li>
	    </c:if>
	  </ul>
</div>
	
</body>
</html>