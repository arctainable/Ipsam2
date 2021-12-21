<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>



<%@ include file="projectbody.jsp" %>
		
		<script type="text/javascript">
			$(function(){
				var offset = $(".project-bar").offset();
				$('html, body').animate({ scrollTop: offset.top}, 800);
			})
		</script>
		
		<section>
			<div class="project-bar">
				<div class="container ">
					<a href="projectview.do?pno=${pvo.pno}">설명</a>
					<a href="community.do?pno=${pvo.pno}"><strong>커뮤니티</strong></a>
				</div>
			</div>
		</section>
		
		<script>
			function NewsDelete(){
				if(confirm('삭제하시겠습니까?')){
					modideleform.action="newsDelete.do";
					modideleform.method="post";
					modideleform.submit();
				}
			};
			function NewsModify(){
				modideleform.action="newsModify.do";
				modideleform.method="post";
				modideleform.submit();
			}
		</script>
		<form name="modideleform">
			<input type="hidden" name="nno" value="${nvo.nno}">
			<input type="hidden" name="pno" value="${pvo.pno}">
		</form>
		
		<script>
		$(function(){
			$("#comment-btn").on("click",function(){
				var comment = $("#comment-box").val();
				var newsno = modideleform.nno.value;
				if(comment == ""){
					alert("댓글을 입력해주세요");
					$("#comment-box").focus();
				}else{
					var now = new Date();	// 현재 날짜 및 시간
					var year = now.getFullYear();
					var month = (now.getMonth()+1);
					var date = now.getDate();
					$.ajax({
						type:"post",
						url:"commentinsert.do",
						data:{
							"comment":comment,
							"nno":newsno
						},
						success:function(data){
							$("#comment-box").val("");
							$("#chatlist").html(
									" <div class='user-comment mt20'> " +
									" <div class='pull-left'> " + 
									" <img class='user-photo' src='memberprofile/"+
									data.profile+
									" ' > " + 
									" </div> " + 
									" <div class='pull-left comment-content'> " +
									" <p> " + data.name + " </p> " +
									" <p> " + data.comment + " </p> " + 
									" </div> " + 
									" <div class='pull-right'> " + 
									" <span>"+year+"."+month+"."+date+"</span> "+ 
									" </div> " + 
									" <div class='clearfix'></div> "+
									" </div> "+$("#chatlist").html());
						},
						error:function(){
							alert("ㅠㅠ 문제가...");
						}
					})
				}
			});
			$(".comment-delete-btn").on("click",function(){
				if(confirm("정말 삭제 하시나요?")){
					var delecno = $(".comment-delete-btn").attr("cno");
					$.ajax({
						type:"post",
						url:"commentdelete.do",
						data:{
							"cno":delecno
						},
						success:function(data){
							alert("댓글이 삭제되었습니다")
							reload();
						},
						error:function(){
							alert("삭제 실패!");
						}
					})
				};
			});
		});
		function reload(){  
		       location.reload();
		}
		</script>		
		
		<section class="content-section">
			<div class="container">
				<div class="row mb100">
					<div class="col-md-8">
						<!--  -->
						<div class="project-content mt40">
							<div class="community-card">
								<div class="community-card-head">
									<span class="pull-left">
										<img class="user-photo" src="memberprofile/${nvo.profile}" >
									</span>
									<div class="commu-write">
										<span class="commu-writer">${nvo.name}</span><br/>
										<span class="commu-writedate">${nvo.regdate}</span>
									<div class="pull-right community_b">
										<c:if test="${nvo.id == User.id }">
										<a class="modify-btn pointer" onclick="NewsModify()">수정하기</a>
										<a class="delete-btn pointer" onclick="NewsDelete()">삭제하기</a>
										</c:if>
									</div>
									</div>
									
									<div class="clearfix"></div>
								</div>
								<div class="community-view-body">
									<div class="commu-content">
										${nvo.ncontent}
									</div>
								</div>
							</div>
							<div class="community-card-foot mt10">
								<i class="fas fa-comment"></i>&nbsp;${nvo.nccount}
							</div>
							<div class="">
								<div class="comment-writer">
									<form name="commentform" method="post">
									<div class="comment-inbox">
										<em class="comment-inbox-name">
											<c:choose>
												<c:when test="${empty User}">
													아이디 필요
												</c:when>
												<c:when test="${not empty User}">
													${User.id}
												</c:when>
											</c:choose>
										</em>
										<textarea class="comment-inbox-text" rows="3" cols="30" id="comment-box"
											<c:choose>
												<c:when test="${empty User}">
													placeholder="로그인후 이용 가능합니다" readonly
												</c:when>
												<c:when test="${not empty User}">
													placeholder="댓글을 남겨주세요" 
												</c:when>
											</c:choose>
										></textarea>
									</div>
									</form>
									<div class="commnet-btns">
										<div class="pull-right">
											<c:if test="${not empty User}">
												<a class="pointer comment-register comment_b" id="comment-btn">등록</a>
											</c:if>
										</div>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
							<div id="chatlist"><!-- 댓글창 -->
							
								<c:forEach var="clist" items="${clist}">
									<div class="user-comment mt20">
										<div class="pull-left">
											<img class="user-photo" src="memberprofile/${clist.profile}" >
										</div>
										<div class="pull-left comment-content">
											<p>${clist.name}</p>
											<p>${clist.ncomment}</p>
										</div>
										<div class="pull-right">
											<c:if test="${clist.id == User.id}">
												<a class='comment-delete-btn pointer' cno='${clist.cno}' >삭제</a>
											</c:if>
											<span>${clist.regdate}</span>
										</div>
										<div class="clearfix"></div>
									</div>
								</c:forEach>
								
							</div><!-- 댓글창 -->
						</div>
						<!--  -->
					</div>

<%@ include file="projectleg.jsp" %>


<%@ include file="../footer.jsp"%>