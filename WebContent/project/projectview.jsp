<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%@ include file="projectbody.jsp" %>
		<section>
			<div class="project-bar">
				<div class="container ">
					<a href="projectview.do?pno=${pvo.pno}"><strong>설명</strong></a>
					<a href="community.do?pno=${pvo.pno}">커뮤니티</a>
				</div>
			</div>
		</section>
		
		<section class="content-section">
			<div class="container">
				<div class="row mb100">
					<div class="col-md-8">
						<div class="project-content mt40">
							${pvo.pcontent2}
						</div>
					</div>
					
<%@ include file="projectleg.jsp" %>

<%@ include file="../footer.jsp"%>