	function checkImageType(fileName)
	{
		var pattern = /jpg|gif|png|jpeg/i;
		
		return fileName.match(pattern);
	}
	
	function getFileInfo(fullname)
	{
		var fileName,imgsrc,getLink;
		
		var fileLink;
		
		if(checkImageType(fullname))
		{
			imgsrc = "/displayFile?fileName="+fullname;
			fileLink = fullname.substr(14);
			
			var front=fullname.substr(0,12); // 디렉토리
			var end = fullname.substr(14);
			getLink = "/displayFile?fileName="+front+end;
		}
		else
		{
			imgsrc = "/resources/dist/img/file.png";
			fileLink = fullname.substr(12);
			getLink = "/displayFile?fileName="+fullName;
			
		}
		fileName = fileLink.substr(fileLink.indexOf("_")+1);
		
		return {fileName:fileName, imgsrc:imgsrc, getLink:getLink,fullName:fullname};
	}
	