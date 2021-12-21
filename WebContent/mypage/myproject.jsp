<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<link href="css/myproject.css" rel="stylesheet">


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
							<a href="mypage.do">
								<div class="absoluteid1-2">
									후원자 페이지
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
										내 계정 <img src="img/제목 없음-2.png">
									</div>
									<div class="container2-1_box_id">
										${User.name}
									</div>
								</div>
							</a>
						</div>
						<div class="container2-1-1-2">
								<div class="container2-1_box2">
									내 프로젝트
								</div>
							<a href="myproject.do">
								<div class="container2-1_box1" style="color:#3aa3e3; background:#edf6fc;">
									프로젝트 준비 (${count1})
								</div>
							</a>
							<a href="myproject2.do">
								<div class="container2-1_box1">
									프로젝트 진행중 (${count2})
								</div>
							</a>
							<a href="myproject3.do">
								<div class="container2-1_box1">
									프로젝트 종료 (${count3})
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
							<h4>내 프로젝트</h4>
						</div>
						<div class="container2-2-1-2">
						</div>
					</div>
					<div class="container2-2-1">
						<a href="myproject.do">
							<div class="container2-2-1-3">
								<strong>프로젝트 준비</strong>
							</div>
						</a>
						<a href="myproject2.do">
							<div class="container2-2-1-4 container-hover">
								<strong>프로젝트 진행중</strong>
							</div>
						</a>
						<a href="myproject3.do">
							<div class="container2-2-1-5 container-hover" style="border-right: 0px;">
								<strong>프로젝트 종료</strong>
							</div>
						</a>						
					</div>
					<input type="hidden" name="id" id="id" class="id" value="${User.id}">
					<div style="width:100%; height:699px;"> 
					<c:choose>
						<c:when test="${not empty list}">
						<c:forEach var="list" items="${list}">
							<div class="container2-2-2">
								<div class="container2-2-2-1">
									<img src="projectupload/${list.pname1}">
								</div>
									<c:choose>
										<c:when test="${list.pgrade == 0}">
										<div class="container2-2-2-2" style="margin-top:20px;">
											<strong><a href="projectview.do?pno=${list.pno}">${list.pname2}</a></strong>
											<span id="msg1" style="color:#f00; border:1px solid #f00;">반려됨</span>
										</div>
										</c:when>
										<c:when test="${list.pgrade == 1}">
										<div class="container2-2-2-2" style="margin-top:20px;">
											<strong><a href="projectview.do?pno=${list.pno}">${list.pname2}</a></strong>
											<span id="msg1" style="color:#f00; border:1px solid #f00;">검토중</span>
										</div>
										</c:when>
										<c:otherwise>
										<div class="container2-2-2-2" style="margin-top:40px;">
											<strong><a href="projectrelease.do?pno=${list.pno}">${list.pname2}</a></strong>
											<span id="msg1" style="color:#f00; border:1px solid #f00;">승인됨</span>
										</div>
										</c:otherwise>
									</c:choose>
								<div class="container2-2-2-3">
									<strong>${list.pcontent1}</strong>
								</div>
								<div class="container2-2-2-4">
									작성일: ${list.adate.substring(0,10)} | 공개일: ${list.odate.substring(0,10)} | 종료일: ${list.gdate.substring(0,10)}
								</div>
								<div class="container2-2-2-5">
									후원금액: <fmt:formatNumber value="${list.nowmoney}" pattern="#,###"/>원 | 목표금액: <fmt:formatNumber value="${list.pmoney}" pattern="#,###"/>원 
								</div>
								<div class="container2-2-2-6"">
								<c:choose>
									<c:when test="${list.pgrade == 0 || list.pgrade == 1}">
										<a class="pointer projdelebtn" pno="${list.pno}" onclick="deletePro()">
											<button style="background: #fa3535; color:white;">프로젝트 삭제하기</button>
										</a> 
									</c:when>
									<c:otherwise>
									</c:otherwise>
								</c:choose>
									<button style="display:none;">배송현황</button> <button style="display:none;">후원자 확인</button>
								</div>
							</div>
						</c:forEach>
						</c:when>
						<c:when test="${empty list}">
							<div class="container2-2-2">
								<strong>신청한 프로젝트가 없어요...</strong>
							</div>
						</c:when>
					</c:choose>
					</div>
					<div class="container2-2-1" style="	text-align:center; border-top:1px solid #dbdbdb;">
						<nav>
						 <ul class="pagination">
						  <c:set var="num" value="${count-((pagemaker.cri.pageNum-1)*3)}"/>
							<li class="#"><a href="myproject.do?pageNum=${pagemaker.startPage}&amount=3" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>

						  <c:forEach var="num" begin="${pagemaker.startPage}" end="${pagemaker.endPage}">
							<li class=""><a href="myproject.do?pageNum=${num}&amount=3">
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
				<script>
					function deletePro(){
						if(confirm("정말 프로젝트를 삭제하시겠습니까?")){
							var delepno = $(".projdelebtn").attr("pno");
							ggform.method="post";
							ggform.pno.value=delepno;
							ggform.action="projectdelete.do";
							ggform.submit();
						}
					}
				</script>
			</div>
		</section>
		<form name="ggform">
			<input type="hidden" name="pno" >
		</form>

<%@ include file="../footer.jsp"%>