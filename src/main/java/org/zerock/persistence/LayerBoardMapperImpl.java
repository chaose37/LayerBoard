package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.zerock.vo.BoardVO2;
import org.zerock.vo.FileVO;
import org.zerock.vo.PageVO;

@Repository
public class LayerBoardMapperImpl implements LayerBoardMapper{
	
	@Inject
	SqlSessionTemplate session;
	
	private static final String NAMESPACE="org.zerock.persistence.LayerBoardMapper";

	public List<BoardVO2> selectBoard(PageVO page) throws Exception {
		return session.selectList(NAMESPACE+".selectBoard",page);
	}

	@Override
	public int getTotalCount() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+".getTotalCount");
	}
	public int getSearchCount(PageVO page) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+".getSearchCount",page);
	}

	@Override
	public BoardVO2 selectOneBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+".selectOneBoard",bno);
	}

	@Override
	public int insertBoard(BoardVO2 board) throws Exception {
		session.insert(NAMESPACE+".insertBoard",board);
		return board.getBno();
	}

	@Override
	public void updateBoard(BoardVO2 board) throws Exception {
		session.update(NAMESPACE+".updateBoard",board);
	}

	@Override
	public int maxGorder(BoardVO2 board) throws Exception {
		return session.selectOne(NAMESPACE+".maxGorder",board);
	}

	@Override
	public void updateGorder(BoardVO2 board) throws Exception {
		session.update(NAMESPACE+".updateGorder",board);
		
	}

	@Override
	public void deleteBoard(int bno) throws Exception {
		session.update(NAMESPACE+".deleteBoard",bno);
		
	}

	@Override
	public void addFile(FileVO file) throws Exception {
		session.insert(NAMESPACE+".addFile",file);
		
	}

	@Override
	public List<String> getFile(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".getFile",bno);
	}

	@Override
	public void deleteFile(int bno) throws Exception {
		session.delete(NAMESPACE+".deleteFile",bno);
		
	}



}
