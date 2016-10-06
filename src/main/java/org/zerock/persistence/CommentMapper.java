package org.zerock.persistence;

import java.util.List;

import org.zerock.vo.CommentVO;
import org.zerock.vo.PageVO;

public interface CommentMapper {
	public List<CommentVO> list(int bno) throws Exception;
	public void regist(CommentVO comment) throws Exception;
	public void update(CommentVO comment) throws Exception;
	public void delete(int cno) throws Exception;
	public List<CommentVO> listPage(int bno, PageVO page) throws Exception;
	public int count(int bno) throws Exception;
}
