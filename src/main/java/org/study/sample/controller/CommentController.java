package org.study.sample.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.study.sample.model.CommentDTO;
import org.study.sample.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/commentTest")
	public String commentInsert(@RequestParam("b_no")String b_no, CommentDTO dto, Model model) {
		
		commentService.commentInsert(dto); // ajax에서 받은 갑들을 dto로 받아서 db에 insert
		
		List<CommentDTO> list = commentService.commentList(b_no); // b_no에 해당하는 댓글 select 해오기
		
		model.addAttribute("list", list); // select해온 것을 model에 담아 comment.jsp로 전송
		
		return "board/comment";
	}
	
	@PostMapping("/commentList")
	public String commentList(@RequestParam("b_no")String b_no, Model model) {
		
		List<CommentDTO> list = commentService.commentList(b_no); // ajax에서 url get 방식으로 b_no 받아온걸로 select
		
		model.addAttribute("list", list); // select한거 model에 담아서 comment.jsp로 전송
		
		return "board/comment";
	}
	
	@PostMapping("/commentDelete")
	public String commentDelete(@RequestParam("b_no")String b_no, @RequestParam("c_no")String c_no, Model model) {
		
		commentService.commentDelete(c_no); // c_no로 댓글 삭제
		
		List<CommentDTO> list = commentService.commentList(b_no); // 삭제후 commentTBL 불러오기
		
		model.addAttribute("list", list); // model에 담아서 comment.jsp로 전송
		
		
		return "board/comment";
	}
	
	
	
	
	
}
