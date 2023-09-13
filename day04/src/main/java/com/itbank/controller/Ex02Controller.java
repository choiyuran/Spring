package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.ArtistDTO;
import com.itbank.repository.ArtistDAO;

@Controller
@RequestMapping("/ex02")
public class Ex02Controller {
	
	@Autowired
	private ArtistDAO artistDAO;
	
	@GetMapping()			
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/ex02/list");	
		List<ArtistDTO> list = artistDAO.selectAll();
		mav.addObject("list", list);
		return mav;
	}

//	@GetMapping("/board/{boardCategory}/{boardId}/")		문자열을 pathVariable로 보낼때는 가능한 마지막까지 뒤에 슬러시를 붙여주기
	@GetMapping("/view/{id}")		 
	public ModelAndView view(@PathVariable("id") int id) {		// 원래는 파라미터로 인정이 안되는걸 어노테이션을 이용해서 파라미터처럼 사용함(pathVariable)
		ModelAndView mav = new ModelAndView("/ex02/view");
		ArtistDTO dto = artistDAO.selectOne(id);
		mav.addObject("dto", dto);
		return mav;
	}
	
}
