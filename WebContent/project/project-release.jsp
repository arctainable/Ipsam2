<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script src="js/kakaoshare.js"></script>
	<form name="shareform">
		<input type="hidden" name="title" value="${rpvo.pname2}">
		<input type="hidden" name="content" value="${rpvo.pcontent1}">
		<input type="hidden" name="imgUrl" value="http://localhost/Ipsam/projectupload/${rpvo.pname1}">
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
		<input type="hidden" name="pno" value="${rpvo.pno}">
	</form>
	<section>
			<div class="container">
				<div class="project-head mt80">
					<div class="head-info">
						<div class="row ">
							<div class="col-md-6">
								<div class="fundding-info">
									<div class="title-div">
										<h1 class="">${rpvo.pname2}</h1>
										<div class="writer-name">
											<span>${rpvo.name}</span>
										</div>
										<div class="mt40">${rpvo.pcontent1}</div>
										<div class="mt20">
											<fmt:parseDate value="${rpvo.odate}" var="opendate" pattern="yyyy-MM-dd"/>
											<fmt:formatDate value="${opendate}" var="odate" pattern="yyyy.MM.dd"/>
											<span style="color:#FF9696;">${odate} 공개예정</span>
										</div>
									</div>
									<div class="mt20 btn-warp">
										<div class="m0at xpdlqmf">
											<a class="like-btn pointer" onclick="projectlike()"><i class="fas fa-heart"></i> <span>${rpvo.likecount}</span></a>
											<a class="massege-btn" href="">문의하기</a>
											<a class="share-btn pointer" onclick="sendlink()">공유하기</a>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<img class="projectimg" src="projectupload/${rpvo.pname1}">
							</div>
						</div>
					</div>
				</div>
				
		</section>
		


<%@ include file="../footer.jsp"%>