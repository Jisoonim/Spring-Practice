<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post">
		<input type="text" name="uid" value="u00"> 
		<input type="text" name="upw" value="p00">
		<input type="text" name="addr[0].zip" value="111">
		<input type="text" name="addr[0].tel" value="222">
		<input type="text" name="addr[1].zip" value="333">
		<input type="text" name="addr[1].tel" value="444">
		<input type="text" name="addr[2].zip" value="555">
		<input type="text" name="addr[2].tel" value="666">
		<button>CLICK</button>
	</form>
</body>
</html>