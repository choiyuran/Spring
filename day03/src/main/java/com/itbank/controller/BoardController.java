package com.itbank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = dao.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public ModelAndView add(BoardDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/list");
		int row = dao.insert(dto);
		System.out.println(row + "행이 삽입되었습니다");
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("view");
		dao.viewCount(idx);
		BoardDTO dto = dao.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("update");
		BoardDTO dto = dao.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public ModelAndView update(BoardDTO user) {
		ModelAndView mav = new ModelAndView("updateCon");
		
		BoardDTO dto = dao.selectOne(user.getIdx());
		if(dto.getPassword().equals(user.getPassword())) {
			int row = dao.update(user);
			mav.addObject("row", row);
			System.out.println(row + "행이 업데이트 되었습니다");
		}
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("delete");
		BoardDTO dto = dao.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/delete/{idx}")
	public ModelAndView delete(BoardDTO user) {
		ModelAndView mav = new ModelAndView("delCon");
		BoardDTO dto = dao.selectOne(user.getIdx());
		
		if(dto.getPassword().equals(user.getPassword())) {
			int row = dao.delete(user.getIdx());
			mav.addObject("row", row);
			System.out.println(row + "행이 삭제되었습니다");
		}
		return mav;
	}
	
	@PostMapping("/list")
	public ModelAndView search(String keyword, @RequestParam("type") String type) {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> searchList = new ArrayList<>();
		if(type.equals("title")) {
			searchList = dao.searchTitle(keyword);
		}
		if(type.equals("writer")) {
			searchList = dao.searchWriter(keyword);
		}
		if(type.equals("content")) {
			searchList = dao.searchContent(keyword);
		}
		mav.addObject("searchList", searchList);
		
		if(searchList.isEmpty()) {
			mav.setViewName("fail");
		}
		
		return mav;
	}
	

	

}
