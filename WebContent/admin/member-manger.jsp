<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<link href="css/adminsublayout.css" rel="stylesheet">
<script>
	function press(f){ if(f.keyCode == 13){
		member_search.submit();
		}
	} 
</script>
<div class="col-md-9">
						<div class="adminbord">
							<div class="">
								<div class="pull-left">
									<h3>회원 관리 페이지 입니다</h3>
								</div>
								<div class="pull-right">
									<div class="project-countdiv">
										총 회원 수 <span>${memberCount}명</span> 입니다
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="">
								<div class="pull-left">
									<div class="serchprodiv">
										<form name="member_search" action="member-manger.do" >
											<div class="admin-search-div"><i class="fas fa-search"></i>
												<input type="text" name="word" class="admin-search" placeholder="회원 검색하기"  >
												<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
												<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
											</div>
										</form>
									</div>
								</div>
								<div class="pull-right">
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="mt20">
								<table class="admin-member-list-table">
									<tr>
										<th colspan="3">회원 상세</th>
										<th>이메일</th>
										<th>후원횟수</th>
										<th>회원상태</th>
									</tr>
									<c:forEach var="list" items="${member_list}">
									<tr>
										<td><a href="admin-member-view.do?id=${list.id}"><img src="memberprofile/${list.profile}"></a></td>
										<td>${list.id}</td>
										<td>${list.name}</td>
										<td>${list.email}</td>
										<td>${list.sponsercount} 회</td>
										<c:if test ="${list.grade eq '1'}">
											<td>일반회원</td>
										</c:if>
										<c:if test ="${list.grade eq '2'}">
											<td>탈퇴회원</td>
										</c:if>
										<c:if test ="${list.grade eq '3'}">
											<td>관리자</td>
										</c:if>
									</tr>
									</c:forEach>
									
								</table>
							</div>
							<div class="pagenation mt40">
							<c:if test="${pageMaker.prev}">
								<a class="${pageMaker.startPage-1}"><i class="fa fa-angle-left"></i></a>
							</c:if>
							<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
								<a href="${num}" class="${pageMaker.cri.pageNum==num ? 'active':''}">${num}</a>
							</c:forEach>
							<c:if test="${pageMaker.next}">	
								<a class="${pageMaker.endPage+1}"><i class="fa fa-angle-right"></i></a>
							</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		
		
		
		<form id="actionForm" action="member-manger.do" method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
		
	<input type="hidden" name="sel" value="${pageMaker.cri.type}">
		<input type="hidden" name="word" value="${pageMaker.cri.keyword}"> 
		
	</form>
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
			
			var actionForm =$("#actionForm");
			$(".pagenation > a").on("click", function(e){
				e.preventDefault();
				actionForm.find("input[name='pageNum']").val($(this).attr("href"));
				actionForm.submit();
			})
		});
	</script>

		
		<footer>
		</footer>
	</body>
</html>