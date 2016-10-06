package org.zerock.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.util.MediaUtils;
import org.zerock.util.UploadFileUtils;

@Controller
public class UploadController {
	
	@Resource(name="uploadPath")
	private String uploadPath;

	private static Logger logger = LoggerFactory.getLogger(UploadController.class);
	
//	@RequestMapping(value="/uploadAjax",method = RequestMethod.GET)
//	public void uploadAjax()
//	{
//		
//	}
	
	@RequestMapping(value="/uploadAjaxTest", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file,String email, String address) throws Exception
	{
		System.out.println(email+"    :::   "+address);
		ResponseEntity<String> entity = null;
		logger.info("-----File Upload  Test Controller 들어옴 ------");
		String filePath = UploadFileUtils.UploadFile(uploadPath, file.getOriginalFilename()+".jpg",
				file.getBytes());
		entity = new ResponseEntity<String>(filePath,HttpStatus.OK);
		System.out.println(filePath);
		return entity;
	}
		
	

	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception
	{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		logger.info("File Name : " + fileName);
		
		try{
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			
			MediaType mType = MediaUtils.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(uploadPath + fileName);
			
			if(mType != null)
			{
				headers.setContentType(mType);
			}
			else
			{
				fileName = fileName.substring(fileName.indexOf("_")+1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; filename=\""+
				new String(fileName.getBytes("UTF-8"),"ISO-8859-1")+"\"");
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),
					headers,
					HttpStatus.CREATED);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
	}
	
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName)
	{
		logger.info("delete File : " + fileName);
		
		String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
		
		MediaType mType = MediaUtils.getMediaType(formatName);
		
		if(mType!=null)
		{
			String front = fileName.substring(0,12); 
			String end = fileName.substring(14);
			new File(uploadPath + (front+end).replace('/', File.separatorChar)).delete();
		}
		new File(uploadPath + fileName.replace('/',File.separatorChar)).delete();
		System.out.println(11);
		ResponseEntity<String> entity = new ResponseEntity<String>("deleted",HttpStatus.OK);
		System.out.println(22);
		
		return entity;
	}
}
