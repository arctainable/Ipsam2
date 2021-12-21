<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<link href="css/mypage.css" rel="stylesheet">   



<section>
			<div class="container2">
				<div class="container2-1">
					<div class="container2-1-1">
						<div class="absoluteid1">
							<a href="profile.do">
								<div class="absoluteid1-1">
									프로필 변경
								</div>
							</a>
							<a href="myproject.do">
								<div class="absoluteid1-2">
									창작자 페이지
								</div>
							</a>
						</div>
						<div class="container2-1-1-1">
							<a href="#">
								<div class="container2-1_box0">
									<div class="container2-1_box0_img">
										<img class="user-photo" src="memberprofile/${User.profile}" >
									</div>
									<div class="container2-1_box2">
										내 계정 <img src="img/제목 없음-1.png">
									</div>
									<div class="container2-1_box_id">
										${User.name}
									</div>
								</div>
							</a>	
						</div>
						<div class="container2-1-1-2">
								<div class="container2-1_box2">
									후원현황
								</div>
							<a href="mypage.do">
								<div class="container2-1_box1">
									결제 완료 (${count4})
								</div>
							</a>
							<a href="mypage2.do">
								<div class="container2-1_box1">
									배송 완료 (${count5})
								</div>
							</a>
							<a href="News.do">
								<div class="container2-1_box1" style="color:#3aa3e3; background:#edf6fc;">
									커뮤니티 (${countnews})
								</div>
							</a>	
						</div>
					</div>
					<div class="container2-1-2">
						<a href="event.do">
							<div class="container2-1_box1">
								이벤트
							</div>
						</a>
						<a href="faq.do">
							<div class="container2-1_box1">
								FAQ
							</div>
						</a>	
						<a href="notice.do">
							<div class="container2-1_box1">
								공지사항
							</div>
						</a>
					</div>
				</div>
				<div class="container2-2">
				
					<div class="container2-2-1">
						<div class="container2-2-1-1">
							<h4>커뮤니티</h4>
						</div>
						<div class="container2-2-1-2">
	<!-- 					<div class="dropdown">
								<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
									인기순 <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu"
									aria-labelledby="dropdownMenu1">
									<li role="presentation"><a role="menuitem" tabindex="-1" href="#">인기순</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1" href="#">최다 후원순</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1" href="#">최다 금액순</a></li>
									<li role="presentation"><a role="menuitem" tabindex="-1" href="#">마감 임박순</a></li>
								</ul>
							</div> -->	
						</div>
					</div>
					<div style="width:760px; height:750px;">
					<div class="row">
					<c:forEach var="list" items="${list}">
					  <div class="col-sm-6 col-md-4">
						<a href="community.do?pno=${list.pno}&nno=${list.nno}">
							<div class="thumbnail">
							  <img src="projectupload/${list.pname1}" alt="">
							  <div class="caption" style="width:209px; height:124px;">
							  	<h4 style="color:#ff9696;">${list.pname2}</h4>
								<p class="caption_first_p"><strong>${list.id}</strong></p>
								<c:choose>
								<c:when test="${fn:length(list.ncontent) <= 15}">
									<p class="caption_common_p">${list.ncontent}</p>
								</c:when>
								<c:when test="${fn:length(list.ncontent) > 15}">
									<p class="caption_common_p">${list.ncontent.substring(0,15)}...</p>
								</c:when>
								</c:choose>
							  </div>
							  <div style="font-size:8px; text-align:right; margin-right:10px;">작성일: ${list.regdate}</div>
							</div>
							
						</a>
					  </div>
					 </c:forEach>
					</div>
					</div>
					<div class="container2-2-1" style="	text-align:center;">
						<nav>
						  <ul class="pagination">
						  <c:set var="num" value="${count-((pagemaker.cri.pageNum-1)*6)}"/>
							<li class="#"><a href="News.do?pageNum=${pagemaker.startPage}&amount=6" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>

						  <c:forEach var="num" begin="${pagemaker.startPage}" end="${pagemaker.endPage}">
							<li class=""><a href="News.do?pageNum=${num}&amount=6">
							<c:choose>
							<c:when test="${num == 0}">
							1
							</c:when>
							<c:otherwise>
							${num}
							</c:otherwise>
							</c:choose>
							<span class="sr-only"></span></a></li>
						  </c:forEach>
							<li>
							  <a href="myproject.do?pageNum=${pagemaker.endPage}&amount=3" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							  </a>
							</li>
						  </ul>
						</nav>
					</div>
				</div>
								
				<script>
				$('.container2-1-1-1').hover(function(){
					$('.absoluteid1').css('display','inline');
				}, function() {
					$('.absoluteid1').css('display','none');
				});
				$('.absoluteid1').hover(function(){
					$('.absoluteid1').css('display','inline');
				}, function() {
					$('.absoluteid1').css('display','none');
				});
				</script>
				
			</div>
		</section> 
    
    
<%@ include file="../footer.jsp"%>