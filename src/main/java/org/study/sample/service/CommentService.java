package org.study.sample.service;


import java.util.List;

import org.study.sample.model.CommentDTO;


public interface CommentService {

	void commentInsert(CommentDTO dto);
	List<CommentDTO> commentList(String b_no);
	void commentDelete(String c_no);

}
