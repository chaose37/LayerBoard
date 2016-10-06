package org.zerock.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.service.BoardService;
import org.zerock.vo.BoardVO;
import org.zerock.vo.PageVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Inject
	private BoardService service;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listBoard(PageVO page, Model model ) throws Exception
	{
		page.setCount(service.getSearchCount(page));
		model.addAttribute("page",page);
		model.addAttribute("list",service.listBoard(page));
	}
	@RequestMapping("/registForm")
	public void registFormBoard() throws Exception
	{
		
	}
	@RequestMapping("/regist")
	public String registBoard(BoardVO board,RedirectAttributes redattr) throws Exception
	{
		service.registBoard(board);
		redattr.addFlashAttribute("msg","success");
		return "redirect:/board/list";
	}
	@RequestMapping("/update")
	public String updateBoard(BoardVO board,RedirectAttributes redattr) throws Exception
	{
		service.updateBoard(board);
		redattr.addFlashAttribute("msg","success");
		return "redirect:/board/detail?bno="+board.getBno();
	}
	@RequestMapping("/detail")
	
	public void detailBoard(Model model,int bno) throws Exception
	{
		model.addAttribute("board",service.detailBoard(bno));
	}
	@RequestMapping("/updateForm")
	public void updateForm(Model model,int bno) throws Exception
	{
		model.addAttribute("board",service.detailBoard(bno));
	}
	@RequestMapping("/delete")
	public void deleteBoard(int bno)
	{
		
	}
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public void test() {
		
	}
	
	@RequestMapping(value="/test", method = RequestMethod.POST)
	public void test(MultipartHttpServletRequest req) {
		System.out.println(req.getParameter("title"));
		System.out.println(req.getParameter("title"));
		System.out.println(req.getParameter("title"));
		System.out.println(req.getParameter("title"));
	}
}
