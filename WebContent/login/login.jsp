<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<link href="css/member.css" rel="stylesheet">

		<script type="text/javascript" src="js/emptycheck.js"></script>
		<script>
			function goLogin(){
				if(!chekEmpty(loginform.id,"아이디를 입력해주세요")) return;
				if(!chekEmpty(loginform.pw,"비밀번호를를 입력해주세요")) return;
				loginform.method = "post";
				loginform.action = "loginpro.do";
				loginform.submit();
			}
		</script>
		
		<section>
			<div class="container">
				<div class="logindiv center-block mt40">
					<h3>로그인</h3>
					<form name="loginform">
						<div class="login-info-div">
							<input type="text" name="id" placeholder="아이디 입력" >
						</div>
						<div class="login-info-div">
							<input type="password" name="pw" placeholder="비밀번호 입력">
						</div>
						<div class="login-submit-div mt40">
							<a onclick="goLogin()" class="pointer">로그인</a>
						</div>
					</form>
					<div class="mt10 small-join">
						<span>잎샘 계정이 없다면? <a href="join.do">가입하러가기</a></span>
					</div>
					<div class="the_line"></div>
					<div class="mt10 small-join">
						<span><a href="">비밀번호를 찾고 계신가요?</a></span>
					</div>
				</div>
			</div>
		</section>
		

	<c:if test="${not empty message }">
		<script>
			//alert("${message}"); 이거는 보안상 해킹당할수 있으니 밑에 것으로 작성하자
			alert('<c:out value="${message}"/>');
		</script>
	</c:if>
	<% session.removeAttribute("message"); %>
<%@ include file="../footer.jsp"%>