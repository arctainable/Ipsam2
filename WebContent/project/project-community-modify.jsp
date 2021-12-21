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
			function modifyPro(){
				if(!chekEmpty(modifyform.content,"글 내용을 작성해주세요")) return;
				modifyform.method="post";
				modifyform.action="newsmodifypro.do";
				modifyform.submit();
			}
		</script>
		
		<section class="content-section">
			<div class="container">
				<div class="row">
					<div class="col-md-8">
						<!--  -->
						<div class="project-content mt40">
							<div class="PostEditTitle">
								<h3>게시글 수정하기</h3>
							</div>
							<form name="modifyform" enctype="multipart/form-data">
								<input type="hidden" name="pno" value="${pvo.pno}">
								<input type="hidden" name="nno" value="${nvo.nno}">
								<textarea name="content" class="summernote">${nvo.ncontent}</textarea>
							</form>
							<div class="PostEditLast">
								<div class="pull-right">
									<a href="community.do?pno=${pvo.pno}" class="register-btn">취소</a>	
									<a class="register-btn pointer" onclick="modifyPro()">등록 <i class="fas fa-check"></i></a>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
						<!--  -->
					</div>
					
<%@ include file="projectleg.jsp" %>

<!-- 서머노트를 위해 추가해야할 부분 -->
<script src="js/summernote-lite.js"></script>
<script src="lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="css/summernote-lite.css">
<script src="js/getsummernote.js"></script>
		


<%@ include file="../footer.jsp"%>