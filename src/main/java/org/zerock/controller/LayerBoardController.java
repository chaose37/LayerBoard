package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.service.LayerBoardService;
import org.zerock.vo.BoardVO2;
import org.zerock.vo.PageVO;

@Controller
@RequestMapping("/board2")
public class LayerBoardController {
	
	@Inject
	private LayerBoardService service;

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listBoard(@ModelAttribute("page")PageVO page, Model model ) throws Exception
	{
		page.setCount(service.getSearchCount(page));
		model.addAttribute("list",service.listBoard(page));
	}
	@RequestMapping("/registForm")
	public void registFormBoard() throws Exception
	{
		
	}
	@RequestMapping("/replyForm")
	public void replyFormBoard(BoardVO2 board,Model model) throws Exception
	{
		model.addAttribute("board",board);
	}
	@RequestMapping("/reply")
	public String replyBoard(BoardVO2 board,RedirectAttributes redattr) throws Exception
	{
		System.out.println(board.getParent());
		service.registBoard(board);
		redattr.addFlashAttribute("msg","success");
		return "redirect:/board2/list";
	}
	@ResponseBody
	@RequestMapping("/registTEST")
	public BoardVO2 registBoard2(BoardVO2 board,RedirectAttributes redattr) throws Exception
	{	
		System.out.println(board);
		return board;
	}

	@RequestMapping("/regist")
	public String registBoard(BoardVO2 board, RedirectAttributes redattr) throws Exception {
		service.registBoard(board);
		redattr.addFlashAttribute("msg", "success");
		return "redirect:/board2/list";
	}
	@RequestMapping("/update")
	public String updateBoard(BoardVO2 board,RedirectAttributes redattr) throws Exception
	{
		service.updateBoard(board);
		redattr.addFlashAttribute("msg","success");
		return "redirect:/board/detail?bno="+board.getBno();
	}
	@RequestMapping("/detail")
	
	public void detailBoard(@ModelAttribute("page") PageVO page,Model model,int bno) throws Exception
	{
		System.out.println(page.toString());
		model.addAttribute("board",service.detailBoard(bno));
	}
	@RequestMapping("/updateForm")
	public void updateForm(Model model,int bno) throws Exception
	{
		model.addAttribute("board",service.detailBoard(bno));
	}
	@RequestMapping("/delete")
	public String deleteBoard(int bno,RedirectAttributes redattr) throws Exception
	{
		service.deleteBoard(bno);
		redattr.addFlashAttribute("msg","delete");

		return "redirect:list";
	}
	@RequestMapping("/getFile/{bno}")
	@ResponseBody
	public List<String> getFile(@PathVariable("bno") Integer bno) throws Exception
	{
		return service.getFile(bno);
	}
}
