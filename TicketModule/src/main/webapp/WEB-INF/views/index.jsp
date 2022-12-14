<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>  기본 페이지 </h1>
<a class="btn btn-primary" href="<c:url value="/crawling"/>">Jsoup 크롤링하러가기</a>
<a class="btn btn-primary" href="<c:url value="/selenium"/>">셀레니움 크롤링하러가기</a>
<a class="btn btn-primary" href="<c:url value="/list"/>">Jsoup 리스트보기</a>
<a class="btn btn-primary" href="<c:url value="/seleniumList"/>">셀레니움 리스트보기</a>
</body>
</html>
