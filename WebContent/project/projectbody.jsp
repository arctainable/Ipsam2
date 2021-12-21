<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 		<jsp:useBean id="today" class="java.util.Date" />
		<fmt:formatDate var="now" value="${today}" pattern="yyyy-MM-dd" />
		
		<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script src="js/kakaoshare.js"></script>
	<script type="text/javascript" src="js/em	ptycheck.js"></script>
	<form name="shareform">
		<input type="hidden" name="title" value="${pvo.pname2}">
		<input type="hidden" name="content" value="${pvo.pcontent1}">
		<input type="hidden" name="imgUrl" value="http://localhost/Ipsam/projectupload/${pvo.pname1}">
	</form>
	
	<form name="">
		<input type="hidden" name="rp">
		<input type="hidden" name="" value="">
	</form>
	<script>
		function projectlike(){
			var user = ilike.userid.value;
			if(user != ""){
				var prono = ilike.pno.value;
				$.ajax({
					url:"projectLike.do",
					type:"post",
					data:{
						"pno":prono,
						"userid":user
					},
					success:function(data){
						$(".like-btn span").html(data);
					},
					error:function(){
						alert("문제가 발생했습니다!")
					}
				});
			}else{
				alert("로그인 후 이용 가능합니다");
			}
		}
	</script>
	<form name="ilike">
		<input type="hidden" name="userid" value="${User.id}">
		<input type="hidden" name="pno" value="${pvo.pno}">
		<input type="hidden" name="pid" value="${pvo.id }">
	</form>
		
<!-- 			<script defer>
			$(function(){
				$(".inquiry-btn").on("click",function(){
					$('#myModal').modal('hide');
					var user = ilike.userid.value;
					if(user != ""){
						var id = '${pvo.id}';
						var pno = '${pvo.pno}';
						var wid = '${User.id}';
						$(".modal-title").html("문의하기")
						$(".modal-body").html(
								"<form name='inqform'>"+
								"<input type='hidden' name='proid' value='"+id+"'> "+
								"<input type='hidden' name='propno' value='"+pno+"'> "+
								"<input type='hidden' name='writerid' value='"+wid+"'> "+
								"<div class=''></div><input type='text' name='title'></input> <textarea class='inqtext' name='content'></textarea><div class='text-center inqusend-btn'>"+
								"<a onclick='sendInq()' class='pointer'>전송</a> "+
								"<a class='massege-btn inquirylist-btn pointer'>문의내역보기</a>"+
								"</div> "+"</form>" );
						$('#myModal').modal('show');
					}else{
						alert("로그인 후 이용 가능합니다");
					}
				});
			});
		</script> -->
		
		<script defer>
		$(function(){
			$(".inquirylist-btn").on("click",function(){
				var user = ilike.userid.value;
				if(user != ""){
					var id = '${pvo.id}';
					var pno = '${pvo.pno}';
					var wid = '${User.id}';
					var idcheck = (id == wid);
					$(".modal-title").html("문의하기")
					$(".modal-body").html(
							"<input type='hidden' name='proid' value='id'> "+
							"<input type='hidden' name='propno' value='pno'>"+
							"<input type='hidden' name='writerid' value='wid'>"+
							"<div class=''></div>"+
							"<c:if test='${empty qlist }'>"+
								"<div>문의 내역이 없습니다</div>"+
							"</c:if>"+
							"<c:if test='${!empty qlist}'>"+
							"<div role='tabpanel' class='tab-pane active' id='faq'>"+
							"<div class='panel-group' id='accordion' role='tablist' aria-multiselectable='true'>"+
							"<c:forEach var='qlist' items='${qlist}'>"+
							"<div class='panel panel-default'>"+
							"<div class='panel-heading' role='tab' id='heading${qlist.bno }'>"+
								"<h4 class='panel-title'>"+
									"<a class='collapsed' data-toggle='collapse' data-parent=''#accordion' href='#collapse${qlist.bno }' aria-expanded='false' aria-controls='collapse${qlist.bno }'>"+
										"${qlist.question } "+ " 보낸사람 :${qlist.name} "+ 
										"<c:if test='${empty qlist.reply}'>"+
										" <span class='answer-span'> 답변 대기 </span>"+
										"</c:if>"+
										"<c:if test='${!empty qlist.reply}'>"+
										" <span class='answer-span'> 답변 완료 </span>"+
										"</c:if>"+
									"</a>"+
								"</h4>"+
							"</div>"+
							"<div id='collapse${qlist.bno }' class='panel-collapse collapse' role='tabpanel' aria-labelledby='heading${qlist.bno }'>"+
								"<div class='panel-body'>"+
								"<p>"+
								"<c:if test='${empty qlist.reply}'>"+
								"아직 답변이 등록되지 않았습니다."+
								"</c:if>"+
								"<c:if test='${!empty qlist.reply}'>"+
								"${qlist.reply }"+
								"</c:if>"+
								" </p>"+
								"<c:if test='${User.id eq pvo.id}'>"+
									"<div class='rpy${qlist.bno}'>"+
										"<a class='reply pointer reply-btn' onclick='goreply(this)'  qno='${qlist.bno}'>답변하기</a>"+
									"</div>"+
								"</c:if>"+
								"</div>"+
							"</div>"+
						"</div>"+
							"</c:forEach>"+
							"</div>"+
							"</div>"+
							"</c:if>"+
							"<c:if test='${User.id != pvo.id}'>"+
							"<a href='#' onclick='inquiry()' class='massege-btn inquiry-btn pointer'>문의하기</a>"+
							"</c:if>"
							);
					$('#myModal').modal('show');
				}else{
					alert("로그인 후 이용 가능합니다");
				}
			});
			
		});
			</script>
			
		<script defer>
		
		function replyactioadsdn(){
			var qno = rep.qno.value;
			$(".rpy").html(
					"<form name='rpyform'>"+
					"<input type='hidden' name='qno' value="+qno+"> "+
					"<div class='"+qno+"'></div> <textarea class='rptext"+qno+"' name='rp'></textarea><div class='rpsend-btn'>"+
					"<a onclick='sendrpy()' class='pointer inquiry-btn'>전송</a> "+
					"</div> "+"</form>"
			);
		}
		</script>
		
		<script defer>
		function inquiry(){
				var user = ilike.userid.value;
				if(user != ""){
					var id = '${pvo.id}';
					var pno = '${pvo.pno}';
					var wid = '${User.id}';
					$(".modal-title").html("문의하기")
					$(".modal-body").html(
							"<form name='inqform'>"+
							"<input type='hidden' name='proid' value='"+id+"'> "+
							"<input type='hidden' name='propno' value='"+pno+"'> "+
							"<input type='hidden' name='writerid' value='"+wid+"'> "+
							"<div class=''></div><textarea class='inqtext' name='question'></textarea><div class='text-center inqusend-btn'>"+
							"<a onclick='sendInq()' class='pointer '>전송</a> "+
							"</div> "+"</form>" );
					$('#myModal').modal('show');
				}else{
					alert("로그인 후 이용 가능합니다");
				}
		}
		</script>
		<script>
			function goreply(e){
				var reqno = $(e).attr("qno");
				$(".rpy"+reqno).html(
						"<form name='puma' >"+
						"<input type='hidden' name='qno' value='"+reqno+"' >"+
						"<input type='hidden' name='pno' value='${pvo.pno}' >"+
						"<textarea class='rptext inqtext' name='rp'></textarea>"+
						"<div class='rpsend-btn'>"+
						"<a onclick='sendrpy()' class='pointer inquiry-btn'>전송</a> "+
						"</div>"+
						"</form>"
				);
			}
		</script>
		<script defer>
			function sendInq(){
				if(!chekEmpty(inqform.question,"내용 입력")) return;
				inqform.method="post";
				inqform.action="qnawrite.do";
				inqform.submit();
				
				
			}
			
			function sendrpy(){
				if(!chekEmpty(puma.rp,"내용 입력")) return;
				puma.method="post";
				puma.action="replywrite.do";
				puma.submit();
			}
		</script>
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel">문의내역</h4>
					</div>
					<div class="modal-body" style="overflow:hidden;">
					<%-- <form name="inqlistform">
								<input type='hidden' name='proid' value="id"> 
								<input type='hidden' name='propno' value="pno">
								<input type='hidden' name='writerid' value="wid">
								<div class=''></div>
								<c:choose>
								<c:when test="${empty qlist }">
									<div>문의 내역이 없습니다</div>
								</c:when>
								<c:otherwise>
								<div role="tabpanel" class="tab-pane active" id="faq">
								<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
								<c:forEach var="qlist" items="${qlist}">
								<div class="panel panel-default">
								<div class="panel-heading" role="tab" id="heading${qlist.bno }">
									<h4 class="panel-title">
										<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapse${qlist.bno }" aria-expanded="false" aria-controls="collapse${qlist.bno }">
											${qlist.title } 
										</a>
									</h4>
								</div>
								<div id="collapse${qlist.bno }" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${qlist.bno }">
									<div class="panel-body">
									<p>${qlist.content } </p>
									</div>
								</div>
							</div>
								</c:forEach>
								</div>
								</div>
								</c:otherwise>
								</c:choose>
								<a id='inquiry' class='pointer'>문의하기</a>
								<a onclick='qnalist()' class='pointer'>문의내역보기</a>
								</form> --%>
								</div> 
					</div>
				</div>
			</div>
		</div>
		<!-- 
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel"></h4>
					</div>
					<div class="modal-body" style="overflow:hidden;">
					<form name="inqform">
								<input type='hidden' name='proid' value="id">
								<input type='hidden' name='propno' value="pno">
								<input type='hidden' name='writerid' value="wid">
								<div class=''></div><input type='text' name='title'></input> <textarea class='inqtext' name='content'></textarea><div class='text-center inqusend-btn'>"+
								<a onclick='sendInq()' class='pointer'>전송</a> 
								<a onclick='qnalistbyId()' class='pointer'>문의내역보기</a>
								</div> </form>
					</div>
				</div>
			</div>
		</div> -->
	
	
	<section>
			<div class="container">
				<div class="project-head">
					<div class="head-info">
						<div class="head-title">
							<div class="title-div">
								<h1 class="">${pvo.pname2}</h1>
								<div class="writer-name">
									<span>${pvo.pcontent1}</span>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-8">
								<img class="projectimg" src="projectupload/${pvo.pname1}">
							</div>
							<div class="col-md-4">
								<div class="fundding-info">
									<div class="item-moneybar">
										<div class="item-moneybar-ss" style="width:${pvo.nowmoney / pvo.pmoney *100}%"></div>
									</div>
									<fmt:formatNumber type="number" maxFractionDigits="3" value="${pvo.nowmoney}" var="nowPrice" />
									<div class="fundding-amount mt10">${nowPrice}원 <span class="fundding-stat">펀딩중</span></div>
									<div class="mt40">
										<span class="info-text">달성률</span> 
										<span class="info-now mr5"><fmt:formatNumber value="${pvo.nowmoney / pvo.pmoney }" pattern="#,##%" /></span> 
										<fmt:formatNumber type="number" maxFractionDigits="3" value="${pvo.pmoney}" var="pPrice" />
										<span class="info-goal">목표금액 ${pPrice}원</span>
									</div>
									<div class="mt20">
										<span class="info-text">남은기간</span> 
										<fmt:parseDate value="${now}" var="strPlanDate" pattern="yyyy-MM-dd"/>
										<fmt:parseNumber value="${strPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="strDate"/>
										<fmt:parseDate value="${pvo.gdate }" var="endPlanDate" pattern="yyyy-MM-dd"/>
										<fmt:parseNumber value="${endPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="endDate"/>
										<c:choose>
											<c:when test="${strPlanDate > endPlanDate}">
												펀딩종료&nbsp;&nbsp;
											</c:when>
											<c:otherwise>
												<span class="info-now mr5">${endDate - strDate}일</span> 
											</c:otherwise>
										</c:choose>
										<fmt:formatDate value="${endPlanDate}" pattern="yyyy.MM.dd" var="goaldate"/>
										<span class="info-goal">
										${goaldate}종료
										</span>
									</div>
									<div class="mt20">
										<span class="info-text">참여자</span> 
										<span class="info-now">${sponcount}명</span>
									</div>
									
									<div class="fundding_contents">
									
									<h5>펀딩 안내</h5>
										<p>목표인 ${pPrice}원이 모여야만 결제됩니다.</p>
										<p>결제는 ${goaldate}일 진행됩니다.</p>
																			
									</div>
									
									<div class="mt40 btn-warp">
										<a class="like-btn pointer" onclick="projectlike()"><i class="fas fa-heart"></i> <span>${pvo.likecount}</span></a>
											<c:choose>
													<c:when test= "${pvo.id == User.id }">
													<a class="massege-btn inquirylist-btn pointer">문의내역</a>
												</c:when>
												<c:when test= "${pvo.id != User.id }">
													<a class="massege-btn inquirylist-btn pointer">문의하기</a>
												</c:when>
											</c:choose>
										<a class="share-btn pointer" onclick="sendlink()">공유하기</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		