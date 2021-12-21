<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ include file="projectbody.jsp" %>
		
		
		<script type="text/javascript">
			$(function(){
				var offset = $(".project-bar").offset();
				$('html, body').animate({ scrollTop: offset.top}, 800);
			})
		</script>
		
		<section>
			<div class="project-bar">
				<div class="container ">
					<a href="projectview.do?pno=${pvo.pno}">설명</a>
					<a href="community.do?pno=${pvo.pno}"><strong>커뮤니티</strong></a>
				</div>
			</div>
		</section>
		<script type="text/javascript" src="js/emptycheck.js"></script>
		<script>
			function newswrite(){
				if(!chekEmpty(writeform.content,"글 내용을 작성해주세요")) return;
				writeform.method="post";
				writeform.action="projectnewswritepro.do";
				writeform.submit();
			}
		</script>
		
		<section class="content-section">
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<!--  -->
						<div class="project-content mt40">
							<div class="PostEditTitle"> 
								<h3>게시글 작성하기</h3>
							</div>
							<form name="writeform" enctype="multipart/form-data">
								<input type="hidden" name="n_pno" value="${pvo.pno}">
								<textarea name="content" class="summernote"></textarea>
							</form>
							<div class="PostEditLast">
								<div class="pull-right">
									<a href="project-community.jsp" class="register-btn">취소</a>
									<a onclick="newswrite()" class="register-btn pointer">등록 <i class="fas fa-check"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
						<!--  -->
					</div>
					
<!-- 서머노트를 위해 추가해야할 부분 -->
<script src="js/summernote-lite.js"></script>
<script src="lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="css/summernote-lite.css">
<script src="js/getsummernote.js"></script>
					
<%@ include file="projectleg.jsp" %>

		

<%@ include file="../footer.jsp"%>