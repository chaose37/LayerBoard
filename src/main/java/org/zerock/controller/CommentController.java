package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.service.CommentService;
import org.zerock.vo.CommentVO;
import org.zerock.vo.PageVO;

@RestController
@RequestMapping("/comment")
public class CommentController {
	
	private static Logger logger = LoggerFactory.getLogger(CommentController.class);
	@Inject
	private CommentService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody CommentVO comment)
	{
		
		logger.info("-------------------------------------"); 
		logger.info("register.............................");
		logger.info(comment.toString());
		logger.info("-------------------------------------");
		
		ResponseEntity<String> entity = null;
		try{
			service.registComment(comment);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}                                                    
		return entity;
	}
	
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<CommentVO>> list(@PathVariable("bno") Integer bno)
	{
		ResponseEntity<List<CommentVO>> entity = null;
		try{
			entity = new ResponseEntity<List<CommentVO>>(service.listComment(bno),HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
			entity = new ResponseEntity<List<CommentVO>>(HttpStatus.BAD_REQUEST);
		} 
		return entity;
	}
	
	
//	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
//	public List<CommentVO> list(@PathVariable("bno") Integer bno) throws Exception
//	{
//		List<CommentVO> entity = (List<CommentVO>) service.listComment(bno);
//		System.out.println("11111111");
//		return entity;
//	}
	
	
	@RequestMapping(value="/{cno}", method=RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("cno") Integer cno,@RequestBody CommentVO comment)
	{
		ResponseEntity<String> entity = null;
		try{
			comment.setCno(cno);
			service.updateComment(comment);
			
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}                                                                                                                                                                              
		return entity;
	}
	@RequestMapping(value="/{cno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("cno") Integer cno)
	{
		ResponseEntity<String> entity = null;
		try{
			service.deleteComment(cno);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		}catch(Exception e)
		{
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}                                                                                                                                                                              
		return entity;
	}
	@RequestMapping(value="/{bno}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> listPage(@PathVariable("bno") Integer bno,@PathVariable("page")Integer pageNo)
	{
		ResponseEntity<Map<String,Object>> entity = null;
		try{
			PageVO page = new PageVO();
			page.setPageNo(pageNo);
			Map<String,Object> map = new HashMap<String,Object>();
			List<CommentVO> list = service.ListCommentPage(bno, page);
			System.out.println("======================");
			System.out.println(page);
			System.out.println("======================");
			map.put("list", list);
			
			page.setCount(service.count(bno));
			map.put("page", page);
			
			entity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	
}
