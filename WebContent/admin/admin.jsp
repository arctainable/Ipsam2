<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>
		
					<div class="col-md-9">
						<div class="adminbord">
							<div class="mt40 ml70">
								<h2>환영합니다 <span class="main_color">관리자</span> ${User.id} 님,</h2>
								<h2>잎샘 관리자 페이지 입니다.</h2>
							
							</div>
							<div class="row mt30 ml70">
								<div class="col-md-3 admin_main_box mr5">
								<i class="fas fa-plus-circle main_color fa-2x mt20"></i>
									<h4>총 프로젝트</h4> 
									<h3><span class="main_color">${count}</span>건</h3>
								</div>
								<div class="col-md-3 admin_main_box mr5">
									<i class="fas fa-list main_color fa-2x mt20"></i>
									<h4>미검토 프로젝트</h4> 
									<h3><span class="main_color">${Ncheckcount}</span>건</h3>
								</div>
								<div class="col-md-3 admin_main_box mr5">
								<i class="far fa-check-circle main_color fa-2x mt20"></i>
									<h4>금일 마감 프로젝트</h4> 
									<h3><span class="main_color">${TodayEndcount}</span>건</h3>
								</div>
								<div class="col-md-3 admin_main_box">
									<i class="fas fa-user-plus main_color fa-2x mt20"></i>
									<h4>금일 가입 회원 수</h4> 
									<h3><span class="main_color">${TodayJoincount}</span>명</h3>
								</div>
							</div>
							
							
						</div>
					</div>
				</div>
			</div>
		</section>
		
	</body>
	
</html>