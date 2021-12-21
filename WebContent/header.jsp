<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>잎샘</title>

<!-- 부트스트랩 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- 폰트어썸 -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">

<link href="css/common.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">


<link href="css/projectlayout.css" rel="stylesheet">

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
		<div class="container-fluid">
			<nav>
				<div class="container" style="margin-top:10px;">
					<div class="pull_left">
						<a href="main.do"><img src="img/잎샘.png" id="logo"></a>
					</div>
					<div class="logobox_left">
						<a href="project.do"><h4>프로젝트 목록</h4></a>
						<a href="apply.do"><h4>프로젝트 올리기</h4></a>
					</div>

					<div class="pull_right">
						<!--  <img src="img/user-account.png" id="mem_img">-->
					</div>
					<div class="logobox_right">
						<c:choose>
							<c:when test="${User.grade eq 1}">
								<a href="logout.do" onclick="return confirm('정말 로그아웃 하시나요?')"><h4>로그아웃</h4></a>
								<a href="mypage.do"><h4>마이페이지</h4></a>
							</c:when>
							<c:when test="${User.grade eq 3 }">
								<a href="admin.do"><h4>관리자페이지</h4></a>
								<a href="logout.do" onclick="return confirm('정말 로그아웃 하시나요?')"><h4>로그아웃</h4></a>
								<a href="mypage.do"><h4>마이페이지</h4></a>
							</c:when>
							<c:otherwise>
								<a href="login.do"><h4>로그인</h4></a>
								<a href="join.do"><h4>회원가입</h4></a>
							</c:otherwise>
						</c:choose>
					</div>
					<div class="Sbar">
						<form name="serchform" method="get" action="project.do" >
							<c:choose>
								<c:when test="${empty word}">
									<input type="text" name="word" placeholder="검색하세요">
								</c:when>
								<c:when test="${not empty word}">
									<input type="text" name="word" placeholder="검색하세요" value="${word}" >
								</c:when>
							</c:choose>
						</form>
						<i class="fas fa-search"></i>
					</div>
				</div>
			</nav>
		</div>
		<script src="js/scrollup.js"></script>
		<button type="button" name="button" class="ac-sub-go-top">
			<i class="fas fa-arrow-up"></i>
		</button>
		<div class="clearboth"></div>
	</header>
    