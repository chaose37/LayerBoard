<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="navi" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	$(function ()
	{
		if("${msg}")
		{
			alert("글 등록 성공");
		}
	});
</script>
</head>
<body>
	<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">게시판입니다요</h3>

					<div class="box-tools" >
				<form action="list">
				<span style="float: left">
				글쓴이 <input type="checkbox" name="sWriter" value="sWriter">
				제목 <input type="checkbox" name="sTitle" value="sTitle">
				내용 <input type="checkbox" name="sContent" value="sContent">
				</span>
						<div class="input-group input-group-sm" style="width: 250px; text-align: right;">
								<input type="text" name="searchWord"
									class="form-control pull-right" placeholder="Search">
	
								<div class="input-group-btn">
									<button type="submit" class="btn btn-default">
										<i class="fa fa-search"></i>
									</button>
							</div>
						</div>
				</form>
					</div>
				</div>
				<div class="box-body table-responsive no-padding">
					<table class="table table-hover">
						<tr>
							<th>글번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>조회수</th>
							<th>등록일</th>
							<th>수정일</th>
						</tr>
						<c:if test=" ${empty list}">
							<tr>
								<th colspan="6">리스트에 값이 없습니다.</th>
							</tr>
						</c:if>
						<c:forEach var="board" items="${list}">
							<tr>
								<td>${board.bno}</td>
								<td><a href="detail?bno=${board.bno}">${board.title}</a></td>
								<td>${board.writer}</td>
								<td>${board.viewcnt}</td>
								<td><fmt:formatDate value="${board.regdate}"
										pattern="yyyy-MM-dd" /></td>
								<td><fmt:formatDate value="${board.updatedate}"
										pattern="yyyy-MM-dd" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div>
					<navi:page />
				</div>
			</div>
				<div>
					<a href="registForm" class="btn btn-success">글쓰기</a>
					
					
				</div>
		</div>
	</div>
	</section>
</body>
</html>
<%@ include file="../include/footer.jsp"%>