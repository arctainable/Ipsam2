<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="css/notice.css" rel="stylesheet">

	<section class="notice-head"></section>

	<section>
	<div class="container container-tap-menu mt40">
		<div role="tabpanel">

			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation">
					<a href="#profile" aria-controls="home" role="tab" data-toggle="tab">회사소개</a>
				</li>
				<li role="presentation" class="active">
					<a href="#notice" aria-controls="profile" role="tab" data-toggle="tab">공지사항</a>
				</li>
				<li role="presentation">
					<a href="#event" aria-controls="event" role="tab" data-toggle="tab">이벤트</a>
				</li>
				<li role="presentation">
					<a href="#faq" aria-controls="faq" role="tab" data-toggle="tab">FAQ</a>
				</li>
			</ul>

			
			
			<!-- Tab panes -->
			<!-- 회사소개 -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane" id="profile">
					<div class="container">
						<div class="company_introduce">
							<div class="company_project_h">
								<img src="img/잎샘.png">
								<h3 class="project_h2">창작자들을 위한 Crowd Funding</h3>
							</div>
							
							<div class="pro_content">
									<p class="">
										<h3>잎샘&nbsp;</h3>은 <p class="line_p">잎이 나올 무렵의 추위</p>를 의미합니다.<br>
										이 시기를 견뎌내고 나면 따뜻한 봄 햇살과 함께 잎을 틔워냅니다.<br>
										무명 시기라는 <p class="line_p">추위를 이겨내고 발아하기까지의 과정</p>을 잎샘이 응원하겠습니다.
									</p>
								</div>
							
					
						</div>
					</div>
				</div>
				
				
				<!-- 공지사항 -->
				<div role="tabpanel" class="tab-pane active" id="notice">
					<div class="container">
						<div class="notice_main">
							<table class="table n_table">
							<colgroup>
								<col width = "10%"/>
								<col width = "90%"/>
							</colgroup>
								<tr>
									<th>제목</th>
									<td>${nvo.title }</td>
								</tr>
								<tr>
									<th>작성일</th>
									<td>${nvo.regdate }</td>
								</tr>
								<tr>
									<th style="vertical-align: middle;">내용</th>
									<td style="height: 300px; padding: 40px;">${nvo.content } </td>
								</tr>							
							</table>
							<div class="container" style="text-align: center;">
								<input type="button" class="notice_b" value="목록" onClick="location.href='notice.do'">
							</div>
						</div>
						
					</div>
				</div>
				
				
				<!-- 이벤트 -->
				<div role="tabpanel" class="tab-pane" id="event">
					<div class="container">
						<div class="row">
						<c:forEach var="elist" items="${elist }">
							<div class="col-md-4 event">
								<img src="eventupload/${elist.thumbnail }">
								<div class="col-md-8">
									<h4>${elist.title }</h4>
									<p>${elist.content }</p>
								</div>
								<div class="col-md-4">
									<input type="button" class="btn" value="바로가기" onclick="location.href='eventview.do?bno=${elist.bno }'">
								</div>
							</div>
						</c:forEach>
							
							
						</div> <!--row-->
					</div>
						
				</div>
				
				
				
				
				<!-- faq -->
				<div role="tabpanel" class="tab-pane" id="faq">
					<div class="qna-list">
						<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingOne">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
											Q. 크라우드 펀딩이란 무엇인가요?
										</a>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
									<div class="panel-body">
									<h4>A. </h4><p> 크라우드펀딩(CROWDFUNDING) 이라는 단어는 영어의 의미대로 말하자면, 대중(CROWD)에게 돈(자금)을 모은다(FUNDING)는 의미입니다.이러한 크라우드펀딩은 전세계적으로 온라인상에서 많은 대중들이 모여 십시일반으로 기부, 후원  등 다양한 형태로 발전되어 왔습니다.</p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingTwo">
									<h4 class="panel-title">
										<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
											Q. 쇼핑과 펀딩은 다른가요? 
										</a>
									</h4>
								</div>
								<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
									<div class="panel-body">
									<h4>A. </h4><p>펀딩 프로젝트에 펀딩하는 것은 메이커의 창작물을 단순히 사고파는 쇼핑이 아니라, 메이커의 창작활동 및 목표실현을 위한 과정을 지원하는 것입니다. </p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingThree">
									<h4 class="panel-title">
										<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
										Q. 펀딩 즉시, 결제가 진행되나요?
										</a>
									</h4>
								</div>
								<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
									<div class="panel-body">
										<h4>A. </h4><p>결제 수단을 등록하면 결제가 바로 진행되는 쇼핑하기와 다르게 펀딩하기는 프로젝트의 목표금액과 마감일이 있어 해당 프로젝트가 목표금액을 달성했을 때만, (프로젝트의 펀딩 타입에 따라 그렇지 않은 경우도 있습니다.) 마감일 다음날 펀딩에 참여한 서포터 모두 함께 결제가 진행됩니다.</p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingFour">
									<h4 class="panel-title">
										<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
											Q. 배송이 바로 진행되지 않나요? 
										</a>
									</h4>
								</div>
								<div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
									<div class="panel-body">
										<h4>A. </h4><p> 결제가 모두 완료되었다고 펀딩한 리워드가 바로 발송되지 않습니다. 메이커는 각 리워드마다 리워드 발송 시작일을 명시하고 있으며, 메이커가 약속한 리워드 발송 시작일에 발송이 진행되는 것을 원칙으로 합니다.</p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingFive">
									<h4 class="panel-title">
										<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
											Q. 투자, 후원금은 안전하게 관리되나요? 
										</a>
									</h4>
								</div>
								<div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
									<div class="panel-body">
										<h4>A. </h4><p>투자, 후원금은 펀딩완료시 별도의 집금가상계좌에 보관되며, 출금을 위해서는 출금을 위한 서류제출후 지급처리가 되기 때문에 임의로 출금할 수 없습니다. </p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="headingSix">
									<h4 class="panel-title">
										<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
											Q. 펀딩신청 후 취소할 수 있나요?
										</a>
									</h4>
								</div>
								<div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
									<div class="panel-body">
										<h4>A. </h4><p>펀딩이 완료되기 전 취소하실 수 있으며, 취소 후 펀딩금액은 고객님의 예치금 가상계좌로 환급됩니다.</p>
									</div>
								</div>
							</div>
							
						</div>
					</div><!--list-->
				</div>
			</div>

		</div>
		
	</div>
</section>


<%@ include file="../footer.jsp"%>