package org.study.sample.service;

import java.util.List;

import org.study.sample.model.ReplyDTO;

public interface ReplyService {
	
	void replyInsert(ReplyDTO dto);

	List<ReplyDTO> replyShow(String r_boardNum);

	void replyDelete(String r_no);
	
}
