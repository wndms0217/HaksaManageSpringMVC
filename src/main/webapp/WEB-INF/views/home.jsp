<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<!-- CSS link*** -->
<link rel="stylesheet" type="text-css"
	href="${pageContext.request.contextPath}/resources/CSS/style.css">
<title>Home</title>
</head>
<body>
	<br />
	<h1>Welcome To HansungIn</h1>

	<P>The time on the server is ${serverTime}.</P>
	<P>
	<form method="get" action="${pageContext.request.contextPath}/semester">
		<button class="button" style="vertical-align: middle">
			<span>학기별 이수 학점 조회</span>
		</button>
	</form>
	<form method="get" action="${pageContext.request.contextPath}/division">
		<button class="button" style="vertical-align: middle">
			<span>이수 구분별 학점 조회</span>
		</button>
	</form>
	<form method="get"
		action="${pageContext.request.contextPath}/applylecture">
		<button class="button" style="vertical-align: middle">
			<span>수강 신청하기</span>
		</button>
	</form>
	<form method="get"
		action="${pageContext.request.contextPath}/lecturesapplied">
		<button class="button" style="vertical-align: middle">
			<span>수강 신청 조회</span>
		</button>
	</form>

</body>
</html>
