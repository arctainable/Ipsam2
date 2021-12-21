<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%    
    // 세션 유지시간 1시간
    session.setMaxInactiveInterval(60*60) ;
 
%>

<link href="css/profile.css" rel="stylesheet">


	<section>
			<div class="container2">
				<div class="container2-1">
					<div class="container2-1-1">
						<div class="absoluteid1">
							<a href="profile.do">
								<div class="absoluteid1-1">
									프로필 변경
								</div>
							</a>
							<a href="myproject.do">
								<div class="absoluteid1-2">
									창작자 페이지
								</div>
							</a>
						</div>
						<div class="container2-1-1-1">
							<a href="#">
								<div class="container2-1_box0">
									<div class="container2-1_box0_img">
										<img class="user-photo" src="memberprofile/${User.profile}" >
									</div>
									<div class="container2-1_box2">
										내 계정 <img src="img/제목 없음-1.png">
									</div>
									<div class="container2-1_box_id">
										${User.name}
									</div>
								</div>
							</a>	
						</div>
						<div class="container2-1-1-2">
								<div class="container2-1_box2">
									후원현황
								</div>
							<a href="mypage.do">
								<div class="container2-1_box1">
									결제 완료 (${count4})
								</div>
							</a>
							<a href="mypage2.do">
								<div class="container2-1_box1" >
									배송 완료 (${count5})
								</div>
							</a>
							<a href="News.do">
								<div class="container2-1_box1">
									커뮤니티 (${countnews})
								</div>
							</a>	
						</div>
<!--					<div class="container2-1-1-3">
							<div class="container2-1_box2">
								주문내역
							</div>
							<a href="#">
								<div class="container2-1_box1">
									배송상황
								</div>
							</a>
							<a href="#">
								<div class="container2-1_box1">
									후원내역
								</div>
							</a>
						</div>											-->	
					</div>
					<div class="container2-1-2">
						<a href="event.do">
							<div class="container2-1_box1">
								이벤트
							</div>
						</a>
						<a href="faq.do">
							<div class="container2-1_box1">
								FAQ
							</div>
						</a>	
						<a href="notice.do">
							<div class="container2-1_box1">
								공지사항
							</div>
						</a>
					</div>
				</div>
				
				<form name="frm" method="post" enctype="multipart/form-data">
				<input type="hidden" value="${User.bno}" name="bno">
				<input type="hidden" value="${User.grade}" name="grade">
					<div class="container2-2">
						<div class="container2-2-1">
							<div class="container2-2-1-1">
								<h4>프로필 변경</h4>
							</div>
						</div>
							<div class="container2-2-2-2">
								<div class="icon1-1"><strong>프로필 아이콘</strong></div>
								<div class="icon1-2">
									<img src="memberprofile/${User.profile}" class="icon-1-2-1"><br>
									<input type="file" class="icon1-2-2" name="profile" id="profile">
									<input type="hidden" name="profile2" value="${User.profile}">
									<button class="icon1-2-3" onClick="go_save()">이미지 편집</button>
								</div>
							</div>
						<div class="container2-2-2">
							<div class="container2-2-2-1" style="height:130px;">
								<div class="id1-1">
									<strong>아이디</strong>
									<span id="msg1" style="color:#f00; font-size:11px;"></span>
								</div>
								<input class="id1-2" name="id" id="id" value="${User.id}" placeholder="아이디" readonly><br>
								<button class="id1-3" onClick="" style="display:none;">변경</button>
							</div>
							<div class="container2-2-2-1">
								<div class="nick1-1">
									<strong>닉네임</strong>
									<span id="msg2" style="color:#f00; font-size:11px;"></span>
								</div>
								<input class="nick1-2" name="name" id="name" value="${User.name}" placeholder="닉네임"><br>
								<button class="nick1-3" onClick="go_save()">변경</button>
							</div>
	
							<div class="container2-2-2-1" style="height: 200px;">
								<div class="pw1-1">
									<strong>비밀번호</strong>
									<span id="msg3" style="color:#f00; font-size:11px;"></span>
								</div>
								<input type="password" class="pw1-2" name="pw" id="pw" placeholder="비밀번호"><br>
								<input type="password" class="pw1-2" name="pw2" id="pw2" placeholder="비밀번호확인"><br>
								<button class="pw1-3" onClick="go_save()">변경</button>
							</div>
							<div class="container2-2-2-1">
								<div class="email1-1">
									<strong>이메일</strong>
									<span id="msg4" style="color:#f00; font-size:11px;"></span>
								</div>
								<input class="email1-2" name="email" id="email" value="${User.email}" placeholder="이메일">
								<input class="email1-3" name="email2" id="email2" type="hidden" style="width:45%;" placeholder="인증번호를 입력해주세요"><br>
								<input type="button" class="email1-3" id="btn_cert" style="width: 100px; height: 33px; background: #ff9696;  color: white; border: 0px;  border-radius: 5px;" value="인증번호 발송"> 
								&nbsp;&nbsp;&nbsp; 
								<input type="button" class="email1-4" id="btn_ok" style="width: 80px; height: 33px; background: #ff9696;  color: white; border: 0px;  border-radius: 5px; display:none;" value="인증완료"> 
								&nbsp;&nbsp;&nbsp; 
								<button class="email1-5" style="display:none;" onClick="go_save()">변경</button>
							</div>
						</div>
					</div>
					
					<div class="modal fade">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					        <h4 class="modal-title">Modal title</h4>
					      </div>
					      <div class="modal-body">
					        <p>One fine body&hellip;</p>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					        <button type="button" class="btn btn-primary">Save changes</button>
					      </div>
					    </div><!-- /.modal-content -->
					  </div><!-- /.modal-dialog -->
					</div><!-- /.modal -->
					
					
				</form>
				
		<script>	
		$(function(){
			$("#name").blur(function() {
				
				 var idRegExp = /^[a-zA-z0-9가-힣]{1,10}$/;
					
					if(!idRegExp.test($("#name").val())) {	
						$("#msg2").html("닉네임이 10자 이내인지 확인해주세요");
						$("#name").val("${User.name}");
						$("#name").focus();
						return false;
					} else {
						$("#msg2").html("사용 가능한 닉네임입니다.");
					}

				})
		});
		</script>
		<script>	
		$(function(){
			$("#pw").blur(function() {
				
				 var idRegExp = /^[a-zA-z0-9]{8,15}$/;
					
					if(!idRegExp.test($("#pw").val())) {	
						$("#msg3").html("비밀번호가 8자 이상 15자 이내인지 확인해주세요");
						$("#pw").val("");
						$("#pw").focus();
						return false;
					} else {
						$("#msg3").html("사용 가능한 비밀번호입니다.");
					}

				})
		});
		</script>
		<script>
		$(function(){
			$("#pw2").blur(function() {
				if($("#pw").val() != $("#pw2").val()) {
					$("#msg3").html("비밀번호가 일치하지 않습니다.");
					$("#pw2").val("");
					$("#pw2").focus();
					return false;
				} else {
					$("#msg3").html("비밀번호가 일치합니다.");
				}
			})	
		});
		</script>
		
		<script type="text/javascript">
		$(function(){
			$("#email").blur(function() {
				var regEmail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
				
				if(!regEmail.test($("#email").val())) {
					$("#msg4").html("유효한 이메일 주소가 아닙니다.");
					$("#email").val("${User.email}");
					$("#email").focus();
					return false;
				} else {
					$("#msg4").html("사용 가능한 이메일입니다.");
				}
			})	
		});
		</script>
		
		<script>
	$(function (){
		$("#btn_cert").on("click", function(){
			var email = $("#email").val();
			$('#email').css('width','45%');
			$('#email2').get(0).type = '';
			$('.email1-4').show();
			$.ajax({
				type:"post",
				dataType:"json",
				async:false,
				data:{"email":email},
				url:"emailcheck.do",
				success:function(data){
					alert(data.msg);
				},error:function(){
					alert("무슨일이지?");
				}
			});
		}) //
		$("#btn_ok").on("click", function(e){
			e.preventDefault();
			var certinumber = $("#email2").val();
			if(certinumber == ""){
				alert("인증번호 입력");
				 write.email_check.focus();
			}else{
				$('.email1-5').show();
				
			}
		}) //
	});
	</script>

				<script>
				function go_save() {
					 if($('#pw').val() == "")	{ 	
						$("#msg3").html("비밀번호를 입력해야만 프로필을 수정할 수 있습니다.");
						$("#pw").focus();
						event.preventDefault();
						return false;
				    } else if($("#pw").val() != $("#pw2").val()) {
						$("#msg3").html("비밀번호가 일치하지 않습니다.");
						$("#pw2").val("");
						$("#pw2").focus();
						event.preventDefault();
						return false;
				    } else {
						var theForm = document.frm;
						theForm.action = "profile_write.do";
						theForm.submit();
					}
				}
				</script>				
				<script>
				$('.container2-1-1-1').hover(function(){
					$('.absoluteid1').css('display','inline');
				}, function() {
					$('.absoluteid1').css('display','none');
				});
				$('.absoluteid1').hover(function(){
					$('.absoluteid1').css('display','inline');
				}, function() {
					$('.absoluteid1').css('display','none');
				});
				</script>
				
			</div>
		</section>


<%@ include file="../footer.jsp"%>