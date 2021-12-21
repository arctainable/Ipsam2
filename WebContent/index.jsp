<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link href="css/index.css" rel="stylesheet">

<div class="container">
	<section>
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>


			<!-- Wrapper for slides -->
         <div class="carousel-inner" role="listbox">
            <div class="item active">
               <div class="row">
                  <div class="col-md-8">
                     <img src="img/carousel1.jpg" style="width: 100%;" alt="">
                  </div>

                  <div class="col-md-4 carousel_text_part">
                        <h2 style="   margin-top: 150px;">해금 전자음악과</h2>
                        <h2>단편 소설의 결합</h2>
                        <p>음악과 글로써 생명력을 전하는 &lt;이구와 도화&gt;</p>
                  </div>
               </div>
            </div>
          <div class="item">
               <div class="row">
                  <div class="col-md-8">
                     <img src="img/carousel2.jpg" style="width: 100%;" alt="">
                  </div>

                  <div class="col-md-4 carousel_text_part2">
                     
                        <h2 style="   margin-top: 150px;">영화를 삼킨 파도에</h2>
                        <h2>올라타보자</h2>
                        <p>새로운 영화산업을 상상하는  &lt;파도필름 영화제&gt;</p>
                     
                  </div>
               </div>
            </div>
            <div class="item">
               <div class="row">
                  <div class="col-md-8">
                     <img src="img/carousel3.jpg" style="width: 100%;" alt="">
                  </div>

                  <div class="col-md-4 carousel_text_part3">
                     
                        <h2 style="   margin-top: 150px;">배송 고민 내려놓고</h2>
                        <h2>프로젝트에 집중하기</h2>
                        <p>CJ 대한통운이 상담과 할인을 제공합니다</p>
                  </div>
               </div>
            </div>
         </div> 




			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</section>
</div>

<section>
	<div class="container">
		<div class="row">
			<div class="col-md-8 NewPro">
				<h3>새로운 프로젝트</h3>
				
				<c:forEach var="mainList" items="${mainList}">
				<div class="col-md-4 NewPro">
					<div class="item-n">
						<div class="project-card">
							<div class="index_item-image">
								<a href="projectview.do?pno=${mainList.pno}"> <img src="projectupload/${mainList.pname1}">
								</a>
							</div>
							<div class="Nitem-view">
								<ul class="list-unstyled">
									<li class="item_ti"><a href="projectview.do?pno=${mainList.pno}">${mainList.pname2}</a></li>
									<li class="item_sub">${mainList.pcontent1}</li>
								</ul>
							</div>
							<div class="Nitem-funddingstat">
								<span class="new_percent"><fmt:formatNumber value="${mainList.nowmoney / mainList.pmoney }" pattern="#,##%" /> </span>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
				
			</div>
			<!-- 8 -->


			<div class="col-md-4 Rank">
				<h3>랭킹</h3>
				<p class="rank_sub">좋아요수가 높은 순위입니다</p>
				<c:set var="num" value="1" />
				<c:forEach var="rankList" items="${rankList}">
				<div class="rank1">
					<div class="col-md-2">
						<h4>${num}</h4>
					</div>
					<div class="col-md-6 rank_info">
						<p>${rankList.pname2}</p>
						<p><fmt:formatNumber value="${rankList.nowmoney / rankList.pmoney }" pattern="#,##%" /></p>
					</div>
					<div class="col-md-4 rank_img">
						<img src="projectupload/${rankList.pname1}">
					</div>
				</div>
				<c:set var="num" value="${num+1}" />
				</c:forEach>
			</div>
			<!-- 4 -->
		</div>
		<!-- row -->
	</div>
	<!--container -->
</section>

<!-- 이벤트 -->
<section>
	<div class="container">
		<div class="row">
			<h3>이벤트</h3>
			
			<c:forEach var="elist" items="${elist}">
			<div class="col-md-4 event">
				<div class="imgbox">
					<img src="eventupload/${elist.thumbnail}">
				</div>
				<div class="col-md-8">
					<h4>${elist.title}</h4>
					<p>${elist.content}</p>
				</div>
				<div class="col-md-4">
					<input type="button" class="btn" value="바로가기" onclick="location.href='eventview.do?bno=${elist.bno}'">
				</div>
			</div>
			</c:forEach>

	</div>
	<!--container -->
</section>


<!-- 공개예정 -->
<section>
	<div class="container">
		<div class="row">
			<h3>공개예정 프로젝트</h3>
			
			<c:forEach var="releList" items="${releList}">
			<div class="col-md-3 RPro">
				<div class="item-n">
					<div class="project-card">
						<div class="item-image">
							<a href="projectrelease.do?pno=${releList.pno}"> <img src="projectupload/${releList.pname1}">
							</a>
						</div>
						<div class="Ritem-view">
							<ul class="list-unstyled">
								<li class="Ritem_ti"><a href="projectrelease.do?pno=${releList.pno}">${releList.pname2}</a></li>
								<fmt:parseDate value="${releList.odate}" var="opendate" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${opendate}" var="odate" pattern="yyyy.MM.dd"/>
								<li class="Ritem_sub">${odate} ~ </li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>

		</div>
		<!-- row -->
	</div>
	<!--container -->
</section>



<%@ include file="footer.jsp"%>