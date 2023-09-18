package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
@RequestMapping("/ex02")
public class Ex02Controller {
	@Autowired HashComponent hashComponent;
	@Autowired MemberDAO memberDAO;
	
	@GetMapping
	public void ex02() {}
	
	
	@PostMapping()
	public String ex02(MemberDTO dto, HttpSession session) {
		MemberDTO login = memberDAO.selectOne(dto.getUserid());
		if(login == null) {
			return "redirect:/ex02";
		}
		String hash = hashComponent.getHash(dto.getUserpw(), login.getSalt());
		if(hash.equals(login.getUserpw()) == false) {
			session.invalidate();
			return "redirect:/ex02";
		}
		session.setAttribute("login", login);
		return "redirect:/";
	}
}
