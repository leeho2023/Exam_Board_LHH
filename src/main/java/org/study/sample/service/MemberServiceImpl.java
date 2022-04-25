package org.study.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.sample.mapper.MemberMapper;
import org.study.sample.model.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public void memberInsert(MemberDTO dto) {
		
		mapper.memberInsert(dto);
		
	}

	@Override
	public List<MemberDTO> memberList() {

		return mapper.memberList();
	}

	@Override
	public void memberDelete(String m_no) {
		mapper.memberDelete(m_no);
	}

	@Override
	public MemberDTO memberRead(String m_no) {
		return mapper.memberRead(m_no);
	}

}
