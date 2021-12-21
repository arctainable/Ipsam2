<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

 		<jsp:useBean id="today" class="java.util.Date" />
		<fmt:formatDate var="now" value="${today}" pattern="yyyy-MM-dd" />

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function sample4_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var roadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 참고 항목 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample4_postcode').value = data.zonecode;
						document.getElementById("sample4_roadAddress").value = roadAddr;
						document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

						// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
						if (roadAddr !== '') {
							document.getElementById("sample4_extraAddress").value = extraRoadAddr;
						} else {
							document.getElementById("sample4_extraAddress").value = '';
						}

						var guideTextBox = document.getElementById("guide");
						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
						if (data.autoRoadAddress) {
							var expRoadAddr = data.autoRoadAddress
									+ extraRoadAddr;
							guideTextBox.innerHTML = '(예상 도로명 주소 : '
									+ expRoadAddr + ')';
							guideTextBox.style.display = 'block';

						} else if (data.autoJibunAddress) {
							var expJibunAddr = data.autoJibunAddress;
							guideTextBox.innerHTML = '(예상 지번 주소 : '
									+ expJibunAddr + ')';
							guideTextBox.style.display = 'block';
						} else {
							guideTextBox.innerHTML = '';
							guideTextBox.style.display = 'none';
						}
					}
				}).open();
	}
</script>
		<form name="lastcheck" method="post">
<section>
	<div class="container">
			<div class="order-projectinfo">
				<div class="pull-left">
					<img class="s-size-photo" src="projectupload/${pvo.pname1}">
				</div>
				<div class="pull-left ml30">
					<span>${pvo.categoryname}</span>
					<h3>${pvo.pname2}</h3>
					<div class="projectview.do?pno=${pvo.pno}">
						<fmt:formatNumber type="number" maxFractionDigits="3" value="${pvo.nowmoney}" var="nowPrice" />
						<span class="fundding-amount">${nowPrice}원</span> 
						<span class="percent"><fmt:formatNumber value="${pvo.nowmoney / pvo.pmoney }" pattern="#,##%" /></span> 
						<fmt:parseDate value="${now}" var="strPlanDate" pattern="yyyy-MM-dd"/>
						<fmt:parseNumber value="${strPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="strDate"/>
						<fmt:parseDate value="${pvo.gdate }" var="endPlanDate" pattern="yyyy-MM-dd"/>
						<fmt:parseNumber value="${endPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="endDate"/>
						<span class="rest-day">${endDate - strDate}일 남음</span>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="order-check mt40">
				<div class="row">
					<div class="col-md-8 order-reward">
						<div class="order-state-div">
							<div class="order-state-head">선물 정보</div>
							<div class="order-state-body mt10">
								<table class="order-state-table">
									<colgroup>
										<col width="30%">
										<col width="70%">
									</colgroup>
									<tr>
										<th>선물 구성</th>
										<td>${rvo.rcontent}</td>
									</tr>
									<tr>
										<th>선물 금액</th>
										<fmt:formatNumber type="number" maxFractionDigits="3" value="${rvo.rmoney}" var="rPrice" />
										<td>${rPrice}원</td>
									</tr>
									<tr>
										<th>예상 결제일</th>
										<fmt:formatDate value="${endPlanDate}" pattern="yyyy년 MM월 dd일" var="goaldate"/>
										<td>${goaldate}</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="order-state-div mt20">
							<div class="order-state-head">후원자 정보</div>
							<div class="order-state-body mt10">
								<table class="order-state-table">
									<colgroup>
										<col width="30%">
										<col width="70%">
									</colgroup>
									<tr>
										<th>아이디</th>
										<td>${User.id}</td>
									</tr>
									<tr>
										<th>이메일</th>
										<td>${User.email}</td>
									</tr>
								</table>
								<div class="order-state-text">
									* 위 연락처와 이메일로 후원 관련 소식이 전달됩니다. <br> * 연락처 및 이메일 변경은 설정 >
									계정 설정에서 가능합니다.
								</div>
							</div>
						</div>
						<div class="order-state-div mt20">
							<div class="order-state-head">배송지</div>
							<div class="order-state-body mt10">
								<table class="order-state-table">
									<colgroup>
										<col width="30%">
										<col width="70%">
									</colgroup>
									<tr>
										<th>주소 확인</th>
										<td>
											<input type="text" id="sample4_postcode" placeholder="우편번호" name="postcode"> 
											<input type="button" class="postNum_b" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
											<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="roadaddress"> 
											<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="jibunaddress"> 
											<span id="guide" style="color: #999; display: none"></span><br> 
											<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="detailaddress"> 
											<input type="text" id="sample4_extraAddress" placeholder="참고항목" name="extraaddress">
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="order-state-div mt20 mb100">
							<div class="order-state-head">결제 수단</div>
							<div class="order-state-body mt10">
								<table class="order-state-table">
									<colgroup>
										<col width="30%">
										<col width="70%">
									</colgroup>
									<tr>
										<td colspan="2">
											<div role="tabpanel">

					  <!-- Nav tabs -->
					  <ul class="nav nav-tabs" role="tablist">
					    <li role="presentation" class="active"><a style="color: #333;" href="#home" aria-controls="home" role="tab" data-toggle="tab">계좌이체</a></li>
					    <li role="presentation"><a style="color: #333;" href="#profile" aria-controls="profile" role="tab" data-toggle="tab">신용카드/체크카드</a></li>
					    <li role="presentation"><a style="color: #333;" href="#messages" aria-controls="messages" role="tab" data-toggle="tab">무통장입금</a></li>
					    <li role="presentation"><a style="color: #333;" href="#settings" aria-controls="settings" role="tab" data-toggle="tab">휴대폰</a></li>
					  </ul>
					
					  <!-- Tab panes -->
					  <div class="tab-content">
					    <div role="tabpanel" style="padding: 40px;" class="tab-pane active" id="home">
					    	<span style="padding: 10px;">은행선택</span>
					    	<select style="margin-bottom: 15px;">
					    		<option>선택</option>
					    		<option>농협은행</option>
					    		<option>하나은행</option>
					    		<option>국민은행</option>
					    	</select>
					    	<br>
					    	<span style="padding: 10px;">계좌번호</span>
					    	<input type="text" placeholder="(-)은 뺴고 입력해주세요">
					    </div>
					    <div role="tabpanel" style="padding: 40px;" class="tab-pane" id="profile">
					    	<span style="padding: 10px;">카드선택</span> 
					    	<select style="margin-bottom: 20px;">
					    		<option>선택</option>
					    		<option>NH농협카드</option>
					    		<option>하나카드</option>
					    		<option>KB국민카드</option>
					    	</select><br>
					    	<span style="padding: 10px;">할부기간</span>
					    	<select>
					    		<option>일시불</option>
					    		<option>2개월(무이자)</option>
					    		<option>3개월(무이자)</option>
					    		<option>4개월(무이자)</option>
					    	</select>
					    </div>
					    <div role="tabpanel" style="padding: 40px;" class="tab-pane" id="messages">
					    	<span style="padding: 10px; font-size: 18px;">국민은행 321-5678-9876-54 잎샘</span>
					    	
					    </div>
					    <div role="tabpanel" style="padding: 40px;" class="tab-pane" id="settings">
					    	<span style="padding: 10px;">통신사선택</span> 
					    	<select>
					    		<option>선택</option>
					    		<option>SKT</option>
					    		<option>KT</option>
					    		<option>헬로모바일</option>
					    	</select>
					    </div>
					  </div>
					
					</div>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="order-state-div" style="margin-top: 30px;">
							<div class="order-state-body">
								<div class="order-last-pay">
									<div class="pull-left">최종 후원 금액</div>
									<div class="pull-right">${rPrice}원</div>
									<div class="clearfix"></div>
								</div>
							</div>
						</div>
						<div class="order-final">
							<div class="precautions">
								프로젝트 성공시, 결제는 <span>${goaldate}</span> 에 진행됩니다. 프로젝트가 무산되거나 중단된
								경우, 예약된 결제는 자동으로 취소됩니다.
							</div>
							<div class="order-checkboxdiv">
								<div class="perinfo-check">
									<div class="pull-left">
										<input name="perinfo" class="info-check" type="checkbox">
									</div>
									<div class="pull-left  more-info">개인정보 제 3자 제공 동의</div>
									<div class="pull-right">
										<a id="permoreinfo" class="pointer">내용보기</a>
									</div>
									<div class="clearfix"></div>
								</div>
								<div class="perinfo-check">
									<div class="pull-left">
										<input name="rewardinfo" class="info-check" type="checkbox">
									</div>
									<div class="pull-left  more-info">밀어주기(후원) 유의사항 확인</div>
									<div class="pull-right">
										<a id="rewardmoreinfo" class="pointer">내용보기</a>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="precautions">밀어주기는 아직 실현되지 않은 창작자의 프로젝트에 제작비를
								후원하는 과정입니다. 그렇기 때문에 제작 계획이 변경될 수 있으며, 프로젝트를 완수하고 후원자와 성실히 소통할
								책임은 프로젝트 주체인 창작자에게 있습니다.</div>
							<div class="project-order-submit mt20">
								<a onclick="projectorder()" class="pointer">후원하기</a>
							</div>
						</div>
					</div>
				</div>
			</div>
	</div>
</section>
<script src="js/emptycheck.js"></script>
<script type="text/javascript">
	function projectorder() {
		if ($(lastcheck.perinfo).is(":checked") == false) {
			alert("개인정보 제 3자 제공 동의를 체크하세요")
			$(lastcheck.perinfo).focus();
			return;
		}
		if ($(lastcheck.rewardinfo).is(":checked") == false) {
			alert("후원 유의사항 확인을 체크해주세요")
			$(lastcheck.rewardinfo).focus();
			return;
		}
		lastcheck.action="projectspon.do";
		lastcheck.submit();
	}
</script>
			<input type="hidden" name="t_pno" value="${pvo.pno}">
			<input type="hidden" name="t_rno" value="${rvo.rno}">
			<input type="hidden" name="t_rmoney" value="${rvo.rmoney}">
		</form>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel"></h4>
			</div>
			<div class="modal-body" style="overflow: hidden;"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		$("#permoreinfo").on( "click",function() {
			$(".modal-title").html("개인정보 제 3자 제공 동의");
				$(".modal-body").html(
					" <p> 회원의 개인정보는 당사의 개인정보 취급방침에 따라 안전하게 보호됩니다. '회사'는 이용자들의 개인정보를 개인정보 취급방침의 '제 2조 수집하는 개인정보의 항목, 수집방법 및 이용목적'에서 고지한 범위 내에서 사용하며, 이용자의 사전 동의 없이는 동 범위를 초과하여 이용하거나 원칙적으로 이용자의 개인정보를 외부에 공개하지 않습니다. </p>"
						+ " <table class='infomodaltable'> "
						+ " <tr><th>제공받는자</th><td>후원 프로젝트의 창작자</td></tr>"
						+ " <tr><th>제공 목적</th><td>선물 전달 및 배송과 관련된 상담 및 민원처리</td></tr>"
						+ " <tr><th>제공 정보</th><td>수취인 성명, 휴대전화번호, 배송 주소</td></tr>"
						+ " <tr><th>보유 및 이용기간</th><td>재화 또는 서비스의 제공이 완료된 즉시 파기(단, 관계법령에 정해진 규정에 따라 법정기간 동안 보관)</td></tr>"
						+ " </table>"
						+ " <p> * 동의 거부권 등에 대한 고지 </p> "
						+ " <p>개인정보 제공은 서비스 이용을 위해 꼭 필요합니다. 개인정보 제공을 거부하실 수 있으나, 이 경우 서비스 이용이 제한될 수 있습니다.</p>");
				$('#myModal').modal('show');
			});
		$("#rewardmoreinfo").on("click",function() {
			$(".modal-title").html("밀어주기(후원) 유의사항 확인내용보기");
				$(".modal-body").html(
						" <p> 밀어주기는 구매와는 다릅니다. 아직 실현되지 않은 창작자의 프로젝트가 실현될 수 있도록 제작비를 후원하는 과정이기 때문입니다.</p>"
						+ " <p> 프로젝트를 약속대로 완수하고 후원자와 성실히 소통할 책임은 창작자에게 있습니다. </p>"
						+ " <p> 잎샘은 창작자의 진행 능력을 보증할 수는 없지만, 프로젝트의 완수와 커뮤니티의 신뢰·안전을 위해 최선을 다하고 있습니다. </p>"
						+ " <p> 펀딩 마감과 동시에 모금액이 확정되므로, 펀딩 마감일 이후에는 후원을 철회할 수 없습니다. </p>"
						+ " <p> 결제 시작일에 결제가 실패할 경우, 최대 7일 동안 재결제를 시도합니다. 재결제 안내는 이메일 알림으로 제공됩니다. </p>"
						+ " <p> 제작 과정상 선물 전달이 예상 전달일보다 늦어지거나 프로젝트 계획이 변경될 수 있기에 커뮤니티 공지와 메시지를 확인해 주시고, 궁금한 점은 창작자에게 문의해 주세요. </p>");
			$('#myModal').modal('show');
		});
	})
</script>



<%@ include file="../footer.jsp"%>