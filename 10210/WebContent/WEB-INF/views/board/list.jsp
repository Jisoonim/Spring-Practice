<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> LIST Page</h1>

	<c:forEach var="list" items="${list}" varStatus="status">
		<a href="/board/text?num=${list.bno}&page=${dto.page}&amount=${dto.amount}">
			<p>${list} : <c:out value="${list}" /></p>
		</a>
	</c:forEach>
	
	<form method="get" action="/board/list">
		<c:forEach var="i" begin="1" end="${pageCount}" varStatus="status">
				<button name='page' value=${status.index}>${status.index}</button>
		</c:forEach>
		<select name='amount'>
			<option value='10'>10
			<option value='20'>20
			<option value='30'>30
		</select>
		<button>page이동</button>
	</form>
	
</body>
</html>