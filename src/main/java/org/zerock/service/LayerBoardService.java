package org.zerock.service;

import java.util.List;

import org.zerock.vo.BoardVO2;
import org.zerock.vo.PageVO;

public interface LayerBoardService {

	public List<BoardVO2> listBoard(PageVO page) throws Exception;
	public int getTotalCount() throws Exception;
	public BoardVO2 detailBoard(int bno) throws Exception;
	public void registBoard(BoardVO2 board) throws Exception;
	public void updateBoard(BoardVO2 board) throws Exception;
	public int getSearchCount(PageVO page) throws Exception;
	public void deleteBoard(int bno) throws Exception;
	public List<String> getFile(int bno) throws Exception;
}
