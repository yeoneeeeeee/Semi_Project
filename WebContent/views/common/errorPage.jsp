<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>7H_The_Town_Error</title>
</head>
<body>
	<h1 align="center" style="color:red;"><%= request.getAttribute("errorMsg") %></h1>
</body>
</html>