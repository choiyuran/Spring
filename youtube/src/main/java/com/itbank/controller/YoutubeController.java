package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.YoutubeDTO;
import com.itbank.repository.YoutubeDAO;

@Controller
public class YoutubeController {

	@Autowired
	private YoutubeDAO dao;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<YoutubeDTO> list = dao.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/view/{idx}") 
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("view");
		dao.viewCount(idx);
		YoutubeDTO dto = dao.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		int row = dao.delete(idx);
		System.out.println(row + "행이 삭제되었습니다");
		return "redirect:/list";
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("update");
		YoutubeDTO dto = dao.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public String update(YoutubeDTO dto) {
		int row = dao.update(dto);
		System.out.println(row + "행이 업데이트 되었습니다");
		return "redirect:/list";
	}
	
	@GetMapping("/add") 
	public void add() {}
	
	@PostMapping("/add")
	public String add(YoutubeDTO dto) {
		String[] arr = dto.getMovieTag().split(" ");
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].startsWith("width")) {
				arr[i] = "width=\"720\"";
			}
			if(arr[i].startsWith("height")) {
				arr[i] = "height=\"405\"";
			}
		}
		String tag = String.join(" ", arr);
		dto.setMovieTag(tag);
		int row = dao.insert(dto);
		System.out.println(row + "행이 삽입되었습니다");
		
		return "redirect:/list";
	}
	
}
