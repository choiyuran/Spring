package com.itbank.controller;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/newCamping")
	public void newCamping() {}
	
	@PostMapping("/newCampingSecond")
	public ModelAndView newCamping(@RequestParam HashMap<String, Object> form) {
		ModelAndView mav = new ModelAndView("newCampingSecond");
		mav.addObject("form", form);
		System.out.println("입지 : " + form.get("lctcl"));
		return mav;
	}
	
	@PostMapping("/newCampingThird")
	public ModelAndView newCampingSecond(@RequestParam HashMap<String, Object> param, CampingDTO form) {
		ModelAndView mav = new ModelAndView("newCampingThird");
		mav.addObject("form", form);		// 첫번째 form
		mav.addObject("param", param);		// 두번째 페이지 param
		return mav;
	}
	
	@PostMapping("/newCampingResult")
	public ModelAndView newCampingThird(CampingDTO form, CampingDTO param, @RequestParam HashMap<String, Object> map) {
		ModelAndView mav = new ModelAndView("campingInsert");
//		mav.addObject("form", form);		// 첫번째 페이지 form
//		mav.addObject("param", param);		// 두번째 페이지 param
//		mav.addObject("map", map); 			// 세번째 페이지 form
		// 각 테이블에 등록
		// 1.camping테이블과 camping_img
		int row1 = campingService.campingInsert(form);
		System.out.println("row1 : " + row1);
		int maxCampingIdx = campingService.maxCampingIdx();
		form.setCamping_idx(maxCampingIdx);
		int row2 = campingService.campingImgInsert(form);
		System.out.println("row2 : " + row2);
		
		// 2.camping_activity테이블과 camping_introduce테이블
		param.setCamping_idx(maxCampingIdx);
		int row3 = campingService.activityInsert(param);
		System.out.println("row3 : " + row3);
		int row4 = campingService.introduceInsert(param);
		System.out.println("row4 : " + row4);
		
		// 3.camping_internal테이블과 camping_safety_device테이블과 camping_site테이블
		map.put("maxCampingIdx", maxCampingIdx);
		int row5 = campingService.internalInsert(map);
		System.out.println("row5 : " + row5);
		int row6 = campingService.safetyDeviceInsert(map);
		System.out.println("row6 : " + row6);
		int row7 = campingService.campingSiteInsert(map);
		System.out.println("row7 : " + row7);
		CampingDTO dto = campingService.selectOne(maxCampingIdx);
		mav.addObject("dto", dto);
		return mav; 
	}
	
	@GetMapping("/prevPage")
	public void prevPage() {}
}
