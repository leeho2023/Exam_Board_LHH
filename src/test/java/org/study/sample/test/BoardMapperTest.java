package org.study.sample.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.study.sample.mapper.BoardMapper;
import org.study.sample.model.BoardDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {

	@Autowired
	private BoardMapper mapper;
	
	//@Test
	public void boardInsert() {
		BoardDTO dto = new BoardDTO();
		
		dto.setB_title("testTitle");
		dto.setB_writer("aaa");
		dto.setB_content("테스트내용");
		
		mapper.boardInsert(dto);
	}
	
	//@Test
	public void boardListTest() {
		List<BoardDTO> list = mapper.boardList();
		
		for(BoardDTO dto : list) {
			log.info(dto);
		}
	}
	
	//@Test
	public void boardReadTest() {
		BoardDTO dto = mapper.boardRead("1");
		
		log.info(dto);
		
	}
	
	//@Test
	public void boardUpdateTest() {
		BoardDTO dto = new BoardDTO();
		dto.setB_no(1);
		dto.setB_title("수정된 제목");
		dto.setB_writer("sutak");
		dto.setB_content("수정된 내용");
		
		System.out.println(dto);
		
		mapper.boardUpdate(dto);
		
		BoardDTO dto1 = mapper.boardRead("1");
		
		log.info(dto1);
		
	}
	
	@Test
	public void boardDeleteTest() {
		
		mapper.boardDelete("4");
		
	}
	
	
}
