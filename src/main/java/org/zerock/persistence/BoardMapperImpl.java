package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.zerock.vo.BoardVO;
import org.zerock.vo.PageVO;

@Repository
public class BoardMapperImpl implements BoardMapper{
	
	@Inject
	SqlSessionTemplate session;
	
	private static final String NAMESPACE="org.zerock.persistence.BoardMapper";

	public List<BoardVO> selectBoard(PageVO page) throws Exception {
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
	public BoardVO selectOneBoard(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+".selectOneBoard",bno);
	}

	@Override
	public void insertBoard(BoardVO board) throws Exception {
		session.insert(NAMESPACE+".insertBoard",board);
	}

	@Override
	public void updateBoard(BoardVO board) throws Exception {
		session.update(NAMESPACE+".updateBoard",board);
	}

}
