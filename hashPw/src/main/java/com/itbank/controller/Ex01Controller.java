package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
@RequestMapping("/ex01")
public class Ex01Controller {
	@Autowired private HashComponent hashComponent;
	@Autowired private MemberDAO memberDAO;

	@GetMapping
	public void ex01() {}
	
	@PostMapping
	public ModelAndView ex01(MemberDTO dto) {
		ModelAndView mav = new ModelAndView();
		String salt = hashComponent.getRandomSalt();
		String hash = hashComponent.getHash(dto.getUserpw(), salt);
		
		dto.setSalt(salt);
		dto.setUserpw(hash);
		
		int row = memberDAO.insert(dto);
		System.out.println(row + "행이 추가되었습니다");
		return mav;
	
	}
}
