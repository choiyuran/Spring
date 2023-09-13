package com.itbank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@GetMapping()
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/board/list");
		List<BoardDTO> list = boardDAO.selectAll();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping()
	public ModelAndView list(String type, String keyword) {
		ModelAndView mav = new ModelAndView("/board/list");
		List<BoardDTO> searchList = new ArrayList<>();
		if(type.equals("title")) {
			searchList = boardDAO.searchTitle(keyword);
		}
		if(type.equals("writer")) {
			searchList = boardDAO.searchWriter(keyword);
		}
		if(type.equals("content")) {
			searchList = boardDAO.searchContent(keyword);
		}
		
		if(searchList.isEmpty()) {
			mav.setViewName("/board/fail");
		}
		mav.addObject("searchList", searchList);
		return mav;
	}

	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/view");
		boardDAO.viewCount(idx);
		BoardDTO dto = boardDAO.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) {
		int row = boardDAO.insert(dto);
		System.out.println(row + "행이 삽입되었습니다");
		return "redirect:/board";
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/update");
		BoardDTO dto = boardDAO.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/update/{idx}")
	public ModelAndView update(BoardDTO dto) {
		ModelAndView mav = new ModelAndView("/board/comment");
		int row = boardDAO.update(dto);
		System.out.println(row + "행이 업데이트 되었습니다");
		mav.addObject("row", row);
		return mav;
	}
	
	@GetMapping("/delete/{idx}")
	public String delete() {
		return "/board/delete";
	}
	
	
	@PostMapping("/delete/{idx}")
	public ModelAndView delete(BoardDTO dto) {
		ModelAndView mav = new ModelAndView("/board/comment");
		int row = boardDAO.delete(dto);
		System.out.println(row + "행이 삭제되었습니다");
		mav.addObject("row", row);
		return mav;
	}
	
	
}
