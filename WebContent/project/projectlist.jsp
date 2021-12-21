<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ include file="../header.jsp"%>
 		
 		<jsp:useBean id="today" class="java.util.Date" />
		<fmt:formatDate var="now" value="${today}" pattern="yyyy-MM-dd" />
 		<section>
			<div class="container">
				<div class="categorydiv">
					<div>
						<a href="project.do">
							<span class="category-part">
								<span class="category-1"></span>
								<span>전체보기</span>
							</span>
						</a>
						<a href="project.do?category=paint">
							<span class="category-part">
								<span class="category-2"></span>
								<span>그림</span>
							</span>
						</a>
						<a href="project.do?category=photo">
							<span class="category-part">
								<span class="category-3"></span>
								<span>사진</span>
							</span>
						</a>
						<a href="project.do?category=music">
							<span class="category-part">
								<span class="category-4"></span>
								<span>음악</span>
							</span>
						</a>
						<a href="project.do?category=write">
							<span class="category-part">
								<span class="category-5"></span>
								<span>글</span>
							</span>
						</a>
						<a href="project.do?category=movie">
							<span class="category-part">
								<span class="category-6"></span>
								<span>영상</span>
							</span>
						</a>
						<a href="project.do?category=release">
							<span class="category-part">
								<span class="category-7"></span>
								<span>오픈예정</span>
							</span>
						</a>
					</div>
				</div>
				<div class="listifodiv mt40">
					<div class="pull-left">
						<fmt:formatNumber type="number" maxFractionDigits="3" value="${pcount}" var="count" />
						<p class="procount"><span>${count}</span>개의 프로젝트가 있습니다.</p>
					</div>
					<div class="pull-right">
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="listdiv">
					<div class="row">
						<c:forEach var="prolist" items="${prolist}">
						<div class="col-md-3 project-item">
							<div class="item-h">
								<div class="project-card">
										<fmt:parseDate value="${prolist.odate }" var="opendate" pattern="yyyy-MM-dd"/>
										<fmt:parseDate value="${now}" var="strPlanDate" pattern="yyyy-MM-dd"/>
										<fmt:parseNumber value="${strPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="strDate"/>
										<fmt:parseDate value="${prolist.gdate }" var="endPlanDate" pattern="yyyy-MM-dd"/>
										<fmt:parseNumber value="${endPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="endDate"/>
									<c:choose>
										<c:when test="${opendate > strPlanDate }">
											<div class="item-image">
												<a href="projectrelease.do?pno=${prolist.pno}">
													<img src="projectupload/${prolist.pname1}">
												</a>
											</div>
											<div class="item-view">
												<ul class="list-unstyled">
													<li class="item-title"><a href="projectrelease.do?pno=${prolist.pno}">${prolist.pname2}</a></li>
													<li class="item-info">${prolist.categoryname} | ${prolist.name}</li>
													<li class="item-content"><a href="projectrelease.do?pno=${prolist.pno}">${prolist.pcontent1}</a></li>
												</ul>
											</div>
											<div class=""><p class="wait-coment">공개예정 프로젝트 입니다</p></div>
										</c:when>
										<c:when test="${opendate <= strPlanDate }">
											<div class="item-image">
												<a href="projectview.do?pno=${prolist.pno}">
													<img src="projectupload/${prolist.pname1}">
												</a>
											</div>
											<div class="item-view">
												<ul class="list-unstyled">
													<li class="item-title"><a href="projectview.do?pno=${prolist.pno}">${prolist.pname2}</a></li>
													<li class="item-info">${prolist.categoryname} | ${prolist.name}</li>
													<li class="item-content"><a href="projectview.do?pno=${prolist.pno}">${prolist.pcontent1}</a></li>
												</ul>
											</div>
											<div class="item-moneybar">
												<div class="item-moneybar-ss" style="width:${prolist.nowmoney / prolist.pmoney *100}%"></div>
											</div>
											<div class="item-funddingstat " >
												<fmt:formatNumber type="number" maxFractionDigits="3" value="${prolist.nowmoney}" var="Price" />
												<span class="fundding-amount1">${Price}원</span>
												<span class="percent"><fmt:formatNumber value="${prolist.nowmoney / prolist.pmoney }" pattern="#,##%" /> </span>
												<span class="rest-day">
												<c:choose>
													<c:when test="${strPlanDate > endPlanDate}">
														펀딩종료&nbsp;&nbsp;
													</c:when>
													<c:otherwise>
														${endDate - strDate}일 남음
													</c:otherwise>
												</c:choose>
												</span>
											</div>
											</c:when>
									</c:choose>
								</div>
							</div>
						</div>
						</c:forEach>
					</div><!-- row end -->
				</div>
			</div>
		</section>
 
 <%@ include file="../footer.jsp"%>