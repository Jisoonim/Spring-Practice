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
		<button value=page>����Ʈ�� ����</button>
	</form>
	<form method="get" action="/board/retext">
		<button>����/����</button>
	</form>
</body>
</html>