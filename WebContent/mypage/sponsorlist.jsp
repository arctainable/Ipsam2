<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<link href="css/mypage.css" rel="stylesheet">
<link href="css/adminsublayout.css" rel="stylesheet">


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
					<div class="container2-1_box2">내 프로젝트</div>
					<a href="myproject.do">
						<div class="container2-1_box1">프로젝트 준비 (${count1})</div>
					</a> <a href="myproject2.do">
						<div class="container2-1_box1">프로젝트 진행중 (${count2})</div>
					</a> <a href="myproject3.do">
						<div class="container2-1_box1">프로젝트 종료   (${count3})</div>
					</a>
				</div>
			</div>
			<div class="container2-1-2">
				<a href="event.do">
					<div class="container2-1_box1">이벤트</div>
				</a> <a href="faq.do">
					<div class="container2-1_box1">FAQ</div>
				</a> <a href="notice.do">
					<div class="container2-1_box1">공지사항</div>
				</a>
			</div>
		</div>
		<div class="container2-2">

			<div class="container2-2-1" >
				<div class="container2-2-1-1">
					<h4>후원목록</h4>
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
				<div class="clearfix"></div>
				<div class="text-center" style="font-size:18px; color:#ff9696;"><strong>${pname2}</strong></div>
			</div>
			<div style="width: 760px; height: 732px;">
				<div class="row">
					<div class="adminbord">
							<div>
								<div class="pull-right" style="margin-bottom: 0px; margin-top: -40px; margin-right:20px;">
									총 후원자 수: <strong>${scount}</strong>명
								</div>
								<table class="admin-project-list-table">
									<tr>
										<th>번호</th>
										<th>후원자</th>
										<th>리워드명</th>
										<th>이메일</th>
										<th>주소</th>
										<th>진행 상황</th>
									</tr>
									<c:choose>
										<c:when test="${not empty list}">
											<c:forEach var="list" items="${list}">
											<tr style="height:61px;">
												<td>${list.rownum}</td>
												<td>${list.name}</td>
												<td>
													<c:choose>
														<c:when test="${fn:length(list.rcontent) <= 4}">
															${list.rcontent}
														</c:when>
														<c:when test="${fn:length(list.rcontent) > 4}">
															${list.rcontent.substring(0,5)}...
														</c:when>
													</c:choose>
												</td>
												<td style="width:75px;">${list.email}</td>
												<td style="width:300px; text-overflow: ellipsis;">${list.address}</td>
												<c:choose>
													<c:when test="${list.sgrade==1}">
													<td>
														<button class="ok go_save" id="${list.id}" pno="${list.pno}" sgrade="${list.sgrade}" >배송중</button>
													</td>
													</c:when>
													<c:when test="${list.sgrade==2}">
														<td style="width: 100px;">배송완료</td>
													</c:when>
												</c:choose>
												
											</tr>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<div style=" float:left; width:100%; position:relative; left:10px; top:80px; font-size:16px;">
												아직 후원자가 없어요...
											</div>	
										</c:otherwise>
									</c:choose>
									
									
								</table>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="container2-2-1"  style="text-align:center;">
				<nav>
					<ul class="pagination">
						<c:set var="num" value="${count-((pagemaker.cri.pageNum-1)*10)}" />
						<li class="#"><a
							href="sponsorlist.do?pno=${pno}&pageNum=${pagemaker.startPage}&amount=11&pname2=${pname2}"
							aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>

						<c:forEach var="num" begin="${pagemaker.startPage}" end="${pagemaker.endPage}">
							<li class=""><a href="sponsorlist.do?pno=${pno}&pageNum=${num}&amount=11&pname2=${pname2}">
									<c:choose>
										<c:when test="${num == 0}">
							1
							</c:when>
										<c:otherwise>
							${num}
							</c:otherwise>
									</c:choose> <span class="sr-only"></span>
							</a></li>
						</c:forEach>
						<li><a
							href="sponsorlist.do?pno=${pno}&pageNum=${pagemaker.endPage}&amount=11&pname2=${pname2}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
			</div>
		</div>
		
		<script>
			$(function(){
				$(".go_save").on("click",function(){
					var t_id = $(this).attr("id");
					var t_pno = $(this).attr("pno");
					var t_sgrade = $(this).attr("sgrade");
					frm.id.value=t_id;
					frm.pno.value=t_pno;
					frm.sgrade.value=t_sgrade;
					frm.action="sponsormodify.do";
					frm.submit();
				})
			});
		</script>
			<form name="frm" method="post">
				<input type="hidden" name="id" >
				<input type="hidden" name="pno" >
				<input type="hidden" name="sgrade">	
			</form>	

		<script>
			$('.container2-1-1-1').hover(function() {
				$('.absoluteid1').css('display', 'inline');
			}, function() {
				$('.absoluteid1').css('display', 'none');
			});
			$('.absoluteid1').hover(function() {
				$('.absoluteid1').css('display', 'inline');
			}, function() {
				$('.absoluteid1').css('display', 'none');
			});
		</script>

	</div>
</section>


<%@ include file="../footer.jsp"%>