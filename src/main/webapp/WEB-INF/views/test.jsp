<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
</head>
<body>
<h1>hi</h1>
<ul id="comment">
</ul>

<script type="text/javascript">
	var bno = 1234;
	$.ajax({
		url: "/controller/comment/all/1234"
	}).done(function(data) {
		console.log("111111");
		console.dir(data);
	})
	
	
// 	$.getJSON("/controller/comment/all/"+bno,function(data){
// 		console.log("1111");
// 		console.log(data.length);
// 	});

</script>
</body>
</html>