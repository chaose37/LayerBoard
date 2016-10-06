package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.persistence.CommentMapper;
import org.zerock.vo.CommentVO;
import org.zerock.vo.PageVO;

@Service
public class CommentServiceImpl implements CommentService {

	@Inject
	private CommentMapper mapper;
	
	@Override
	public void registComment(CommentVO comment) throws Exception {
		mapper.regist(comment);

	}

	@Override
	public void updateComment(CommentVO comment) throws Exception {
		// TODO Auto-generated method stub
		mapper.update(comment);
	}

	@Override
	public List<CommentVO> listComment(int bno) throws Exception {
		// TODO Auto-generated method stub
		return mapper.list(bno);
	}

	@Override
	public void deleteComment(int cno) throws Exception {
		mapper.delete(cno);
	}

	@Override
	public List<CommentVO> ListCommentPage(int bno, PageVO page) throws Exception {
		return mapper.listPage(bno, page);
		
	}

	@Override
	public int count(int bno) throws Exception {
		// TODO Auto-generated method stub
		return mapper.count(bno);
	}

}
