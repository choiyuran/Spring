package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.CampingDTO;
import com.itbank.service.CampingService;

@Controller
public class HomeController {
	@Autowired private CampingService campingService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		List<CampingDTO> list = campingService.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/test")
	public void test() {}
	
}
