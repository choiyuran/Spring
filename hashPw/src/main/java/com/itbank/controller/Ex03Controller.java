package com.itbank.controller;


import java.util.UUID;

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
@RequestMapping("/ex03")
public class Ex03Controller {
	@Autowired HashComponent hashComponent;
	@Autowired MemberDAO memberDAO;

	@GetMapping
	public void ex03() {}
	
	@PostMapping
	public ModelAndView ex03(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("ex03-action");
		
		MemberDTO login = memberDAO.selectOneByIdEmail(dto);
		if(login == null) {
			mav.setViewName("redirect:/ex03");
		}
		else {
			String pass = UUID.randomUUID().toString().substring(0, 8);
			String salt = hashComponent.getRandomSalt();
			String hash = hashComponent.getHash(pass, salt);
			dto.setSalt(salt);
			dto.setUserpw(hash);
			int row = memberDAO.updatePw(dto);
			if(row != 0) {
				mav.addObject("msg", String.format("새로 발급된 비밀번호는 [%s] 입니다", pass));				
			}
		}		
		return mav;
	}
}
