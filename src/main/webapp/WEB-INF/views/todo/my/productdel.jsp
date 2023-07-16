<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

</style>
</head>
<body>

	<form method="POST" name="prdel" action="/pms/todo/my/productdel.do">
		<input type="hidden" name="prseq" value="${seq}">
	</form>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script>

	var ment = "정말 삭제하시겠습니까?";
	
	
	if (confirm("정말 삭제하시겠습니까??") == true) { //확인

		document.prdel.submit();
	}
	
	

</script>
</body>
</html>