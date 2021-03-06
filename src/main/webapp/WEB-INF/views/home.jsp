<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>게시판관리</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<link href="/resources/home.css" rel="stylesheet" >
	<link href="/resources/bell.css" rel="stylesheet" >
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<script src="/resources/pagination.js"></script>
	<script type="text/javascript" src="/resources/chart.js"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
	<div id="page">
		<div id="header">
			<img src="/resources/back.jpg" width=960/>
		</div>
		<div id="menu">
			<span><a href="/">Home</a></span>
			<span><a href="/board/ajax">게시판목록</a></span>
			<span><a href="/user/list">사용자관리</a></span>
			<c:if test="${uid==null}">
				<span style="float:right"><a href="/user/login">로그인</a></span>
			</c:if>
			<c:if test="${uid !=null}">
				<span style="float:right">
					<span>${uid}님</span>
					<a href="/user/logout">로그아웃</a>
				</span>
			</c:if>
		</div>
		<div id="content">
			<jsp:include page="${pageName}"/>
		</div>
		<div id="footer">
			<h3>Copyright 2022. 인천일보 아카데미. All Rights Reserved.</h3>
		</div>
	</div>
</body>
</html>
