<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<link href="css/adminsublayout.css" rel="stylesheet">


<div class="col-md-9">
						<div class="adminbord">
							<div class="">
								<div class="pull-left">
									<h3>프로젝트 상세보기</h3>
								</div>
								<div class="pull-right">
								<form name="grade" method="get" action="project_grade_modify.do" >
									<div class="member-stat-cheage">
										<input type="hidden" name="pno" value="${plist.pno }">
										<select name="grade_no">
											<option>상태변경</option>
											<option value="3">승인</option>
											<option value="0">반려</option>
										</select>
										<input type="submit" class="grade_pointer" value="변경하기">
									</div>
								</form>	
									<p class="projectview-category">프로젝트 카테고리 : ${plist.categoryname }</p>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="mt10">
								<table class="project-admin-table">
									<colgroup>
										<col width="15%">
										<col width="40%">
										<col width="15%">
										<col width="30%">
									</colgroup>
									<tr>
										<td colspan="4">'${plist.pname2 }'</td>
									</tr>
									<tr>
										<th>프로젝트번호</th>
										<td>${plist.pno }</td>
										<th>신청 날짜</th>
										<td>${plist.adate.substring(0,10) }</td>
									</tr>
									<tr>
										<th>창작자</th>
										<td>${plist.name }(${plist.id })</td>
										<th>공개 날짜</th>
										<td>${plist.odate.substring(0,10) }</td>
									</tr>
									<tr>
										<th>프로젝트상태</th>
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
										<th>목표 날짜</th>
										<td>${plist.gdate.substring(0,10) }</td>
									</tr>
									<tr>
										<th>후원자</th>
										<td><a href="">${plist.sponsor }명</a></td>
										<th>목표금액</th>
										<fmt:formatNumber type="number" maxFractionDigits="3" value="${plist.pmoney}" var="Pmoney" />
										<td>${Pmoney}원</td>
									</tr>
									<tr>
										<th>계좌번호</th>
										<td>${plist.paccount }</td>
										<fmt:formatNumber type="number" maxFractionDigits="3" value="${plist.nowmoney}" var="Nowmoney" />
										<th>현재금액</th>
										<td>${Nowmoney}원</td>
									</tr>
									<tr>
										<td class="project-thumbnail" colspan="2" rowspan="2"><img  src="projectupload/${plist.pname1}"></td>
										<th>창작자소개글</th>
										<td>${plist.pcontent3 }</td>
									</tr>
									<tr>
										<th>프로젝트 소개</th>
										<td>${plist.pcontent1 }</td>
									</tr>
								</table>
								<div role="tabpanel" class="mt20">
									<ul class="nav nav-tabs project-contnet-tab" role="tablist">
										<li role="presentation" class="active">
											<a href="#content" aria-controls="content" role="tab" data-toggle="tab">프로젝트 설명</a>
										</li>
										<li role="presentation">
											<a href="#rewards" aria-controls="rewards" role="tab" data-toggle="tab">프로젝트 리워드</a>
										</li>
									</ul>
								
									<div class="tab-content mt20">
									    <div role="tabpanel" class="tab-pane fade in active" id="content">
											<div class="project-content">
												${plist.pcontent2 }
											</div>
										</div>
									    <div role="tabpanel" class="tab-pane fade" id="rewards">
											<table class="table table-hover" >
												<tr>
													<th>리워드 번호</th>
													<th>리워드 내용</th>
													<th>리워드 금액</th>
													<th>선택한 사람 수</th>
												</tr>
											<c:forEach var="rlist" items="${rlist }">
												<tr>
													<td>${rlist.rno }</td>
													<td>${rlist.rcontent }</td>
													<td>${rlist.rmoney }원</td>
													<td>${rlist.rcount }명</td>
												</tr>
											</c:forEach>
												
											</table>
									    </div>
									</div>
								
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		

		
		<footer>
		</footer>
	</body>
</html>