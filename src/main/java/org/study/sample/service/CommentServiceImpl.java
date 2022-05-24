package org.study.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.sample.mapper.CommentMapper;
import org.study.sample.model.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper mapper;
	
	@Override
	public void commentInsert(CommentDTO dto) {
		mapper.commentInsert(dto);
	}

	@Override
	public List<CommentDTO> commentList(String b_no) {
		return mapper.commentList(b_no);
	}

	@Override
	public void commentDelete(String c_no) {
		mapper.commentDelete(c_no);
	}

}
