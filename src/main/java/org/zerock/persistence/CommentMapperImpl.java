package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.zerock.vo.CommentVO;
import org.zerock.vo.PageVO;

@Repository
public class CommentMapperImpl implements CommentMapper {

	@Inject
	private SqlSessionTemplate session;
	
	private static final String NAMESPACE = "org.zerock.persistence.CommentMapper";
	
	@Override
	public List<CommentVO> list(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(NAMESPACE+".list", bno);
	}

	@Override
	public void regist(CommentVO comment) throws Exception {
		session.insert(NAMESPACE+".regist",comment);

	}

	@Override
	public void update(CommentVO comment) throws Exception {
		session.update(NAMESPACE+".update",comment);
	}

	@Override
	public void delete(int cno) throws Exception {
		session.delete(NAMESPACE+".delete",cno);
	}

	@Override
	public List<CommentVO> listPage(int bno, PageVO page) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("bno", bno);
		paramMap.put("page", page);
		return session.selectList(NAMESPACE+".listPage",paramMap);
	}

	@Override
	public int count(int bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(NAMESPACE+".count",bno);
	}

}
