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
									<button class="board_write_b" onclick="location.href='eventwrite.do'">글 작성</button>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="mt20">
								<ul class="admin-write-menu list-inline">
									<li><a href="notice-manger.do">공지사항</a></li>
									<li><a href="event-manger.do">이벤트</a></li>
								</ul>
							</div>
						<div class="row">
						<c:forEach var="elist" items="${elist }">
							<div class="col-md-4 event">
								<img src="eventupload/${elist.thumbnail }">
								<div class="col-md-8">
									<h4>${elist.title }</h4>
									<p>${elist.content }</p>
								</div>
								<div class="col-md-4">
									<input type="button" class="btn" value="바로가기" onclick="location.href='eventadminview.do?bno=${elist.bno }'">
								</div>
							</div>
						</c:forEach>
							
							
						</div> <!--row-->
							
							
						</div>
					</div>
				</div>
			</div>
		</section>
		

		
		<footer>
		</footer>
	</body>
</html>