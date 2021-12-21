<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

	<section>
			<div class="container">
				<div class="order-complete mt90">
					<h1 class="congratu">축하합니다. ${count} 번째</h1>
					<h1>'${pvo.pname2}' 의</h1>
					<h1>공식 후원자가 되셨습니다!</h1>
					<div class="complete-gobtn mt40">
						<a href="main.do" class="mainBack_button">메인 페이지로 가기</a>
						<a href="mypage.do" class="project_list_button">후원한 프로젝트 목록 보기</a>
					</div>
				</div>
			</div>
		</section>
		


<%@ include file="../footer.jsp"%>