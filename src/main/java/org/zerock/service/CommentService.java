package org.zerock.service;

import java.util.List;

import org.zerock.vo.CommentVO;
import org.zerock.vo.PageVO;

public interface CommentService {
	public void registComment(CommentVO comment)throws Exception;
	public void updateComment(CommentVO comment)throws Exception;
	public List<CommentVO> listComment(int bno) throws Exception;
	public void deleteComment(int cno) throws Exception;
	public List<CommentVO> ListCommentPage(int bno, PageVO page) throws Exception;
	public int count (int bno) throws Exception;

}
