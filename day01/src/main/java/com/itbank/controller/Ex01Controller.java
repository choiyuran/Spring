package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ex01Controller {
	// GetMapping은 @ReqeustMapping(value="", method=RequestMethod.GET)과 같다
	@GetMapping("/ex01")
	public void test() {
		// 컨트롤러 함수의 반환형이 void이면 요청 주소가 viewName으로 활용된다
		// 컨트롤러에서 수행할 코드가 없고, 곧바로 jsp를 띄우면 될 경우에 주로 활용한다
		// WEB-INF/views/ex01.jsp	
	}
	
	// @RequestParam
	// request.getParameter의 기능과 동일
	// 생략해도 가능 하지만, HashMap<String, Object>를 사용할때는 붙여줘야함
	@PostMapping("/ex01")
	public String test2(
			/*@RequestParam("name")*/ String name, 
			/*@RequestParam("age")*/ int age, 
			Model model) {
		
		String adult = age >= 20 ? "성인" : "미성년자";
		model.addAttribute("adult", adult);
		return "ex01-action";
	}
		
}
