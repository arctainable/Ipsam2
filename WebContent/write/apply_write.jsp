<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


<section>
	<div class="applyW_h"></div>
	<div class="container mt40">
		<div role="tabpanel">

			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist" id="myTab">
				<li role="presentation" class="active"><a href="#home"
					aria-controls="home" role="tab" data-toggle="tab">1. 프로젝트 개요</a></li>
				<li role="presentation"><a href="#profile"
					aria-controls="profile" role="tab" data-toggle="tab">2. 펀딩 및
						리워드</a></li>
				<li role="presentation"><a href="#messages"
					aria-controls="messages" role="tab" data-toggle="tab">3. 스토리텔링</a></li>
				<li role="presentation"><a href="#settings"
					aria-controls="settings" role="tab" data-toggle="tab">4. 계좌 설정</a></li>
			</ul>
			<form name="write" method="post" enctype="multipart/form-data">
				<!-- Tab panes -->
				<div class="tab-content apply_tab_content">
					<div role="tabpanel" class="tab-pane active" id="home">
						<h3>프로젝트 정보</h3>
						<p class="pull-right">
							<span class="main_color">*</span> 표시는 필수 작성 항목입니다.
						</p>

						<table>
							<tr>
								<th colspan="5"><h4>
										<span class="main_color">*</span> 프로젝트 제목
									</h4></th>
							</tr>
							<tr class="project_in">
								<td colspan="5"><input type="text" name="title" placeholder="제목을 입력해주세요" maxlength="25"></td>
							</tr>
							<tr>
								<th colspan="5"><h4>
										<span class="main_color">*</span> 프로젝트 소개
									</h4></th>
							</tr>
							<tr>
								<td colspan="5"><textarea name="p_intro" style="border: 1px solid #c4c4c4;" placeholder="프로필 란에 등록되는 프로젝트 소개글 입니다" cols="50" rows="2" maxlength="50"></textarea></td>
							</tr>
							<tr>
								<th colspan="5"><h4>
										<span class="main_color">*</span> 카테고리 선택
									</h4></th>
							</tr>
							<tr>
								<td><input type="radio" id="category1" name="Category" value="1"> 그림</td>
								<td><input type="radio" id="category2" name="Category" value="2"> 사진</td>
								<td><input type="radio" id="category3" name="Category" value="3"> 음악</td>
								<td><input type="radio" id="category4" name="Category" value="4"> 글</td>
								<td><input type="radio" id="category5" name="Category" value="5"> 영상</td>
							</tr>
							<tr>
								<th colspan="5"><h4>
										<span class="main_color">*</span> 대표 이미지
									</h4></th>
							</tr>
							<tr>
								<td colspan="5"><input type="file" name="pname1" id="appfile"></td>
							</tr>
						</table>

						<h3 class="mt100">진행자 정보</h3>
						<table>
							<tr>
								<th><h4>진행자 이름</h4></th>
							</tr>
							<tr>
								<td>
									<input type="text" class="writer_in" name="writer" value="${User.name}" readonly>
									<input type="hidden"  class="writer_in" name="writer" value="${User.id}" readonly>
								</td>
							</tr>
							<tr>
								<th><h4>진행자 소개</h4></th>
							</tr>
							<tr>
								<td><input style="width: 500px;" type="text" name="pcontent3"  class="writer_in" value=""></td>
							</tr>
						</table>
						<div class="container mt50" style="text-align: center;">
							<a class="project_Nb pointer" onclick="goNextStep1()">다음단계</a>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="profile">
						<p class="pull-right">
							<span class="main_color">*</span> 표시는 필수 작성 항목입니다.
						</p>

						<table>
							<tr>
								<th colspan="4"><h4>
										<span class="main_color">*</span> 목표 금액
									</h4></th>
							</tr>
							<tr class="project_in">
								<td colspan="4"><input type="number" name="g_price" placeholder="금액을 입력해주세요"></td>
							</tr>
							<tr>
								<th colspan="4"><h4>
										<span class="main_color">*</span> 프로젝트 기간
									</h4></th>
							</tr>
							<tr>
								<td><input type="date" name="start_date" id="start_date"  class="writer_date_in" min='1899-01-01' max='2000-13-13'> 부터  <input type="date" name="goal_date" id="goal_date" class="writer_date_in"> 까지</td>
								<td></td>
								<td colspan="2"></td>
							</tr>
							<tr>
								<th colspan="4">
									<h4> <span class="main_color">*</span> 리워드 설정 </h4>
								</th>
							</tr>
							<tr class="reward_in">
								<td>
									<input style="width: 500px;" type="text" name="reward_c1" placeholder="기본 리워드 입니다"> 
									<input style="width: 500px;" type="text" name="reward_c2" placeholder="리워드 설명을 입력해주세요">
									<input style="width: 500px;" type="text" name="reward_c3" placeholder="리워드 설명을 입력해주세요">
								</td>

								<td>
									<input type="number" name="reward_p1" value="1000" readonly> 
									<input type="number" name="reward_p2" placeholder="가격을 입력해주세요"> 
									<input type="number" name="reward_p3" placeholder="가격을 입력해주세요">
								</td>
							</tr>
						</table>
						<div class="container mt50" style="text-align: center;">
							<a class="project_Nb pointer" onclick="goNextStep0()">이전단계</a>
							<a class="project_Nb pointer" onclick="goNextStep2()">다음단계</a>
						</div>

					</div>
					<div role="tabpanel" class="tab-pane" id="messages">
						<div class="mt40">
							<h2><span class="main_color">*</span> 프로젝트 소개</h2>
							<p>- 무엇을 만들기 위한 프로젝트인가요? 이 프로젝트의 특별한 점은 무엇인가요?</p>
							<p>- 기획, 구상부터 디자인, 시제품 제작에 오기까지 그간의 고민, 시행착오 등 고유한 창작 '과정'이 잘 드러나도록 스토리를 작성해 주세요.</p>
							<p>- 샘플이나 콘텐츠 미리보기 이미지를 포함해 주세요. 매력적인 이미지는 후원자 참여에 중요한 역할을 합니다.</p>
						</div>
						<div class="mt40">	
							<textarea class="summernote" name="content2"></textarea>
						</div>
						<div class="container mt50" style="text-align: center;">
							<a class="project_Nb pointer" onclick="goNextStep1()">이전단계</a>
							<a class="project_Nb pointer" onclick="goNextStep3()">다음단계</a>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="settings">
						<p class="pull-right">
							<span class="main_color">*</span> 표시는 필수 작성 항목입니다.
						</p>

						<table>
							<tr>
								<th colspan="4"><h4>
										<span class="main_color">*</span>은행명
									</h4></th>
							</tr>
							<tr class="reward_in">
								<td colspan="4"><input type="text" name="bank_name" placeholder="은행명을 입력해주세요"></td>
							</tr>
							<tr>
								<th colspan="4"><h4>
										<span class="main_color">*</span> 계좌번호
									</h4></th>
							</tr>
							<tr class="project_in">
								<td colspan="4"><input type="text" name="account_num" placeholder="(-)은 제외하고 입력해주세요" maxlength="15"></td>
							</tr>
							<tr>
								<th colspan="4">
									<h4>
										<span class="main_color">*</span> 이메일 인증
									</h4>
								</th>
							</tr>
							<tr>
								<td colspan="4">
									<input type="text" class="writer_in" name="email" placeholder="이메일 주소를 입력해주세요" value="${User.email}"> 
									<input type="button" class="writer_in_button"  id="btn_email" value="전송">
								</td>
							</tr>
							<tr>
								<th colspan="4"><h4>
										<span class="main_color">*</span> 인증번호
									</h4></th>
							</tr>
							<tr>
								<td colspan="4">
									<div id="emailrec" style="display:none;">
										<input type="text" class="writer_in" name="email_check" placeholder="인증번호를 입력해주세요"> 
										<input class="writer_in_button" id="btn_ok" type="button" value="확인">
										<input type="hidden" name="email_check_yes" >
									</div>
								</td>
							</tr>
						</table>

						<div class="container" style="text-align: center;">
							<a class="project_Nb pointer" onclick="goNextStep2()">이전단계</a>
							<a class="project_b pointer" onclick="goCheck()">프로젝트 등록</a>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>


<!-- 서머노트를 위해 추가해야할 부분 -->
<script src="js/summernote-lite.js"></script>
<script src="lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="css/summernote-lite.css">
<script src="js/getsummernote.js"></script>

<script>
var today = new Date();
var dd = today.getDate();
var mm = today.getMonth()+1; //January is 0!
var yyyy = today.getFullYear();
 if(dd<10){
        dd='0'+dd
    } 
    if(mm<10){
        mm='0'+mm
    } 
today = yyyy+'-'+mm+'-'+dd;
document.getElementById("start_date").setAttribute("min", today);

 function goCheck(){
	
	if(write.title.value==""){
		$('#myTab a[href="#home"]').tab('show')
		alert("프로젝트 제목을 입력해주세요");
		write.title.focus();
		return;
	}
	if(write.p_intro.value==""){
		$('#myTab a[href="#home"]').tab('show')
		alert("프로젝트 소개를 입력해주세요");
		write.p_intro.focus();
		return;
	}
	if($(':radio[name="Category"]:checked').length < 1){
		$('#myTab a[href="#home"]').tab('show')
	    alert('카테고리를 선택해주세요');                        
	    write.Category1.focus();
	    return;
	}
	//첨부파일 유효성 검사

	if(!$("#appfile").val()){
		$('#myTab a[href="#home"]').tab('show')
		alert("첨부파일 추가");
		$("#appfile").focus();
		return;
	}
	if($("#appfile").val != ""){
		var ext = $("#appfile").val().split('.').pop().toLowerCase(); //첨부파일 확장자만 저장
		if($.inArray(ext,['gif','png','jpg','jpeg']) == -1){
			$('#myTab a[href="#home"]').tab('show')
			alert("이미지만 첨부 가능");
			$("#appfile").val("");
			return;
		}
	}
	if(document.getElementById("appfile").value != ""){
		var fileSize = document.getElementById("appfile").files[0].size;
		var maxSize = 4 * 1024 * 1024;
		if(fileSize > maxSize){
			$('#myTab a[href="#home"]').tab('show');
			alert("4MB 이내로 등록 가능");
			return;
		}
	}
	
	
	if(write.g_price.value==""){
		$('#myTab a[href="#profile"]').tab('show');
		alert("목표 금액을 입력해주세요");
		write.g_price.focus();
		return;
	}
	if(write.start_date.value==""){
		$('#myTab a[href="#profile"]').tab('show');
		alert("프로젝트 시작날짜를 설정해주세요");
		return;
	}
	if(write.goal_date.value==""){
		$('#myTab a[href="#profile"]').tab('show');
		alert("프로젝트 종료날짜를 설정해주세요");
		return;
	}
	//날짜 유효성 검사
	 var startDate = $('#start_date').val();
     var endDate = $('#goal_date').val();
     //-을 구분자로 연,월,일로 잘라내어 배열로 반환
     var startArray = startDate.split('-');
     var endArray = endDate.split('-');   
     //배열에 담겨있는 연,월,일을 사용해서 Date 객체 생성
     var start_date = new Date(startArray[0], startArray[1], startArray[2]);
     var end_date = new Date(endArray[0], endArray[1], endArray[2]);
       //날짜를 숫자형태의 날짜 정보로 변환하여 비교한다.
     if(start_date.getTime() > end_date.getTime()) {
 		$('#myTab a[href="#profile"]').tab('show')
         alert("종료날짜보다 시작날짜가 작아야합니다.");
         return false;
     }
	
	if(write.reward_p1.value==""){
		$('#myTab a[href="#profile"]').tab('show')
		alert("1번 리워드 가격을 입력해주세요");
		write.reward_p1.focus();
		return;
	}
	
	if(write.reward_c1.value==""){
		$('#myTab a[href="#profile"]').tab('show')
		alert("1번 리워드 설명을 입력해주세요");
		write.reward_c1.focus();
		return;
	}

	if(write.reward_p2.value==""){
		$('#myTab a[href="#profile"]').tab('show')
		alert("2번 리워드 가격을 입력해주세요");
		write.reward_p2.focus();
		return;
	}
	
	if(write.reward_c2.value==""){
		$('#myTab a[href="#profile"]').tab('show')
		alert("2번 리워드 설명을 입력해주세요");
		write.reward_c2.focus();
		return;
	}
	if(write.reward_p3.value==""){
		$('#myTab a[href="#profile"]').tab('show')
		alert("3번 리워드 가격을 입력해주세요");
		write.reward_p3.focus();
		return;
	}
	
	if(write.reward_c3.value==""){
		$('#myTab a[href="#profile"]').tab('show')
		alert("3번 리워드 설명을 입력해주세요");
		write.reward_c3.focus();
		return;
	}
	if(write.bank_name.value==""){
		alert("은행명을 입력해주세요");
		write.bank_name.focus();
		return;
	}
	
	if(write.account_num.value==""){
		alert("계좌번호를 입력해주세요");
		write.account_num.focus();
		return;
	}
	
	if(write.email_check_yes.value==""){
		alert("이메일 인증이 필요합니다");
		write.email.focus();
		return;
	}
	
	write.action = "projectupload.do";
	write.submit();
 }
</script>
<script>
	function goNextStep0(){
		$('#myTab a[href="#home"]').tab('show');
	}
	function goNextStep1(){
		$('#myTab a[href="#profile"]').tab('show');
	}
	function goNextStep2(){
		$('#myTab a[href="#messages"]').tab('show');
	}
	function goNextStep3(){
		$('#myTab a[href="#settings"]').tab('show')
	}
</script>
<script>
	$(function (){
		$("#btn_email").on("click", function(){
			var email = write.email.value;
			$("#emailrec").show();
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
			var certinumber = write.email_check.value;
			if(certinumber == ""){
				alert("인증번호 입력");
				 write.email_check.focus();
			}else{
				$.ajax({
					type:"post",
					dataType:"json",
					async:false,
					data:{"certinumber":certinumber},
					url:"certicompare.do",
					success:function(data){
						alert(data.msg);
						if(data.check == "ok"){
							write.email_check_yes.value="1";
						}else{
							alert("다시시도해 주세요");
						}
					},error:function(){
						alert("이메일 주소를 확인하세요");
					}
				})
			}
		}) //
	});
	</script>

	<c:if test="${not empty message }">
		<script>
			//alert("${message}"); 이거는 보안상 해킹당할수 있으니 밑에 것으로 작성하자
			alert('<c:out value="${message}"/>');
		</script>
	</c:if>
	<% session.removeAttribute("message"); %>
<%@ include file="../footer.jsp"%>