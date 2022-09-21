<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var context="${pageContext.request.contextPath}";
</script>
<script src="js/make.js"></script>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ticket/park.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ticket/inter.css">
</head>
<body>
		<div class="dataset">
			<label for="URL">URL:</label>
			<input type="text" id="URL" name="URL" placeholder="URL를 입력해주세요"/>
			<label for="title">title:</label>		
			<input type="text" id="title" name="title" placeholder="title를 입력해주세요"/>
			<label for="Field">Field:</label>
			<input type="text" id="field" name="field" placeholder="선택자를 입력해주세요"/>
			<a href="#" class="btn btn-primary" onclick="info()">결과보기!</a>
		</div>
		<div>
		<a href="<c:url value="/"/>" class="btn btn-warning">뒤로가기!</a>
			<h1>아래에 데이터가 나옵니다!</h1>
			<div id="info" style="margin:50px;color:blue;"></div>
		</div>
</body>
</html>