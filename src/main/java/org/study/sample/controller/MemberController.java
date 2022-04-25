package org.study.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.study.sample.model.MemberDTO;
import org.study.sample.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/memberInsert")
	public String memberInsert() {
		
		return "member/memberInsert";
	}
	
	@PostMapping("/memberInsert")
	public String memberInsertProcess(MemberDTO dto) {
		
		memberService.memberInsert(dto);
		
		return "redirect:/memberList";
	}
	
	@GetMapping("/memberList")
	public String memberList(Model model) {
		
		List<MemberDTO> list = memberService.memberList();
		
		model.addAttribute("list", list);
		
		return "member/memberList";
	}
	
	@GetMapping("/memberDelete")
	public String memberDelete(@RequestParam("m_no")String m_no) {
		
		System.out.println(m_no);
		memberService.memberDelete(m_no);
		
		return "redirect:/memberList";
	}
	
	@GetMapping("/memberRead")
	public String memberRead(@RequestParam("m_no")String m_no, Model model) {
		
		MemberDTO dto = memberService.memberRead(m_no);
		
		model.addAttribute("dto", dto);
		
		return "member/memberRead";
	}
	
	
}
