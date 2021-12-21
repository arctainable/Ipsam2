<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

					<div class="col-md-4">
						<div class="writer-info mt40">
							<div class="writer-card">
								<div class="hello">창작자 소개</div>
								<div class="mt10"><img class="user-photo" src="memberprofile/${creator.profile}" >${creator.name}</div>
								<div class="mt10">
									<p>${pvo.pcontent3}</p>
								</div>
							</div>
						</div>
						<div class="mt40">리워드 안내</div>
						<c:choose>
							<c:when test="${pvo.pgrade ne 2}">
								<div class="project-content mt40">프로젝트 펀딩을 하실수 없습니다</div>
							</c:when>
							<c:otherwise>
						<c:forEach var="rlist" items="${rlist}">
						<div class="reward-list mt20 pointer" bno="${rlist.rno}">
						<fmt:formatNumber type="number" maxFractionDigits="3" value="${rlist.rmoney}" var="rPrice" />
							<div class="">${rPrice}원</div>
							<div class="">${rlist.rcontent }</div>
							<p class="" id="${rlist.rno}" style="display:none;">
								<c:if test="${pvo.pgrade >=2 }">
								<button type="button" class="button_p" onclick="goOrder${rlist.rno}()">밀어주기</button>
								</c:if>
							</p>
						</div>
						</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</section>
		
		<script>
			$(function(){
				$(".reward-list").click(function(){
					var rewardno = $(this).attr('bno');
					$("#"+rewardno+" ").toggle(500);
				});
			});
		</script>
		<script>
			function goOrder1(){
				orderform.t_rno.value="1";
				orderform.method="post";
				orderform.action="project-order.do";
				orderform.submit();
			}
			function goOrder2(){
				orderform.t_rno.value="2";
				orderform.method="post";
				orderform.action="project-order.do";
				orderform.submit();
			}
			function goOrder3(){
				orderform.t_rno.value="3";
				orderform.method="post";
				orderform.action="project-order.do";
				orderform.submit();
			}
		</script>
		<form name="orderform">
			<input type="hidden" name="t_pno" value="${pvo.pno}">
			<input type="hidden" name="t_rno" value="">
		</form>