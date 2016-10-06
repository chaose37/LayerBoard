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
	.popup{position: absolute;}
	.back { background-color: gray; opacity:0.5; width: 100%; height: 300%; 
	overflow:hidden; z-index:1101;}
	
	.front
	{
		z-index:1110; opacity:1; boarder: 1px; margin: auto;
	}
	.show{
	position: relative;
	max-width: 1200px;
	max-height: 800px;
	overflow: auto;
	}
</style>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script type="text/javascript">
	$(function ()
	{
		console.dir("${page.searchWord}");	
		if("${msg}")
		{
			alert("글 수정 성공");
		}
		if("${page.searchWord}"){
			$("#atitle")
			.attr("href",$(this).attr("href")+
					"&searchWord=${page.searchWord}"+
					"&stitle=${page.stitle}"+
					"&scontent=${page.scontent}"+
					"&swriter=${page.swriter}"
			)
		}
		$("#listBtn").on("click",function(){
			var path = "list?pageNo=${page.pageNo}";
			$(this).attr("href",path);
		})
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
					<div class="popup back" style="display: none;"></div>
					<div id="popup_front" class='popup front' style="display: none;">
						<img id="popup_img">
					</div>
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
							<td colspan="3" rowspan="12">${board.content}
							<ul class = "mailbox-attachments clearfix uploadedList"></ul>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="box box-success">
						<div class="box-header">
							<h3> 댓글 추가 </h3>
						</div>
						<div class="box-body">
							<label for="exampleInputEmail1"> 작성자 </label>
							<input class="form-control" type="text" placeholder="USER_ID"
							id="newWriter">
							<label for="exampleInputEmail1"> 내용 </label>
							<input class="form-control" type="text" placeholder="Content"
							id="newContent">
						</div>
						<div class="box-footer">
							<button type="submit" class="btn btn-primary" id="commentAddBtn">등록</button>
						</div>
					</div>
					<ul class="timeline">
						<li class="time-label" id="commentDiv">
						<span class="bg-green">Comment List</span>
						</li>
					</ul>
					<div class="text-center">
						<ul id="pagination" class="pagination pagination-sm no-margin">
						
						</ul>
					</div>
				</div>
			</div>
			<div style="text-align: right;">
				<a id = "listBtn" class="btn brn-primary" role="button">목록</a>
				<a class="btn btn-primary"
					href="replyForm?gno=${board.gno}&depth=${board.depth +1}&bno=${board.bno}&gorder=${board.gorder}" 
					role="button">답글</a>
				<a class="btn btn-primary" 
					href="updateForm?bno=${board.bno}" role="button">수정</a>
				<a class="btn btn-danger" 
					href="delete?bno=${board.bno}" role="button">삭제</a>
			</div>
		</div>
	</div>
	</section>
	<!-- Modal -->>
	<div id="updateModal" class ="modal modal-primary fade" role="dialog">
		<div class="modal-dialog">
		<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body" data-cno>
				<p><input type="text" id="commenttext" class="form-controll"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="commentUpdateBtn">
					수정</button>
					<button type="button" class="btn btn-danger" id="commentDeleteBtn">
					삭제</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
					닫기</button>
				</div>
			</div>
		</div>
	</div> 
		
	
	
	<script id="template" type="text/x-handlebars-template">
	{{#each .}}
<li class="commentLi" data-cno={{cno}}>
<i class="fa fa-comments bg-blue"></i>
  <div class="timeline-item">
   <span class="time">
   <i class="fa fa-clock-o"></i>{{prettifyDate regdate}}
	</span>
			<h3 class="timeline-header"><strong>{{cno}}</strong>-{{writer}}</h3>
			<div class="timeline-body"> {{content}} </div>
				<div class="timeline-footer">
					<a class="btn btn-primary btn-xs" data-toggle="modal"
					 data-target="#updateModal"> 수정 </a>
				</div>
			</div>
		</li>
	{{/each}}
	</script>
	<script type="text/javascript">
	Handlebars.registerHelper("prettifyDate",function(timeValue){
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year+"/"+month+"/"+date;
	});
	
	var printData = function(commentArr, target, templateObject){
		
		var template = Handlebars.compile(templateObject.html());
		
		var html = template(commentArr);
		$(".commentLi").remove();
		target.after(html);
		
	}
	</script>
	<script id="fileDiv" type="text/x-handlebars-template">
		<li data-src='{{fullName}}'>
			<span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" 
				alt="Attachment"></span>
				<div class="mailbox-attachment-info">
				<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
			</span>
			</div>
		</li>
	</script>
	<script>
	var bno = ${board.bno};
	var fileDiv = Handlebars.compile($("#fileDiv").html());
	
	$.getJSON("/board2/getFile/"+bno,function(list){
		$(list).each(function(){
			var fileInfo = getFileInfo(this);
			
			var html = fileDiv(fileInfo);
			
			$(".uploadedList").append(html);
		})
	});
	$(".uploadedList").on("click",".mailbox-attachment-info a",function(e){
		var fileLink = $(this).attr("href");
		
		if(checkImageType(fileLink))
		{
			e.preventDefault();
			
			var imgTag = $("#popup_img");
			imgTag.attr("src",fileLink);
			console.log(imgTag.attr("src"));
			
			$(".popup").show('slow').css("display","block");
			imgTag.addClass("show");
		}
	});
	
	$("#popup_img").on("click",function(){
		$(".popup").hide('slow');
	});
	
	
	/*
		여기부터 댓글
	*/
	var commentPage = 1;
	function getPage(pageinfo)
	{
		$.getJSON(pageinfo,function(data){
			console.dir(data)
			printData(data.list,$('#commentDiv'), $('#template'));
			printPaging(data.page, $(".pagination"));
		})
	}
	
	var printPaging = function(page, target){
		var str="";
		if(page.startPage >= page.listSize )
		{
			str += "<li><a href='"+(page.startPage-1)+"'> << </a></li>";
		}
		for(var i=page.startPage, len = page.endPage; i<=len; i++)
		{
			var strClass=page.pageNo == i?'class=active':'';
			str += "<li "+ strClass+"><a href='"+i+"'>"+i+"</a></li>";
		}
		if(page.endPage != page.lastPage)
		{
			str += "<li><a href='"+(page.startPage-1)+"'> >> </a></li>";
		}
		target.html(str);
	}
	$("#commentDiv").on("click",function(){
		if($(".timeline li").size > 1)
			return;
		getPage("/comment/"+bno+"/1");
	})
	$(".pagination").on("click","li a",function(event){
		event.preventDefault();
// 		console.log(bno);
		commentPage = $(this).attr("href"); 
		console.log(commentPage);
		getPage("/comment/"+bno+"/"+commentPage);
	});
	$("#commentAddBtn").on("click",function(){
		var writerObj = $("#newWriter");
		var contentObj = $("#newContent");
		var writer = writerObj.val();
		var content = contentObj.val();
		
		$.ajax({
			type:'post',
			url:'/comment/',
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"POST"
			},
			dataType:'text',
			data:JSON.stringify({bno:bno, writer:writer, content:content}),
			success:function(result)
			{
				if(result=="SUCCESS")
				{
					alert("등록되었습니다.");
					commentPage = 1;
					getPage("/comment/"+bno+"/"+commentPage);
					writerObj.val("");
					contentObj.val("");
				}
			}
		});
	});
	
	$(".timeline").on("click",".commentLi",function(e){
		var comment = $(this);
		
		$("#commenttext").val(comment.find(".timeline-body").text());
		$(".modal-title").html(comment.attr("data-cno"));
	})
	$("#commentUpdateBtn").on("click",function(){
		var cno = $(".modal-title").html();
		var commenttext = $("#commenttext").val();
		
		$.ajax({
			type:'put',
			url:'/comment/'+cno,
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"PUT"
			},
			dataType:'text',
			data:JSON.stringify({content:commenttext}),
			success:function(result)
			{
				if(result=="SUCCESS")
				{
					alert("수정되었습니다.");
					getPage("/comment/"+bno+"/"+commentPage);
				}
			}
		});
	})
	$("#commentDeleteBtn").on("click",function(){
		var cno = $(".modal-title").html();
		var commenttext = $("#commenttext").val();
		$.ajax({
			type:'delete',
			url:'/comment/'+cno,
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"DELETE"
			},
			dataType:'text',
			success:function(result)
			{
				alert(result);
				if(result=="SUCCESS")
				{
					alert("삭제되었습니다.");
					getPage("/comment/"+bno+"/"+commentPage);
				}
			},
			fail:function(){
				alert("error");
			}
		});
	})
	
	
	</script>
	<script src="/resources/js/upload.js"></script>
</body>
</html>
<%@ include file="../include/footer.jsp"%>