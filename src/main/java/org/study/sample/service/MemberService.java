package org.study.sample.service;

import java.util.List;

import org.study.sample.model.MemberDTO;

public interface MemberService {

	void memberInsert(MemberDTO dto);

	List<MemberDTO> memberList();
	
	void memberDelete(String m_no);

	MemberDTO memberRead(String m_no);

	void memberUpdate(MemberDTO dto);
	
	String login(MemberDTO dto);
	
}
