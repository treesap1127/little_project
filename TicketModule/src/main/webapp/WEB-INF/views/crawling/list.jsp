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
</head>
<body>
<a class="btn btn-primary" href="<c:url value="/"/>">뒤로가기</a>
<table class="table table-sm" >
	<tr>
		<td>seq</td>
		<td>title</td>
		<td>url</td>
		<td>field</td>
		<td>reserData</td>
	</tr>
	<c:forEach items="${list}" var="item">
	<c:if test="${item.tag eq 1}">
		<tr>
			<td>${item.seq}</td>
			<td style="color:red;"><a href="<c:url value="/view?seq=${item.seq}"/>">${item.title}</a></td>
			<td>${item.url}</td>
			<td>${item.field}</td>
			<td>${item.reserData}</td>
		</tr>
	</c:if>
	</c:forEach>
</table>
</body>
</html>