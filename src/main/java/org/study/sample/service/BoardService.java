package org.study.sample.service;

import java.util.List;

import org.study.sample.model.BoardDTO;

public interface BoardService {
	
	void boardDelete(String b_no);

	void boardInsert(BoardDTO dto);
	
	List<BoardDTO> boardList();
	
	BoardDTO boardRead(String b_no);
	
	void boardUpdate(BoardDTO dto);
}
