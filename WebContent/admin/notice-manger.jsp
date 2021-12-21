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
									<button class="board_write_b" onclick="location.href='noticewrite.do'">글 작성</button>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="mt20">
								<ul class="admin-write-menu list-inline">
									<li><a href="notice-manger.do">공지사항</a></li>
									<li><a href="event-manger.do">이벤트</a></li>
								</ul>
							</div>
							<div class="notice_main">
							<table class="table" style="text-align: center;">
								<colgroup>
									<col width="5%">
									<col width="60%">
									<col width="10%">
									<col width="15%">
									<col width="10%">
								</colgroup>
								<tr>
									<th style="text-align: center;">번호</th>
									<th style="text-align: center;">제목</th>
									<th style="text-align: center;">작성자</td>
									<th style="text-align: center;">작성일</th>
									<th style="text-align: center;">조회수</th>
								</tr>
								
								<c:forEach var="nlist" items="${nlist }">
									<tr>
										<td>${nlist.bno }</td>
										<td><a href="noticeadminview.do?bno=${nlist.bno}">${nlist.title }</a></td>
										<td>${nlist.writer }</td>
										<td>${nlist.regdate }</td>
										<td>${nlist.viewcount }</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		

		
		<footer>
		</footer>
	</body>
</html>