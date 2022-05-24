package org.study.sample.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.study.sample.mapper.CommentMapper;
import org.study.sample.model.CommentDTO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class CommentMapperTest {

	@Autowired
	private CommentMapper mapper;
	
	//@Test
	public void commentInsertTest() {
		CommentDTO dto = new CommentDTO();
		dto.setB_no(1);
		dto.setC_writer("sutak");
		dto.setC_content("나는 sutak이다");
		mapper.commentInsert(dto);
	}
	
	//@Test
	public void commentListTest() {
		List<CommentDTO> list = mapper.commentList("1");
		
		for(CommentDTO dto : list) {
			log.info(dto.toString());
		}
		
		
	}
	
	@Test
	public void commentDelete() {
		
		CommentDTO dto = new CommentDTO();
		dto.setC_no(17);
		
		mapper.commentDelete(Integer.toString(dto.getC_no()));
		
		
	}
	
	
	
	
}
