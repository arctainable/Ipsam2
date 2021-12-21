<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<link href="css/adminsublayout.css" rel="stylesheet">

<div class="col-md-9">
						<div class="adminbord">
							<div class="">
								<div class="pull-left">
									<h3>게시물 관리 페이지 입니다</h3>
								</div>
								<div class="pull-right">
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="notice_main">
							<table class="table n_table">
							<colgroup>
								<col width = "10%"/>
								<col width = "90%"/>
							</colgroup>
								<tr>
									<th>제목</th>
									<td>${evo.title}</td>
								</tr>
								<tr>
									<th>작성일</th>
									<td>${evo.regdate}</td>
								</tr>
								<tr>
									<th style="vertical-align: middle;">내용</th>
									<td style="height: 300px; padding: 40px;">
									<img style="height: 460px;" src="eventupload/${evo.thumbnail}">
									${evo.content} </td>
								</tr>							
							</table>
							<div style="text-align: center; margin-left: 100px;">
								<a class="write_sb" href='eventdelete.do?bno=${evo.bno}' onClick="return confirm('삭제하시겠습니까?')">삭제</a>
								<input type="button" class="write_lb" value="목록" onClick="location.href='event-manger.do'">
							</div>
						</div>
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

		
		<footer>
		</footer>
	</body>
</html>