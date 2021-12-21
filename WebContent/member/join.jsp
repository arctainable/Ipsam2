<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../header.jsp"%>
<link href="css/member.css" rel="stylesheet">
		
				
		<script type="text/javascript" src="js/emptycheck.js"></script>
		<script type="text/javascript">
			function goJoin(){
				if(!chekEmpty(loginform.id,"아이디를 입력해주세요")) return;
				if(!chekEmpty(loginform.name,"닉네임을 입력해주세요")) return;
				if(!chekEmpty(loginform.pw,"비밀번호를를 입력해주세요")) return;
				if(!chekEmpty(loginform.pw2,"비밀번호확인을 입력해주세요")) return;
				if(!chekEmpty(loginform.email,"이메일을 입력해주세요")) return;

				if(loginform.pw.value != loginform.pw2.value){
					alert("비밀번호를 다시 확인해주세요");
					loginform.pw2.value="";
					loginform.pw2.focus();
					return;
				}
				if($(loginform.ipsamok).is(":checked")==false){
					alert("잎샘 이용 약관 동의를 체크하세요")
					$(loginform.ipsamok).focus();
					return ;
				}
				if($(loginform.ipsamok2).is(":checked")==false){
					alert("개인 정보 수집,이용 동의를 체크하세요")
					$(loginform.ipsamok3).focus();
					return ;
				}
				if($(loginform.ipsamok3).is(":checked")==false){
					alert("만 14세 이상 동의를 체크하세요")
					$(loginform.ipsamok3).focus();
					return ;
				}

				loginform.method = "post";
				loginform.action = "joinpro.do";
				loginform.submit();
			}
		</script>
		<script>	
		$(function(){
			$("#id").blur(function() {
				
				 var idRegExp = /^[a-zA-z0-9]{5,15}$/;
					
					if(!idRegExp.test($("#id").val())) {	
						$("#msg1").html("아이디가 영문 대소문자 5~15자 이내인지 확인해주세요");
						$("#id").val("");
						$("#id").focus();
						return false;
					} else {
						$("#msg1").html("사용 가능한 아이디입니다.");
					}

				})
		});
		</script>
		<script>	
		$(function(){
			$("#name").blur(function() {
				
				 var idRegExp = /^[a-zA-z0-9가-힣]{1,10}$/;
					
					if(!idRegExp.test($("#name").val())) {	
						$("#msg2").html("닉네임이 10자 이내인지 확인해주세요");
						$("#name").val("");
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
					$("#msg4").html("비밀번호가 일치하지 않습니다.");
					$("#pw2").val("");
					$("#pw2").focus();
					return false;
				} else {
					$("#msg4").html("비밀번호가 일치합니다.");
				}
			})	
		});
		</script>
		<script type="text/javascript">
		$(function(){
			$("#email").blur(function() {
				var regEmail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
				
				if(!regEmail.test($("#email").val())) {
					$("#msg5").html("유효한 이메일 주소가 아닙니다.");
					$("#email").focus();
					return false;
				} else {
					$("#msg5").html("사용 가능한 이메일입니다.");
				}
			})	
		});
		</script>
		<script type="text/javascript">
			$(function(){
				$("#allcheck").on("click",function(){
					if($("#allcheck").prop("checked")){
						$("#ipsamok").prop("checked",true);
						$("#ipsamok2").prop("checked",true);
						$("#ipsamok3").prop("checked",true);
					}else{
						$("#ipsamok").prop("checked",false);
						$("#ipsamok2").prop("checked",false);
						$("#ipsamok3").prop("checked",false);
					}
				})
			});
		</script>
		
		
		
		<section>
			<div class="container">
				<div class="logindiv center-block mt40">
					<h3>가입하기</h3>
					<form name="loginform">
						<div class="join-uptext">아이디</div>
						<div class="login-info-div">
							<input type="text" name="id" id="id" placeholder="아이디는 영문 대소문자 5~15자 이내로 생성 가능합니다." >
							<span id="msg1" style="color:#f00"></span>
						</div>
						<div class="join-uptext">닉네임</div>
						<div class="login-info-div">
							<input type="text" name="name" id="name" placeholder="닉네임은 한글,영문 대소문자 10자 이하로 생성 가능합니다." >
							<span id="msg2" style="color:#f00"></span>
						</div>
						<div class="join-uptext">비밀번호</div>
						<div class="login-info-div">
							<input type="password" name="pw" id="pw" placeholder="비밀번호는 영문 대소문자 8~15자 이내로 생성 가능합니다.">
							<span id="msg3" style="color:#f00"></span>
						</div>
						<div class="login-info-div">
							<input type="password" name="pw2" id="pw2" placeholder="비밀번호를 확인합니다">
							<span id="msg4" style="color:#f00"></span>
						</div>
						<div class="join-uptext">이메일</div>
						<div class="login-info-div">
							<input type="email" name="email" id="email" placeholder="사용하실 이메일을 입력해주세요">
							<span id="msg5" style="color:#f00"></span>
						</div>
						<div class="">
							<label for="allcheck" class="pointer join-checkbox-label pull-left">
								<input id="allcheck" type="checkbox" name="allcheck"><span>전체 동의</span>
							</label>
							<div class="clearfix"></div>
						</div>
						<div class="the_line"></div>
						<div class="join-checkbox">
							<ul class="list-unstyled">
								<li>
									<label for="ipsamok" class="pointer join-checkbox-label pull-left">
										<input id="ipsamok" type="checkbox" name="ipsamok"><span>잎샘 이용 약관 동의</span>
									</label>
									<div class="pull-right">
										<a id="ipsamok-btn" class="pointer">내용보기</a>
									</div>
									<div class="clearfix"></div>
								</li>
								<li>
									<label for="ipsamok2" class="pointer join-checkbox-label pull-left">
										<input id="ipsamok2" type="checkbox" name="ipsamok2"><span>개인 정보 수집,이용 동의</span>
									</label>
									<div class="pull-right">
										<a id="ipsamok2-btn" class="pointer">내용보기</a>
									</div>
									<div class="clearfix"></div>
								</li>
								<li>
									<label for="ipsamok3" class="pointer join-checkbox-label pull-left">
										<input id="ipsamok3" type="checkbox" name="ipsamok3"><span>만 14세 이상입니다.</span>
									</label>
									<div class="clearfix"></div>
								</li>
							</ul>
						</div>
						<div class="login-submit-div mt40">
							<a onclick="goJoin()" class="pointer">가입하기</a>
						</div>
					</form>
					<div class="mt10 small-join">
						<span>이미 잎샘 계정이 있다면? <a href="../login/login.jsp">로그인하러가기</a></span>
					</div>
				</div>
			</div>
		</section>
		
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" >
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="myModalLabel"></h4>
					</div>
					<div class="modal-body" style="overflow:hidden;">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript" src="js/ipsamperinfo.js"></script>

		



<%@ include file="../footer.jsp"%>