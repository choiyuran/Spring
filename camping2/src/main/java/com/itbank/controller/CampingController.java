package com.itbank.controller;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.CampingDTO;
import com.itbank.model.Paging;
import com.itbank.service.CampingService;

@Controller
public class CampingController {
	@Autowired private CampingService campingService;
	
	// 리스트
	@GetMapping("/list")
	public String list() {
		return "redirect:/list/1";
	}
	// 리스트 페이징
	@GetMapping("/list/{page}")
	public ModelAndView list(@PathVariable("page") int page) {
		ModelAndView mav = new ModelAndView("list");
		int totalCount = campingService.getTotalCount();
		Paging paging = new Paging(page, totalCount);
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("paging", paging);
		List<CampingDTO> list = campingService.selectAll(param);                         
		mav.addObject("list", list);
		mav.addObject("paging", paging);
		return mav;
	}

	@GetMapping({"/searchList", "/mapList"}) 
	public ModelAndView searchList(@RequestParam HashMap<String, Object> param, HttpServletRequest request) {
		int page = 1; 			// 기본 페이지 설정
		if(param.containsKey("page")) {
		    try {
		       page = Integer.parseInt(param.get("page").toString()); 
		    } catch (NumberFormatException e) {
		       e.printStackTrace(); 
		    }
		}
		ModelAndView mav = new ModelAndView(); 
	    if (request.getRequestURI().contains("searchList")) {
	    	mav.setViewName("list");
	    } 
	    else {
	        mav.setViewName("mapList");
	    }
	    int totalCount = request.getRequestURI().contains("searchList") ? campingService.getSearchTotal(param) : campingService.getTotalCount();
		Paging paging = new Paging(page, totalCount);
		param.put("paging", paging);
		List<CampingDTO> list = campingService.search(param);
		mav.addObject("page", page);
		mav.addObject("paging", paging);
		mav.addObject("param", param);
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/view/{camping_idx}")
	public ModelAndView view(@PathVariable("camping_idx") int camping_idx) {
		ModelAndView mav = new ModelAndView("view");
		CampingDTO dto = campingService.selectOne(camping_idx);
		List<CampingDTO> image = campingService.selectOneImage(camping_idx);
		mav.addObject("dto", dto);
		mav.addObject("image", image);
		return mav;
	}
	

}
