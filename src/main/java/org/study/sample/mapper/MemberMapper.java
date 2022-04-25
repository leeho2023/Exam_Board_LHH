package org.study.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.study.sample.model.MemberDTO;

@Mapper
public interface MemberMapper {

	public void memberInsert(MemberDTO dto);
	public List<MemberDTO> memberList();
	public void memberDelete(String m_no);
	public MemberDTO memberRead(String m_no);
	
}
