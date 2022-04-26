package org.study.sample.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
		
		return "redirect:/";
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
	
	@GetMapping("/memberUpdate")
	public String memberUpdate(@RequestParam("m_no")String m_no, Model model) {
		
		MemberDTO dto = memberService.memberRead(m_no);
		
		model.addAttribute("dto", dto);
		
		
		return "member/memberUpdate";
	}
	
	@PostMapping("/memberUpdate")
	public String memberUpdateProcess(MemberDTO dto) {
		
		System.out.println(dto.toString());
		
		memberService.memberUpdate(dto);
		
		return "redirect:/memberRead?m_no=" + dto.getM_no();
	}
	
	@PostMapping("/login")
	public String login(MemberDTO dto, HttpServletRequest request, RedirectAttributes rttr) {
		
		String result = memberService.login(dto);
		
		System.out.println(result);
		
		if(result.equals("Success")) {
			HttpSession session = request.getSession();
			session.setAttribute("m_id", dto.getM_id());
			return "redirect:/";
		}else {
			rttr.addFlashAttribute("msg", false);
			return "redirect:/";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return "redirect:/";
	}
	
}
