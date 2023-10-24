package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.CampingDTO;
import com.itbank.service.CampingService;

@Controller
public class CampingController {
	@Autowired private CampingService campingService;
	
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<CampingDTO> list = campingService.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/view/{facltnm}")
	public ModelAndView view(@PathVariable("facltnm") String facltnm) {
		ModelAndView mav = new ModelAndView("view");
		CampingDTO dto = campingService.selectOne(facltnm);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/camping_around/{mapX}/{mapY}")
	public ModelAndView camping_around(@PathVariable("mapX") String mapX, @PathVariable("mapY")String mapY) {
		ModelAndView mav = new ModelAndView("camping_around");
		System.out.println(mapX);
		System.out.println(mapY);
		mav.addObject("mapX", mapX);
		mav.addObject("mapY", mapY);
		return mav;
	}
	
	

	
	

}
