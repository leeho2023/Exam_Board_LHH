package org.study.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.study.sample.model.ReplyDTO;

@Mapper
public interface ReplyMapper {

	void replyInsert(ReplyDTO dto);

	List<ReplyDTO> replyShow(String r_boardNum);

	void replyDelete(String r_no);
	
	
	
}
