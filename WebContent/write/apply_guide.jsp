<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="css/common.css" rel="stylesheet">


	
		<style>
			section {position: relative;}
		</style>
		
		<section data-bs-spy="scroll" data-bs-target="#navbar-example">
			<div class="container">
				<h3 class="mt40">시작을 쉽게, 창작자 가이드</h3>
				<div class="row mt100">
					<div class="col-md-3">
						<nav id="navbar-example2" class="navbar navbar-light bg-light px-3">
							<ul class="nav nav-pills guide_nav" style="position:fixed;">
							  <li> <a class="navbar-brand" >잎샘 가이드</a></li><br>
								<li class="nav-item">
								  <a class="nav-link" href="#scrollspyHeading1">1. 프로젝트 등록</a>
								</li><br>
								<li class="nav-item">
								  <a class="nav-link" href="#scrollspyHeading2">2. 프로젝트 검토</a>
								</li><br>
								<li class="nav-item">
								  <a class="nav-link" href="#scrollspyHeading3">3. 후원 진행</a>
								</li><br>
								<li class="nav-item">
								  <a class="nav-link" href="#scrollspyHeading4">4. 진행 및 완료</a>
								</li>
						  </ul>
						</nav>
					</div>
					<div class="col-md-9">
					<div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-offset="0" class="scrollspy-example" tabindex="0">
			  <h4 id="scrollspyHeading1">1. 프로젝트 등록</h4>
			  <div class="container">
					<h4>프로젝트를 무료로 등록해보세요</h4>
					<p>검토가 완료된 프로젝트만 공개됩니다.</p>
					<p>그전까지는 공개되지 않으니 안심하세요.</p>
					<p>메인에서 프로젝트 작성 들어가는 방법(스크린샷)</p>
					<p>프로젝트 작성화면 설명(헤더 완성후 스크린샷 첨부)</p>
					<a href="applywrite.dol" class="main_color">프로젝트 등록하기 <i class="fas fa-chevron-right"></i></a>
			  </div>



			  <h4 id="scrollspyHeading2">2. 프로젝트 검토</h4>
			  <div class="container">
					<h4>프로젝트 등록 후 검토가 이루어집니다</h4>
					<p>검토가 승인/ 반려되는 기준 정하기</p>
					<p>반려 됐을 경우 어떻게 보여지는지 보여주기</p>
					<p>다시 승인 받으려면 어떻게 해야하는지?</p>
					
			  </div>
							  
							  
			  <h4 id="scrollspyHeading3">3. 후원 진행</h4>
					<div class="container">
					<h4>프로젝트 승인이 이루어진 후 후원이 진행됩니다</h4>
					<p>승인 후 어떤화면 보여지는지 </p>
					<p>후원은 어떻게 이루어지는지</p>
					<p>후원 기간에는 어떤 기능을 사용할 수 있는지</p>
					
			  </div>
			 <h4 id="scrollspyHeading4">4. 진행 및 완료</h4>
				<div class="container">
					<h4>정해진 기간까지 후원을 받은 후, 펀딩이 종료됩니다</h4>
					<p>펀딩이 종료되면 어떻게 되는지</p>
					<p>종료후에는 어떤 기능을 사용할 수 있는지</p>
					
			 	 </div>
					
				</div>
					
					
					</div>
				
				</div>
				
			</div>
		</section>

		<script>
			var scrollSpy = new bootstrap.ScrollSpy(document.section, {
			  target: '#navbar-example'
			});
			var dataSpyList = [].slice.call(document.querySelectorAll('[data-bs-spy="scroll"]'))
			dataSpyList.forEach(function (dataSpyEl) {
			  bootstrap.ScrollSpy.getInstance(dataSpyEl)
				.refresh()
			})
			
		</script>

<%@ include file="../footer.jsp"%>