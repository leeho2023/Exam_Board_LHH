package org.study.sample.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.event.TransactionalEventListener;
import org.study.sample.mapper.MemberMapper;
import org.study.sample.model.MemberDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberMapperTest {

	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	
	@Test
	public void memberInsertTest() {
		log.info("memberInsertTest() 시작");
		MemberDTO dto = new MemberDTO();
		
		dto.setM_id("testID1");
		dto.setM_pw(pwEncoder.encode("testPW1"));
		dto.setM_address("testAddress1");
		log.info("dto 값 확인 : " + dto);
		
		mapper.memberInsert(dto);
		log.info("memberInsertTest() 끝");
	}
	
	//@Test
		public void memberInsertDummyTest() {
			
			for(int i = 1; i < 100; i++) {
				MemberDTO dto = new MemberDTO();
				dto.setM_id("testID" + i);
				dto.setM_pw("testPW" + i);
				dto.setM_address("testAddress" + i);
				log.info("dto 값 확인 : " + dto);
				mapper.memberInsert(dto);
			}
		
		}
	
	//@Test
	public void memberListTest() {
		
		List<MemberDTO> list = mapper.memberList();
		
		for(MemberDTO dto : list) {
			System.out.println(dto);
		}
		
	}
	
	//@Test
	public void memberDeleteTest() {
		mapper.memberDelete(2);
	}
	
	//@Test
	public void memberReadTest() {
		MemberDTO dto = mapper.memberRead(5);
		log.info(dto.toString());
	}
	
	//@Test
	public void memberUpdateTest() {
		MemberDTO dto = new MemberDTO();
		
		dto.setM_no(10);
		dto.setM_address("testAddress10");
		
		mapper.memberUpdate(dto);
		MemberDTO dto1 = mapper.memberRead(10);
		log.info(dto1.toString());
	}
	
	
}
