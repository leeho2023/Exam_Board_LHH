package org.study.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.study.sample.model.ReplyDTO;
import org.study.sample.service.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/replyInsert")
	@ResponseBody
	public String replyInsert(ReplyDTO dto) {
		
		replyService.replyInsert(dto);
		
		return "Sussecc";
	}
	
	@PostMapping("/replyShow")
	@ResponseBody
	public List<ReplyDTO> replyShow(@RequestParam("r_boardNum")String r_boardNum) {
		
		List<ReplyDTO> list = replyService.replyShow(r_boardNum);
		
		return list;
	}
	
	@PostMapping("/replyDelete")
	@ResponseBody
	public String replyDelete(@RequestParam("r_no")String r_no) {
		
		replyService.replyDelete(r_no);
		
		return "Success";
	}
	
}
