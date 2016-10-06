package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.persistence.LayerBoardMapper;
import org.zerock.vo.BoardVO2;
import org.zerock.vo.FileVO;
import org.zerock.vo.PageVO;

@Service
public class LayerBoardServiceImpl implements LayerBoardService
{

	@Inject
	LayerBoardMapper mapper;
	
	@Override
	public List<BoardVO2> listBoard(PageVO page) throws Exception {
		
		
		long bTime = System.currentTimeMillis();
		List<BoardVO2> list = mapper.selectBoard(page);
		long eTime = (System.currentTimeMillis()-bTime) / 1000;
		
		System.out.println(eTime +" 초");
		
		return list;
		
	}

	@Override
	public int getTotalCount() throws Exception {
		// TODO Auto-generated method stub
		return mapper.getTotalCount();
	}

	@Override
	public BoardVO2 detailBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectOneBoard(bno);
	}

	@Override
	public void registBoard(BoardVO2 board) throws Exception {
		if(board.getParent() != 0)
		{
			int gorder = mapper.maxGorder(board);
			if(gorder==0)
			{
				gorder = board.getGorder();
			}
			board.setGorder(gorder+1);
			mapper.updateGorder(board);
		}
		int bno = mapper.insertBoard(board);
		System.out.println(board.toString());
		String[] files = board.getFiles();
		for(String fullname : files )
		{
			FileVO file = new FileVO(bno, fullname);
			mapper.addFile(file);
		}
	}

	@Override
	public void updateBoard(BoardVO2 board) throws Exception {
		mapper.updateBoard(board);
		int bno = board.getBno();
		mapper.deleteFile(bno);
		
		String[] files = board.getFiles();
		
		if(files == null){return;}
		
		for(String fileName : files)
		{
			mapper.addFile(new FileVO(bno,fileName));
		}
		
	}

	@Override
	public int getSearchCount(PageVO page) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getSearchCount(page);
	}

	@Override
	public void deleteBoard(int bno) throws Exception {
		mapper.deleteBoard(bno);
		
	}

	@Override
	public List<String> getFile(int bno) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getFile(bno);
	}


}
