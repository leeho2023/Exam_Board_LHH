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
		System.out.println("=== MemberInsert 실행 ===");
		System.out.println("===     입력값 확인     ===");
		System.out.println("입력된 ID = " + dto.getM_id());
		System.out.println("입력된 PW = " + dto.getM_pw());
		System.out.println("입력된 주소 = " + dto.getM_address());
		memberService.memberInsert(dto);
		System.out.println("===     PW 암호화      ===");
		System.out.println("PW = " + dto.getM_pw());
		System.out.println("=== MemberInsert 완료 ===");
		
		return "redirect:/";
	}
	
	@GetMapping("/memberList")
	public String memberList(Model model) {
		System.out.println("=== MemberList 실행 ===");
		List<MemberDTO> list = memberService.memberList();
		for(MemberDTO dto : list) {
			System.out.println(dto.toString());
		}
		System.out.println("=== MemberList 완료 ===");
		model.addAttribute("list", list);
		return "member/memberList";
	}
	
	@GetMapping("/memberDelete")
	public String memberDelete(@RequestParam("m_no")int m_no) {
		System.out.println("=== MemberDelete 실행 ===");
		System.out.println("삭제할 회원번호 = "+m_no);
		memberService.memberDelete(m_no);
		System.out.println("=== MemberDelete 완료 ===");
		return "redirect:/memberList";
	}
	
	@GetMapping("/memberRead")
	public String memberRead(@RequestParam("m_no")int m_no, Model model) {
		
		System.out.println("=== MemberRead 실행 ===");
		MemberDTO dto = memberService.memberRead(m_no);
		System.out.println(dto.toString());
		System.out.println("=== MemberRead 완료 ===");
		model.addAttribute("dto", dto);
		
		return "member/memberRead";
	}
	
	@GetMapping("/memberUpdate")
	public String memberUpdate(@RequestParam("m_no")int m_no, Model model) {
		
		MemberDTO dto = memberService.memberRead(m_no);
		System.out.println("=== 수정 전 회원 정보 ===");
		System.out.println("ID = "+dto.getM_id());
		System.out.println("주소 = "+dto.getM_address());
		model.addAttribute("dto", dto);
		
		
		return "member/memberUpdate";
	}
	
	@PostMapping("/memberUpdate")
	public String memberUpdateProcess(MemberDTO dto) {
		System.out.println("=== MemberUpdate 실행 ===");
		System.out.println("수정된 ID = "+dto.getM_id());
		System.out.println("수정된 주소 = "+dto.getM_address());
		memberService.memberUpdate(dto);
		System.out.println("=== MemberUpdate 완료 ===");
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
