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
<style>
 .fileDrop{
 	width: 100%;
 	height: 200px;
 	border : 1px dotted blue;
 }
 
 small
 {
 	margin-left: 3px;
 	font: blod;
 	color : gray;
 }
</style>

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
				 		action="regist" method="post" id="registForm">
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
                      <div class="item form-group" style="text-align: center;">
                      	<div>
                      		<hr>
                      	</div>
                      	<ul class="mailbox-attachments clearfix uploadedList">
                      	</ul>
                      </div>
                      <div class="box-footer">
                        <label for="exampleInputEmail1">File Drop Here!</label>
                      	<div class="fileDrop" >
                      		
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
	
	<script id="template" type="text/x-handlebars-template">
		<li>
			<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" 
				alt="Attachment"></span>
				<div class="mailbox-attachment-info">
				<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
				<a href="{{fullName}}"
					class="btn btn-default btn-xs pull-right delBtn"><i id="fileDel" data-src = "{{fullName}}" class="fa fa-fw fa-remove"></i></a>
			</span>
			</div>
		</li>
	</script>
	
	<script type="text/javascript">
	var template = Handlebars.compile($("#template").html());
	
	$(".fileDrop").on("dragenter dragover",function(e){
		e.preventDefault();
	});
	$(".fileDrop").on("drop",function(e){
		e.preventDefault();
		
		var files = e.originalEvent.dataTransfer.files;
		
		var file=files[0];
		
		console.dir(file);
		
		var formData = new FormData();
		formData.append("file",file);
		
		$.ajax({
			url:"/uploadAjax",
			data:formData,
			dataType:'text',
			processData:false,
			contentType:false,
			type:"POST",
			success:function(data){
				var fileInfo = getFileInfo(data);
				
				var html = template(fileInfo);
				
				$(".uploadedList").append(html);
			}
		});
		
	});
	
	$(".uploadedList").on("click","#fileDel",function(e){
		
		e.preventDefault();
		var that = $(this);
		$.ajax({
			url:"/deleteFile",
			type:"POST",
			data:{fileName:$(this).attr("data-src")},
			dataType:'text',
			success:function(result){
				console.log(result);
				if(result == 'deleted')
				{
					alert("deleted success");
					console.dir(that);
					that.parent("div").remove();	
				}
				
			},
			fail:function(){
				alert(1);
			}
		})
		
	})
	
	$("#registForm").submit(function(e){
		e.preventDefault();
		
		var that = $(this);
		var str="";
		$(".uploadedList .delBtn").each(function(index){
			str+="<input type='hidden' name='files["+index+"]' value='"+$(this).attr("href")+"'>";
		});
		
		that.append(str);
		
		that.get(0).submit();
	});
	</script>
	<script src="/resources/js/upload.js"></script>
</body>
</html>
<%@ include file="../include/footer.jsp"%>