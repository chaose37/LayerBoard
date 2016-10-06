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
				 <form class="form-horizontal form-label-left" novalidate
				 		action="regist" method="post">
				 
                      <span class="section">Personal Info</span>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">제목 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="title" name="title" placeholder="title" required="required" type="text" class="form-control col-md-7 col-xs-12"> 
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">글쓴이 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input id="writer" name="writer" placeholder="writer" required="required" type="text" class="form-control col-md-7 col-xs-12"> 
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">내용 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                    	  <textarea id="content" required="required" name="content" class="form-control col-md-7 col-xs-12" rows=12></textarea>
                        </div>
                      </div>
					<br> <br>
						<div style="text-align: center;">
							<button type="submit" class="btn btn-primary" href="regist" role="button">등록</button>
							 <a class="btn btn-danger col-md-offset-1" href="list?pageNo=1" role="button">취소</a>
						</div>
					</form>
					
					
					 <br> <br>
				</div>
			</div>
		</div>
	</div>
	</section>
</body>
</html>
<%@ include file="../include/footer.jsp"%>