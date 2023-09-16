package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.HashComponent;

@Controller
public class HomeController {
	@Autowired private HashComponent hashComponent;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/")
	public ModelAndView home(String source, String salt) {
		ModelAndView mav = new ModelAndView("home");
		
//		HashMap<String, String> map = hashComponent.getHash(source);
		// ex) 2(source-내가 처음 입력한 pw) + 1(salt-회원가입이나 패스워드 변경 시 부여받을 salt) = 3(hash)
		System.out.println("salt : [" + salt + "]");
		if("".equals(salt)) {
			salt = hashComponent.getRandomSalt();
		}
		String hash = hashComponent.getHash(source, salt);
		
		mav.addObject("hash", hash);
		mav.addObject("salt", salt);
		return mav;
				
	}
}

