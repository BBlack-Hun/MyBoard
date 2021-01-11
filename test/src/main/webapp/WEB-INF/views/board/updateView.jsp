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
			
			$(".cancel_btn").on("click", function(){
				event.preventDefault();
				location.href = "/board/index";
			})
			
			$(".update_btn").on("click", function(){
				if(fn_valiChk()){
					return false;
				}
				formObj.attr("action", "/board/update");
				formObj.attr("method", "post");
				formObj.submit();
			})
		})
		function fn_valiChk(){
			var updateForm = $("form[name='updateForm'] .chk").length;
			for(var i = 0; i<updateForm; i++){
				if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
					alert($(".chk").eq(i).attr("title"));
					return true;
				}
			}
		}
	
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
				<form name="updateForm" role="form" method="post" action="/board/update">
					<input type="hidden" name="no" value="${update.no}" readonly="readonly"/>
					
					<div class="form-group">					
						<label for="title" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<input type="text" id="title" name="title" value="${update.title}" class="chk form-control" title="제목을 입력해주세요"/>
						</div>
					</div>
					<div class="form-group">
						<label for="content" class="col-sm-2 control-label">내용</label>
						<div class="col-sm-10">
							<textarea id="content" name="content" class="chk form-control" title="내용을 입력해주세요"><c:out value="${update.content}" /></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="writer" class="col-sm-2 control-label">작성자</label>
						<div class="col-sm-10">
							<input type="text" id="writer" name="writer" value="${update.writer}" readonly="readonly" class="form-control"/>
						</div>
					</div>
					<div class="form-group">
						<label for="regDt" class="col-sm-2 control-label">작성날짜</label>
						<div class="col-sm-10">
							<fmt:formatDate value="${update.regDt}" pattern="yyyy-MM-dd" />
						</div>					
					</div>				
					
					<div>
						<button type="submit" class="update_btn btn btn-success">저장</button>
						<button type="submit" class="cancel_btn btn btn-primary">취소</button>
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>