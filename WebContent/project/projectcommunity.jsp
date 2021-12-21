<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

 		
<%@ include file="projectbody.jsp" %>
		
		<section>
			<div class="project-bar">
				<div class="container ">
					<a href="projectview.do?pno=${pvo.pno}">설명</a>
					<a href="community.do?pno=${pvo.pno}"><strong>커뮤니티</strong></a>
				</div>
			</div>
		</section>
		
		
		<script type="text/javascript">
			$(function(){
				var offset = $(".project-bar").offset();
				$('html, body').animate({ scrollTop: offset.top}, 800);
			})
		</script>
		<script>
			function gowrite(){
				gowriteform.method="post"
				gowriteform.action="projectnewswrite.do";
				gowriteform.submit();
			}
		</script>
		<form name="gowriteform" >
			<input type="hidden" name="pno" value="${pvo.pno}">
		</form>
		
		<section class="content-section">
			<div class="container">
				<div class="row mb100">
					<div class="col-md-8">
						<div class="project-content mt40">
							<div class="rmfTmrldiv">
								<div class="pull-left">
								<c:choose>
									<c:when test="${empty User}">
										<img class="user-photo" src="img/user-account.png" >
										<span>로그인 후 이용 가능합니다</span>
									</c:when>
									<c:when test="${not empty User}">
										<img class="user-photo" src="memberprofile/${User.profile}" >
										<span>창작자만 이용 가능합니다</span>
									</c:when>
								</c:choose>
								</div>
								<div class="pull-right">
									<c:if test="${pvo.id == User.id}">
									<button type="button" class="community_wb" onclick="gowrite()">글쓰기</button>
									</c:if>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
						<!--  -->
						
						<c:choose>
							<c:when test="${empty nlist }">
								<div class="project-content mt40">
									아직 새로운 소식이 없어요 ㅜㅜ
								</div>
							</c:when>
							<c:when test="${not empty nlist }">
								<c:forEach var="nlist" items="${nlist}">
									<div class="project-content mt40">
										<div class="community-card">
										
											<div class="community-card-head">
												<span class="pull-left">
													<img class="user-photo" src="memberprofile/${creator.profile}" >
												</span>
												<div class="commu-write">
													<span class="commu-writer">${nlist.name}</span><br/>
													<span class="commu-writedate">${nlist.regdate}</span>
												</div>
											</div>
											<div class="community-card-body">
												<div class="commu-content">
													${nlist.ncontent}
												</div>
												<div class="gmflrp"></div>
											</div>
										</div>
										<div class="more-content mt20">
											<a href="project-community-view.do?pno=${pvo.pno}&nno=${nlist.nno}" >더 보기</a>
										</div>
										<div class="community-card-foot mt10">
											<i class="fas fa-comment"></i>&nbsp;${nlist.nccount}
										</div>
									</div>
								</c:forEach>
							</c:when>
						</c:choose>
					</div>
					
<%@ include file="projectleg.jsp" %>


<%@ include file="../footer.jsp"%>