<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="header.jsp"%>

<link href="css/adminsublayout.css" rel="stylesheet">


<div class="col-md-9">
	<div class="adminbord">
		<div class="">
			<div class="pull-left">
				<h3>프로젝트 관리 페이지 입니다</h3>
			</div>
		
			<div class="clearfix"></div>
		</div>
		<div class="">
			<div class="pull-left">
				<div class="dropdown admin-project-dorpbtn">
					<button class="btn btn-default dropdown-toggle" type="button"
						id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
						모두 보기 <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu"
						aria-labelledby="dropdownMenu1">
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="project-manger.do">모두 보기</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="project-manger.do?pgrade=1">검토 대기</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="project-manger.do?pgrade=3">공개 예정</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="project-manger.do?pgrade=2">진행중</a></li>
						<li role="presentation"><a role="menuitem" tabindex="-1"
							href="project-manger.do?pgrade=4">완료</a></li>
					</ul>
				</div>
				<div class="serchprodiv">
					<form name="frmproject" method="get" action="project-manger.do">
						<div class="admin-search-div">
							<i class="fas fa-search"></i> 
							<input type="text" class="admin-search" name="word" placeholder="프로젝트 검색하기">
							<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
							<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
						</div>
					</form>
				</div>
			</div>
			
			<div class="clearfix"></div>
		</div>
		<form name="frmPchange" method="get" action="projectchange.do">
		<div>
			<div class="pull-right" style="margin-bottom: 20px;  margin-top: -60px;">
			<div class="project-countdiv">
					총 프로젝트 수는 <span>${count }개</span> 입니다
				</div>
				<div class="project-stat-cheage">
				
					<select name="pchange">
						<option value="">프로젝트 상태</option>
						<option value="Y">승인</option>
						<option value="N">반려</option>
					</select> <a href="javascript:changecheck();" class="pointer">변경하기</a>
				
				</div>
			</div>
			<table class="admin-project-list-table">
				
				<tr>
					<th>번호</th>
					<th colspan="2">프로젝트상세</th>
					<th>후원자 수</th>
 					<th>현재금액</th>
					<th>목표금액</th>
					<th>신청날짜</th>
					<th>공개날짜</th>
					<th>목표날짜</th>
					<th>현재상태</th>
					<th>선택</th>
				</tr>
				<c:set var="num" value="${count-((pageMaker.cri.pageNum-1)*10)}"/>
				<c:forEach var="plist" items="${plist }">
					<tr>
						<td>${num}</td>
						<td><img src="projectupload/${plist.pname1}"></td>
						<td><a href="admin-project-view.do?pno=${plist.pno}">${plist.pname2}</a></td>
						<td>${plist.sponsor}명</td>
						<fmt:formatNumber type="number" maxFractionDigits="3" value="${plist.nowmoney}" var="Nowmoney" />
						<td style="width: 75px;">${Nowmoney}원</td>
						<fmt:formatNumber type="number" maxFractionDigits="3" value="${plist.pmoney}" var="Pmoney" />
						<td style="width: 100px;">${Pmoney}원</td>
						<td style="width: 90px;">${plist.adate.substring(0,10)}</td>
						<td style="width: 90px;">${plist.odate.substring(0,10)}</td>
						<td style="width: 90px;">${plist.gdate.substring(0,10)}</td>
						<c:choose>
							<c:when test="${plist.pgrade == 0 }">
								<td>반려</td>
							</c:when>
							<c:when test="${plist.pgrade == 1 }">
								<td>대기중</td>
							</c:when>
							<c:when test="${plist.pgrade == 2 }">
								<td>진행중</td>
							</c:when>
							<c:when test="${plist.pgrade == 3 }">
								<td>공개예정</td>
							</c:when>
							<c:when test="${plist.pgrade == 4 }">
								<td>완료</td>
							</c:when>
						</c:choose>
						<td>
							<input type="checkbox" name="chk" value="${plist.pno}">
						</td>
					</tr>
					<c:set var="num" value="${num-1 }" />
				</c:forEach>
				
			</table>
		</div>
		</form>
		<div class="pagenation mt40">
			<c:if test="${pageMaker.prev }">
				<a href="${pageMaker.startPage-1 }" class="pointer"><i class="fa fa-angle-left"></i></a> 
			</c:if>
			<c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
				<a href="${num }" class="">${num }</a> 
			</c:forEach>
			<c:if test="${pageMaker.next }">
				<a href="${pageMaker.endPage+1 }" class="pointer"><i class="fa fa-angle-right"></i></a> 
			</c:if>
			
		</div>
	</div>
</div>
</div>
</div>
</section>

<form id="actionForm" action="project-manger.do" method="get">
		<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
		<input type="hidden" name="word" value="${pageMaker.cri.keyword }">
	</form>
	<script>
		$(function() {
			
			var actionForm = $("#actionForm");
			$(".pagenation > a").on("click", function(e){
				e.preventDefault(); //위쪽으로 올라가는거 방지
				actionForm.find("input[name='pageNum']").val($(this).attr("href"));
				actionForm.submit();
			});
		});
	</script>
<script>
	function changecheck(){
		
		$("input:checkbox[name=chk]:checked").each(function(){
			var checkVal = $(this).val();
			//console.log(checkVal);
	//		var arr = new Array(); 
	//		for(var i = 0; i<arr.length; i++){
	//			arr[i] = checkVal;
	//		}
			
			frmPchange.submit();
		})
			
		
	}
</script>



<footer> </footer>
</body>
</html>