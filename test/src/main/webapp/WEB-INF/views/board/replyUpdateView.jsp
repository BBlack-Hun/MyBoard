<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	 	<title>게시판</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			var formObj = $("form[name='updateForm']");
			
			$(".cancel_btn").on("click", function(){
				location.href = "/board/readView?no=${replyUpdate.no}"
					   + "&page=${scrl.page}"
					   + "&perPageNum=${scrl.perPageNum}"
					   + "&searchType=${scrl.searchType}"
					   + "&keyword=${scrl.keyword}";
			});
			
		})
		
	</script>
	<body>
	
		<div class="container">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<div>
				<%@include file="nav.jsp" %>
			</div>
			<hr />
			
			<section id="container">
				<form name="updateForm" role="form" method="post" action="/board/replyUpdate">
					<input type="hidden" id="no" name="no" value="${replyUpdate.no}" />
					<input type="hidden" id="rno" name="rno" value="${replyUpdate.rno}" />
					<input type="hidden" id="page" name="page" value="${scrl.page}"> 
					<input type="hidden" id="perPageNum" name="perPageNum" value="${scrl.perPageNum}"> 
					<input type="hidden" id="searchType" name="searchType" value="${scrl.searchType}"> 
					<input type="hidden" id="keyword" name="keyword" value="${scrl.keyword}"> 
					
					<div class="form-group">
						<label for="content" class="col-sm-2 control-label">댓글 내용</label>
						<div class="col-sm-10">
							<input type="text" id="content" name="content" value="${replyUpdate.content}" class="form-control"/>
<%-- 						<input type="text" id="no" name="no" value="${replyUpdate.no}" /> --%>
						</div>
					</div>
					<div>
						<button type="submit" class="update_btn btn btn-succes">저장</button>
						<button type="button" class="cancel_btn btn btn-primary">취소</button>
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>