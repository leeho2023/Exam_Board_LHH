package org.study.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.sample.mapper.ReplyMapper;
import org.study.sample.model.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper mapper;
	
	@Override
	public void replyInsert(ReplyDTO dto) {
		
		mapper.replyInsert(dto);
	}

	@Override
	public List<ReplyDTO> replyShow(String r_boardNum) {
		
		return mapper.replyShow(r_boardNum);
	}

	@Override
	public void replyDelete(String r_no) {
		mapper.replyDelete(r_no);
	}

	

}
