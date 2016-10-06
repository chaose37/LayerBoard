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
			alert("글 수정 성공");
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

					<div class="box-tools">
						<div class="input-group input-group-sm" style="width: 150px;">
							<input type="text" name="table_search"
								class="form-control pull-right" placeholder="Search">

							<div class="input-group-btn">
								<button type="submit" class="btn btn-default">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
				<!-- end header -->
				<div>
					<table class="table table-condensed">
						<tr>
							<th>글번호</th>
							<td>${board.bno }</td>
							<th>글쓴이</th>
							<td>${board.writer }</td>
						</tr>
						<tr>
							<th>등록일</th>
							<td>
							<fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/>
							</td>
							<th>수정일</th>
							<td>
							<fmt:formatDate value="${board.updatedate}" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3">${board.title}</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3" rowspan="12">${board.content}</td>
						</tr>
					</table>
				</div>
			</div>
			<div style="text-align: right;">
				<a class="btn btn-primary col-md-offset-1"
					href="updateForm?bno=${board.bno}" role="button">수정</a>
			</div>
		</div>
	</div>
	</section>
</body>
</html>
<%@ include file="../include/footer.jsp"%>