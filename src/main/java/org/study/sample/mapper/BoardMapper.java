package org.study.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.study.sample.model.BoardDTO;

@Mapper
public interface BoardMapper {

	public void boardDelete(String b_no);
	
	
	public void boardInsert(BoardDTO dto);
	public List<BoardDTO> boardList();
	public BoardDTO boardRead(String b_no);
	public void boardUpdate(BoardDTO dto);
	
}
