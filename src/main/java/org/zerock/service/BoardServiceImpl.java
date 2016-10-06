package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.persistence.BoardMapper;
import org.zerock.vo.BoardVO;
import org.zerock.vo.PageVO;

@Service
public class BoardServiceImpl implements BoardService
{

	@Inject
	BoardMapper mapper;
	
	@Override
	public List<BoardVO> listBoard(PageVO page) throws Exception {
		
		return mapper.selectBoard(page);
		
	}

	@Override
	public int getTotalCount() throws Exception {
		// TODO Auto-generated method stub
		return mapper.getTotalCount();
	}

	@Override
	public BoardVO detailBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectOneBoard(bno);
	}

	@Override
	public void registBoard(BoardVO board) throws Exception {
		mapper.insertBoard(board);
	}

	@Override
	public void updateBoard(BoardVO board) throws Exception {
		mapper.updateBoard(board);
		
	}

	@Override
	public int getSearchCount(PageVO page) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getSearchCount(page);
	}


}
