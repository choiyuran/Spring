package com.itbank.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {
	@Autowired HashComponent hashComponent;
	@Autowired MemberDAO memberDAO;

	@GetMapping
	public String ex04(HttpSession session) {
		if(session.getAttribute("login") == null) {
			return "redirect:/ex02";
		}
		return "ex04";
	}
	
	@PostMapping
	public ModelAndView ex04(@RequestParam Map<String, String> map, HttpSession session) {
		ModelAndView mav = new ModelAndView("ex03-action");
		String currentPw = map.get("currentPw");
		String newPw = map.get("newPw");
		
		MemberDTO login = (MemberDTO)session.getAttribute("login");
		// 변경할 salt, password
		String newSalt = hashComponent.getRandomSalt();
		String newHash = hashComponent.getHash(newPw, newSalt);
		
		// 현재 비밀번호 확인할 입력 받은 pw
		String hashCurrent = hashComponent.getHash(currentPw, login.getSalt()); 
				
		map.put("newSalt", newSalt);
		map.put("newHash", newHash);
		map.put("hashCurrent", hashCurrent);
		map.put("userid", login.getUserid());
		int row = memberDAO.update(map);
		if(row != 0) {
			mav.addObject("msg", "비밀번호가 변경되었습니다");
			session.invalidate();
		}
		return mav;
	}
	
}
