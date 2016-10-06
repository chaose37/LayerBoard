package org.zerock.persistence;

import java.util.List;

import org.zerock.vo.BoardVO;
import org.zerock.vo.PageVO;

public interface BoardMapper {
	public List<BoardVO> selectBoard(PageVO page) throws Exception;
	public int getTotalCount() throws Exception;
	public int getSearchCount(PageVO page) throws Exception;
	public BoardVO selectOneBoard(int bno) throws Exception;
	public void insertBoard(BoardVO board) throws Exception;
	public void updateBoard(BoardVO board) throws Exception;
	

}
