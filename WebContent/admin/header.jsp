<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
		<title>잎샘 관리자</title>
	
		<!-- 부트스트랩 -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!-- 폰트어썸 -->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
		
		<link href="css/admincommon.css" rel="stylesheet">

		
		
		<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
		<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
		<!--[if lt IE 9]>
		      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	    
		<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
		<script src="js/jquery-3.3.1.min.js"></script>
		<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
		<script src="js/bootstrap.min.js"></script>
		
		
	</head>
	<body>
		<header>
			<div class="adminheader">
				<nav>
					<div class="container">
						<div class="pull-left adminmaingo">
							<a href="admin.do">
								<img class="sitelogo" src="img/ipSam.png">
							</a>
						</div>
						<div class="pull-right">
							<a class="admin_header_a" href="main.do">잎샘 메인페이지 가기</a>
							<span class="admin_header_span">
							<i class="fas fa-user"></i> 관리자 ${User.id} 님
							</span>
							<a class="admin_logout" href="logout.do">로그아웃</a>
						</div>
						<div class="clearfix"></div>
					</div>
				</nav>
			</div>
 		   <script src="js/scrollup.js"></script>
			<button type="button" name="button" class="ac-sub-go-top"><i class="fas fa-arrow-up"></i></button>
			<div class="clearboth"></div>
		</header>
		
		
				<section class="adminsection ">
			<div class="container admincontainer ">
				<div class="row mt80">
					<div class="col-md-3">
						<div class="amdinmenudiv">
							<div class="amdinmenu">
								<a href="project-manger.do">프로젝트 관리하기</a>
							</div>
							<div class="amdinmenu">
								<a href="member-manger.do">회원 관리하기</a>
							</div>
							<div class="amdinmenu">
								<a href="notice-manger.do">게시물 관리하기</a>
							</div>
						</div>
					</div>			