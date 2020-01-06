<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>${vo}</h1>
	
	<form method="get" action="/board/list">
		<button value=page>리스트로 가기</button>
	</form>
	<form method="get" action="/board/retext">
		<button>수정/삭제</button>
	</form>
</body>
</html>