package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired private MemberService memberService;
	
	@GetMapping("/join")
	public void join() {}
	
	@PostMapping("/join")
	public String join(MemberDTO dto) {
		int row = memberService.join(dto);
		System.out.println(row + "행이 삽입되었습니다");
		return "redirect:/";
	}
}
