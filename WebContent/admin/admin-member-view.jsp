<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link href="css/adminsublayout.css" rel="stylesheet">


<div class="col-md-9">
						<div class="adminbord">
							<div class="">
								<div class="pull-left">
									<h3>회원 상세보기</h3>
								</div>
								<div class="pull-right">
								<form name="grade" method="get" action="grade_modify.do" >
									<div class="member-stat-cheage">
										<input type="hidden" name="id" value="${mvo.id}">
										<select name="grade_no">
											<option>상태변경</option>
											<option value="1">일반 회원</option>
											<option value="2">탈퇴 회원</option>
											<option value="3">관리자</option>
										</select>
										<input type="submit" class="grade_pointer" value="변경하기">
									</div>
								</form>	
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="mt10">
								<table class="member-admin-table">
									<colgroup>
										<col width="20%">
										<col width="30%">
										<col width="20%">
										<col width="30%">
									</colgroup>
									<tr>
										<th>아이디</th>
										<td>${mvo.id}</td>
										<th>이메일</th>
										<td>${mvo.email}</td>
									</tr>
									<tr>
										<th>닉네임</th>
										<td>${mvo.name}</td>
										<th>회원상태</th>
										<c:if test ="${mvo.grade eq '1'}">
											<td>일반회원</td>
										</c:if>
										<c:if test ="${mvo.grade eq '2'}">
											<td>탈퇴회원</td>
										</c:if>
										<c:if test ="${mvo.grade eq '3'}">
											<td>관리자</td>
										</c:if>
									</tr>
									<tr>
										<td colspan="2"><img class="user-profile" src="memberprofile/${mvo.profile}"></td>
										<th>가입일</th>
										<td>${mvo.regdate.substring(0,10)}</td>
									</tr>
									<tr>
										<th colspan="4">후원 리스트 (${mvo.sponsercount}회)</th>
									</tr>
									<c:forEach var="list" items="${slist}">
									<tr>
										<td colspan="4">
											<div class="member-rewardsdiv">
												<div class="reward-img">
													<img src="projectupload/${list.pname1}">
												</div>
												<div class="reward-project">
													<strong><a href="admin-project-view.do?pno=${list.pno}">${list.pname2}</a></strong>
												</div>
												<div class="reward-kind">
													<strong><a href="">${list.pcontent1}</a></strong>
												</div>
												<div class="reward-date">
													공개일: ${list.odate.substring(0,10)} | 결제일: ${list.sdate.substring(0,10)}
												</div>
												<div class="reward-money">
													후원 금액: ${list.smoney}원
												</div>
												<div class=""></div>
											</div>
											
										</td>
									</tr>
								</c:forEach>
								</table>
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