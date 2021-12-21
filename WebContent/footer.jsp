<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
	<footer>
		<div class="footer">
			<div class="container-fluid">
				<div class="container">
					<div class="row">
						<div class="col-md-2">
							<img src="img/잎샘.png" id="logo2">
						</div>
						<div class="col-md-1 footerm">
							<ul>
								<li><a href="introduce.do">회사소개</a></li>
								<li><a href="notice.do">공지사항</a></li>
								<li><a href="event.do">이벤트</a></li>
								<li><a href="faq.do">FAQ</a></li>
							</ul>
						</div>
						<div class="col-md-2 footerm">
							<ul>
								<li><a href="">이용약관</a></li>
								<li><a href="">개인정보 처리방침</a></li>
								<li><a href="">수수료 정책</a></li>
							<c:if test="${User.grade eq 3 }">
								<li><a href="admin.do" style="color:red;">관리자페이지</a></li>
							</c:if>
							</ul>
						</div>
						<div class="col-md-7 fotter_content">
							<br> 잎샘은 플랫폼 제공자로서 프로젝트의 당사자가 아니며, 직접적인 통신판매를 진행하지 않습니다.<br>
							프로젝트의 완수 및 선물제공의 책임은 해당 프로젝트의 창작자에게 있으며,<br> 프로젝트와 관련하여 후원자와
							발생하는 법적 분쟁에 대한 책임은 해당 창작자가 부담합니다.<br>
							<br> 잎샘(주) | 대표 백승국 351-07-28859 | 대전광역시 중구 계룡로 825 
							<br> 통신판매업 2021-052105-21-5-02105 | 대표전화 02-1234-1234
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>