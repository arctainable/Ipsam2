<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	Date nowTime = new Date();
SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
%>

<link href="css/adminsublayout.css" rel="stylesheet">

<div class="col-md-9">
	<div class="adminbord">
		<div class="">
			<div class="pull-left">
				<h3>게시물 관리 페이지 입니다</h3>
			</div>
			<div class="pull-right"></div>
			<div class="clearfix"></div>
		</div>
		<form name="notice" enctype="multipart/form-data">
			<div class="notice_main">
				<table class="table n_table">
					<colgroup>
						<col width="10%" />
						<col width="90%" />
					</colgroup>
					<tr>
						<th>분류</th>
						<td>공지사항</td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" value="${nvo.title }"></td>
					</tr>
					<tr>
						<th>작성일</th>
						<td><%=sf.format(nowTime)%></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${User.name}
						<input type="hidden" name="writer" value="${User.name}"> 
						</td>
					</tr>
					<tr>
						<th style="vertical-align: middle;">내용</th>
						<td style="height: 300px; padding: 40px;">
							<textarea class="summernote" name="content">${nvo.content }</textarea>
						</td>
					</tr>
				</table>
				<div style="text-align: center; margin-left: 100px;">
					<a class="write_sb" href="javascript:check()">저장</a> <input
						type="button" class="write_lb" value="목록"
						onClick="location.href='notice-manger.do'">
				</div>
			</div>
		</form>
	</div>
</div>
</div>
</div>
</section>

<!-- 서머노트를 위해 추가해야할 부분 -->
<script src="js/summernote-lite.js"></script>
<script src="lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="css/summernote-lite.css">
<script src="js/getsummernote.js"></script>



<script>
	function check() {
		if(notice.title.value ==""){
			alert("제목을 입력해주세요");
			notice.title.focus();
			return;
		}
		if(notice.content.value ==""){
			alert("내용을 입력해주세요");
			notice.content.focus();
			return;
		}
		
		notice.method = "post";
		notice.action = "noticeUpdatePro.do";
		notice.submit();
	}
</script>

<footer> </footer>
</body>
</html>