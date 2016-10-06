package org.zerock.persistence;

import java.util.List;

import org.zerock.vo.BoardVO2;
import org.zerock.vo.FileVO;
import org.zerock.vo.PageVO;

public interface LayerBoardMapper {
	public List<BoardVO2> selectBoard(PageVO page) throws Exception;
	public int getTotalCount() throws Exception;
	public int getSearchCount(PageVO page) throws Exception;
	public BoardVO2 selectOneBoard(int bno) throws Exception;
	public int insertBoard(BoardVO2 board) throws Exception;
	public void updateBoard(BoardVO2 board) throws Exception;
	public int maxGorder(BoardVO2 board) throws Exception;
	public void updateGorder(BoardVO2 board) throws Exception;
	public void deleteBoard(int bno) throws Exception;
	public void addFile(FileVO file)throws Exception;
	public List<String> getFile(int bno) throws Exception;
	public void deleteFile(int bno) throws Exception;
	
	

}
