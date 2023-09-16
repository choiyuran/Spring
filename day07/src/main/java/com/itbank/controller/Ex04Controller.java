package com.itbank.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
public class Ex04Controller {
	@Autowired private HashComponent hashComponent;
	@Autowired private MemberDAO memberDAO;

	@GetMapping("/ex04")
	public String ex04(HttpSession session) {
		if(session.getAttribute("login") == null) {
			return "redirect:/ex02";
		}
		return "/ex04";
	}
	
	@PostMapping("/ex04")
	public ModelAndView ex04(@RequestParam HashMap<String, String> map, HttpSession session) {
		ModelAndView mav = new ModelAndView("/ex03-action");
		String currentPW = map.get("currentPW");
		String newPW = map.get("newPW");
		
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		String oldHash = hashComponent.getHash(currentPW, login.getSalt());
		String newSalt = hashComponent.getRandomSalt();
		String newHash = hashComponent.getHash(newPW, newSalt);
		
		map.put("oldHash", oldHash);
		map.put("newHash", newHash);
		map.put("newSalt", newSalt);
		map.put("userid", login.getUserid());
		
		int row = memberDAO.updatePw(map);
		System.out.println(row + "행이 수정되었습니다");
		if(row != 0) {
			mav.addObject("msg", "비밀번호가 변경되었습니다");
			session.invalidate();
		}
		
		return mav;
	}
}
