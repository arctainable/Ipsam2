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
								<div class="container2-1_box1" style="color:#3aa3e3; background:#edf6fc;">
									결제 완료 (${count4})
								</div>
							</a>
							<a href="mypage2.do">
								<div class="container2-1_box1">
									배송 완료 (${count5})
								</div>
							</a>
							<a href="News.do">
								<div class="container2-1_box1">
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
							<h4>후원 현황</h4>
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
					<div class="container2-2-1">
						<a href="mypage.do">
							<div class="container2-2-1-3">
								<strong>결제 완료</strong>
							</div>
						</a>
						<a href="mypage2.do">
							<div class="container2-2-1-4 container-hover" style="border-right: 0px;">
								<strong>배송 완료</strong>
							</div>
						</a>	
					</div>
					<div style="width:100%; height:699px;"> 
					<c:choose>
						<c:when test="${not empty list}">
					<c:forEach var="list" items="${list}">
						<div class="container2-2-2">
							<div class="container2-2-2-1">
								<img src="projectupload/${list.pname1}">
							</div>
							<div class="container2-2-2-2" style="margin-top:30px;">
								<strong><a href="projectview.do?pno=${list.pno}">${list.pname2}</a></strong>
							</div>
							<div class="container2-2-2-3">
								<strong>${list.pcontent1}</strong>
							</div>
							<div class="container2-2-2-4">
								후원일: <span style="color:#565960;">${list.sdate}</span> | 종료일: <span style="color:#565960;">${list.gdate.substring(0,10)}</span>
							</div>
							<div class="container2-2-2-4">
								후원 금액: <span style="color:#565960;"><fmt:formatNumber value="${list.smoney}" pattern="#,###"/>원</span>
							</div>
							<div class="container2-2-2-5">
								배송지 정보:  <span style="color:#565960;">${list.address}</span>
							</div>
							<div class="container2-2-2-6">
								<button style="display:none;">후원 변경</button> <button style="display:none;">배송현황</button> <button style="display:none;">후원 변경</button>
							</div>
						</div>
					</c:forEach>
					</c:when>
					<c:when test="${empty list}">
						<div class="container2-2-2">
							<strong>후원 내역이 없어요...</strong>
						</div>
					</c:when>
					</c:choose>
					</div>
					<div class="container2-2-1" style="	text-align:center;">
						<nav >
						  <ul class="pagination">
						  <c:set var="num" value="${count-((pagemaker.cri.pageNum-1)*3)}"/>
							<li class="#"><a href="mypage.do?pageNum=${pagemaker.startPage}&amount=3" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>

						  <c:forEach var="num" begin="${pagemaker.startPage}" end="${pagemaker.endPage}">
							<li class=""><a href="mypage.do?pageNum=${num}&amount=3">
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
							  <a href="mypage.do?pageNum=${pagemaker.endPage}&amount=3" aria-label="Next">
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