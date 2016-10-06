package org.zerock.service;

import java.util.List;

import org.zerock.vo.BoardVO;
import org.zerock.vo.PageVO;

public interface BoardService {

	public List<BoardVO> listBoard(PageVO page) throws Exception;
	public int getTotalCount() throws Exception;
	public BoardVO detailBoard(int bno) throws Exception;
	public void registBoard(BoardVO board) throws Exception;
	public void updateBoard(BoardVO board) throws Exception;
	public int getSearchCount(PageVO page) throws Exception;
}
